package action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import dto.SearchDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor

public class BoardDeleteAction implements Action {

    String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        BoardDto delDto = new BoardDto();
        delDto.setBno(Integer.parseInt(req.getParameter("bno")));
        delDto.setPassword(req.getParameter("password"));

        String page = req.getParameter("page");
        String amount = req.getParameter("amount");
        String criteria = req.getParameter("criteria");
        String keyword = URLEncoder.encode(req.getParameter("keyword"), "utf-8");

        BoardService service = new BoardServiceImpl();

        // 삭제를 하기전 bno 를 이용해서 행 조회

        BoardDto dto = service.getRow(delDto.getBno());

        // bno 와 re_ref 가 같다면 원본 글

        if (dto.getBno() == dto.getReRef()) {
            // 비밀번호 확인후 일치 한다면
            // deleteAll 호출

            if (service.pwdCheck(delDto)) {
                service.deleteAll(dto.getReRef());
                path += "?page=" + page + "&amount=" + amount + "&criteria=" + criteria + "&keyword="
                        + keyword;

            } else {

                path = "/view/qna_board_pwdCheck.jsp?bno=" + delDto.getBno() + "&page=" + page + "&amount=" + amount
                        + "&criteria=" + criteria + "&keyword="
                        + keyword;

            }

        }

        if (!service.delete(delDto)) {
            path = "/view/qna_board_pwdCheck.jsp?bno=" + delDto.getBno() + "&page=" + page + "&amount=" + amount
                    + "&criteria=" + criteria + "&keyword="
                    + keyword;

        } else {
            path += "?page=" + page + "&amount=" + amount + "&criteria=" + criteria + "&keyword="
                    + keyword;
        }

        return new ActionForward(path, true);

    }

}
