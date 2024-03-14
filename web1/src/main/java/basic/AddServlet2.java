package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2") // 별칭은 마음대로 중복 불가
public class AddServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 숫자 리퀘스트 (받아오기) 꼭 네임속성으로만 가져와야 한다
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        String op = req.getParameter("op");

        // 사칙 연산 화면 출력
        res.setContentType("text/html;charset=utf-8");

        PrintWriter out = res.getWriter();
        int result = 0;

        switch (op) {
            case "+":
                result = num1 + num2;

                break;
            case "-":
                result = num1 - num2;

                break;
            case "*":
                result = num1 * num2;

                break;
            case "/":
                result = num1 / num2;

                break;

            default:
                break;
        }
        out.print(num1 + op + num2 + "=" + result);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resq) throws ServletException, IOException {
        doGet(req, resq);

    }

}
