package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dto.BookDto;

// 삭제 서블릿

@WebServlet("/delete")
public class BookdeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDto deleteDto = new BookDto();

        String code = req.getParameter("code");

        // db 작업

        BookDao dao = new BookDao();

        int result = dao.delete(code);
        if (result > 0) {
            resp.sendRedirect("/list");

        } else {
            resp.sendRedirect("view/delete.jsp");
        }

        // 삭제성공시 list 로
        resp.sendRedirect("/list");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }

}
