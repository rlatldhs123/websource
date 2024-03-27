package action;

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
        System.out.println(dto.getBno());
        dto.setTitle(req.getParameter("title"));
        dto.setContent(req.getParameter("content"));
        dto.setPassword(req.getParameter("password"));

        BoardService service = new BoardServiceImpl();

        if (!service.update(dto)) {
            path = "Modify.do?bno=" + dto.getBno();

        } else {
            path += "?bno=" + dto.getBno();
        }
        return new ActionForward(path, true);
    };

}
