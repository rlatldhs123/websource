package action;

import java.lang.reflect.Member;

import javax.servlet.http.HttpServletRequest;

import dto.MemberDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor

public class BookLeaveAction implements Action {

    String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        MemberDto leavDto = new MemberDto();

        leavDto.setUserid(req.getParameter("userid"));

        BookService service = new BookServiceImpl();

        if (!service.leave(leavDto)) {
            path = "/leave.do";

        }

        return new ActionForward(path, false);

    }

}
