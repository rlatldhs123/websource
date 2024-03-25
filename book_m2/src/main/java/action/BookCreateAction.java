package action;

import javax.servlet.http.HttpServletRequest;

import dto.BookDto;
import service.BookService;
import service.BookServiceImpl;

public class BookCreateAction implements Action {

    private String path;

    public BookCreateAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        // 도서 추가 화면에서 넘어오는 데이터 가져 오기

        int code = Integer.parseInt(req.getParameter("code"));
        String title = req.getParameter("title");
        String writer = req.getParameter("writer");
        int price = Integer.parseInt(req.getParameter("price"));
        String description = req.getParameter("description");

        BookDto dto = new BookDto();
        dto.setCode(code);
        dto.setTitle(title);
        dto.setWriter(writer);
        dto.setPrice(price);
        dto.setDescription(description);

        BookService service = new BookServiceImpl();

        boolean result = service.create(dto);

        return new ActionForward(path, false);

        // 서비스 호출 하기

    }

}
