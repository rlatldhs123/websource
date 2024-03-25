package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BookDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor

public class BookSearchAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        // serach.jsp 에서 넘긴 값 가져오기

        String criteria = req.getParameter("criteria");
        String keyword = req.getParameter("keyword");

        // ! 코드 번호 프라이머리 키가 넘어옴

        // 서비스 호출 후
        BookService service = new BookServiceImpl();

        List<BookDto> list = service.searchlistAll(criteria, keyword);

        // 검색결과 받기
        req.setAttribute("list", list);

        return new ActionForward(path, false);

    }

}
