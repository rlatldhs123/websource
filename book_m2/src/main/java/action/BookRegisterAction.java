package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookRegisterAction implements Action {
    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        MemberDto regDto = new MemberDto();

        regDto.setUserid(req.getParameter("userid"));
        regDto.setName(req.getParameter("name"));
        regDto.setPassword(req.getParameter("password"));
        regDto.setEmail(req.getParameter("email"));

        BookService service = new BookServiceImpl();

        if (!service.register(regDto)) {
            path = "/view/register.jsp";

        }

        return new ActionForward(path, true);

    }
}
