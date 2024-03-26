package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor

public class BookLeaveAction implements Action {

    String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        MemberDto leaveDto = new MemberDto();

        leaveDto.setUserid(req.getParameter("userid"));
        leaveDto.setPassword(req.getParameter("password"));

        BookService service = new BookServiceImpl();

        if (service.leave(leaveDto)) {

            HttpSession session = req.getSession();
            session.invalidate();

        } else {
            path = "/view/leave.jsp";

        }

        return new ActionForward(path, false);
    }
}
