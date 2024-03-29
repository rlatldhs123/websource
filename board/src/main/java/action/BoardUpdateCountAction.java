package action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor

public class BoardUpdateCountAction implements Action {

    String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        int bno = Integer.parseInt(req.getParameter("bno"));

        // 페이지 나누기 개념 추가 후 추가 코드

        String page = req.getParameter("page");
        String amount = req.getParameter("amount");
        String criteria = req.getParameter("criteria");

        // 한글일 경우 get 으로 넘어올때 깨짐 => 인코딩
        String keyword = URLEncoder.encode(req.getParameter("keyword"), "utf-8");

        BoardService service = new BoardServiceImpl();

        // 조회수 업데이트

        service.updateRead(bno);

        path += "?bno=" + bno + "&page=" + page + "&amount=" + amount + "&criteria=" + criteria + "&keyword=" + keyword;

        return new ActionForward(path, true);

    }

}
