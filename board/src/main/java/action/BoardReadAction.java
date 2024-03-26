package action;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor

public class BoardReadAction implements Action {

    String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        String bno = req.getParameter("bno");

        BoardService service = new BoardServiceImpl();

        BoardDto dto = service.getRow(Integer.parseInt(bno));

        req.setAttribute("dto", dto);

        return new ActionForward(path, false);

    }

}
