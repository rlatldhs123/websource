package action;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
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

        BoardService service = new BoardServiceImpl();

        if (!service.delete(delDto)) {
            path = "/view/qna_Board_pwdCheck.jsp?bno=" + delDto.getBno();

        }

        return new ActionForward(path, true);

    }

}
