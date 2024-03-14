package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add") // 별칭은 마음대로 중복 불가
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));

        // 3 + 4 =7
        res.setContentType("text/html;charset=utf-8");

        PrintWriter out = res.getWriter();
        out.print(num1 + "+" + num2 + "=" + (num1 + num2));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resq) throws ServletException, IOException {
        doGet(req, resq);

    }

}
