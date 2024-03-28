package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import dto.PageDto;
import dto.SearchDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor

public class BoardListAction implements Action {
    String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        int page = Integer.parseInt(req.getParameter("page"));
        int amount = Integer.parseInt(req.getParameter("amount"));

        String criteria = req.getParameter("criteria");
        String keyword = req.getParameter("keyword");
        SearchDto searchDto = new SearchDto(page, amount, criteria, keyword);

        // BoardService list 호출
        BoardService service = new BoardServiceImpl();

        PageDto pageDto = new PageDto(searchDto, service.getRows(criteria, keyword));

        List<BoardDto> list = service.getList(searchDto);

        req.setAttribute("list", list);
        req.setAttribute("pageDto", pageDto); // pageDto 안에 searchDto 도 포함 되어 있음

        // req 결과 담기

        return new ActionForward(path, false);

    }

}
