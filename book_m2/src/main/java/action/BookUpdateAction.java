package action;

import javax.servlet.http.HttpServletRequest;

import dto.BookDto;
import service.BookService;
import service.BookServiceImpl;

public class BookUpdateAction implements Action {

    private String path;

    public BookUpdateAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        String code = req.getParameter("code");

        String price = req.getParameter("price");

        BookDto modifyDto = new BookDto();

        modifyDto.setCode(Integer.parseInt(code));
        modifyDto.setPrice(Integer.parseInt(price));

        BookService service = new BookServiceImpl();

        boolean result = service.update(modifyDto);
        if (result) {

            path += "?code=" + modifyDto.getCode();
        } else {
            path = "/view/modify.jsp";
        }

        // 수정 내용을 read로 보여주기

        return new ActionForward(path, true);

    }

}
