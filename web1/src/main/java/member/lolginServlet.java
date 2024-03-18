package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class lolginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 가져오는 데이터 한글 처리
        req.setCharacterEncoding("utf-8");
        // 사용자가 전송한 데이터 가져오기
        String userid = req.getParameter("userid");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        // DTO = DB 작업 이후 상황 DTO 에는 디비를 거쳐 정보를 가져왔다
        MemberDTO dto = new MemberDTO(userid, password, name);
        // DTO 로그인 정보를 세션에 담아준다

        // 세션을 서블릿에서 사용하기 위해 객체를 생성 한다
        HttpSession session = req.getSession();

        session.setAttribute("loginDto", dto);

        // 위 코드가 끝나면 페이지를 해당 페이지로 이동
        // 세션에 담고 이 구문으로 페이지를 다시 처음으로 이동
        res.sendRedirect("/index.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
