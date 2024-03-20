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

@WebServlet("/read")
public class BookReadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 한글 처리
        req.setCharacterEncoding("utf-8");
        // 넘겨준 코드받기
        String code = req.getParameter("code");

        BookDao dao = new BookDao();
        BookDto dto = dao.getRow(code);
        // list 란 이름으로 리스트 담기 스코프에 담기 req
        req.setAttribute("dto", dto);

        RequestDispatcher rd = req.getRequestDispatcher("/view/read.jsp");
        rd.forward(req, resp);
        // 리퀘스트에 담았기에 무조건 포워드

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }

}
