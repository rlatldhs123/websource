package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor

public class BoardListAction implements Action {
    String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        // BoardService list 호출

        BoardService service = new BoardServiceImpl();

        List<BoardDto> list = service.getList();

        req.setAttribute("list", list);

        // req 결과 담기

        return new ActionForward(path, false);

    }

}
