package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookLoginAction implements Action {
    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        // userid password 가져오기
        MemberDto dto = new MemberDto();

        dto.setUserid(req.getParameter("userid"));
        dto.setPassword(req.getParameter("password"));

        // 서비스 호출
        BookService service = new BookServiceImpl();
        MemberDto loginDto = service.isLogin(dto);

        // 트루로 결과를 받았다면 받은 정보를 세션에 저장
        if (loginDto != null) {
            HttpSession session = req.getSession();
            session.setAttribute("loginDto", loginDto);
        } else {
            path = "/view/login.jsp";
        }

        // 세션에 저장했기에 sendRedirect 로 이동 이동위치는 리스트 페이지로

        return new ActionForward(path, true);

    }

}
