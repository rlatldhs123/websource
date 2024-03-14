package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//HttpServletRequest : 사용자의 요청 가져오는 객체

//HttpServletResponse : 사용자에게 응답할 때 사용하는 객체

@WebServlet("/hello") // Servlet 별칭을 다는 것

public class HelloServlet extends HttpServlet {
    // 무조건 HttpServlet 을 상속 받아야 함
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // post 방식의 한글은 꺠짐
        // 가져오는 모든 데이터는 String 임
        // req.getParameter("form 요소명") *중요*
        req.setCharacterEncoding("utf-8"); // post로 넘어오는 한글을 인코딩을 해주어야 한글이 안꺠진다
        String id = req.getParameter("id");

        String name = req.getParameter("name");
        // value 가 여러개인 checkbox 값 가져오기
        // 벨류가 여러개이기 때문에 배열로 넘어 온다
        // getParameterValues() 메소드로 받아와야함
        String[] dogs = req.getParameterValues("dog");

        // 응답할 페이지에 대한 셋팅
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        out.print("<ul>");
        out.print("<li> id : " + id + "</li>");
        out.print("<li> name : " + name + "</li>");

        for (String dog : dogs) {
            out.print("<li>dog : " + dog + "</li>");

        }

        out.print("</ui>"); // 정해져 있는 구문

    }

    // http://localhost:8080/web1/input.html 입력한 사이트
    // localhost:8080/hello 404 에러가 뜨면서 나타난 주소

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }
}
