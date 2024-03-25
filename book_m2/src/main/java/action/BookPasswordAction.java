package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.ChangeDto;
import dto.MemberDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor

public class BookPasswordAction implements Action {
    String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        // pwdChange.jsp에서 넘긴 값 가져오기

        String password = req.getParameter("password");
        String newPassword = req.getParameter("new-password");
        String confirmPassword = req.getParameter("confirm-password");

        // 아이디와 현재 비밀번호를 가지고 확인(서비스 메소드 호출)

        HttpSession session = req.getSession();
        MemberDto loginDto = (MemberDto) session.getAttribute("loginDto");

        ChangeDto changeDto = new ChangeDto();
        changeDto.setUserid(loginDto.getUserid());
        changeDto.setNewPassword(newPassword);
        if (changeDto.newPasswordEqualsConfirmPassword()) {
            // 세션에 담긴 아이디와 사용자가 입력한 현재 비밀 번호를 가지고 있는 객체

            MemberDto input = new MemberDto();
            input.setUserid(loginDto.getUserid());
            input.setPassword(password);

            BookService service = new BookServiceImpl();
            if (service.isLogin(input) == null) {
                path = "/view/pwdChange.jsp";

            } else {
                // 사용자가 존재한다면 비밀번호 변경 메소드 호출
                if (service.passwordChange(changeDto)) {

                    session.invalidate();
                } else { // 여기 안에 있는 else 구문은 변경 실패시 다시 돌아가는 코드
                    path = "/view/pwdChange.jsp";
                }

            }

        } else {
            // 여기 안에 있는 else 구문은 newPasswordEqualsConfirmPassword 메소드를
            // 돌렸을떄 비번이 일치하지 않으면 다시 입력하라고 돌아가는 코드
            path = "/view/pwdChange.jsp";
        }
        return new ActionForward(path, true);
    }
}
