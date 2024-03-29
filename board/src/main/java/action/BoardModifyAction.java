package action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor

public class BoardModifyAction implements Action {

    String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        BoardDto dto = new BoardDto();

        dto.setBno(Integer.parseInt(req.getParameter("bno")));

        dto.setTitle(req.getParameter("title"));
        dto.setContent(req.getParameter("content"));
        dto.setPassword(req.getParameter("password"));

        // 페이지 나누기 개념 추가 후

        String page = req.getParameter("page");
        String amount = req.getParameter("amount");
        String criteria = req.getParameter("criteria");
        String keyword = URLEncoder.encode(req.getParameter("keyword"), "utf-8");

        BoardService service = new BoardServiceImpl();

        if (!service.update(dto)) {
            path = "Modify.do?bno=" + dto.getBno() + "&page=" + page + "&amount=" + amount + "&criteria=" + criteria
                    + "&keyword=" + keyword;

        } else {
            path += "?bno=" + dto.getBno() + "&page=" + page + "&amount=" + amount + "&criteria=" + criteria
                    + "&keyword=" + keyword;

        }
        return new ActionForward(path, true);
    };

}
