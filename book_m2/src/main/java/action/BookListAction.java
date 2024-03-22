package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.BookDao;
import dto.BookDto;
import service.BookService;
import service.BookServiceImpl;

public class BookListAction implements Action {

    private String path;

    public BookListAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        // sevice listall 호출
        // 결과 리퀘스트에 담기

        BookService service = new BookServiceImpl();
        List<BookDto> list = service.listAll();
        req.setAttribute("list", list);

        return new ActionForward(path, false);

    }

}
