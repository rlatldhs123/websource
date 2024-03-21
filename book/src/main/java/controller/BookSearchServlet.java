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

@WebServlet("/search")
public class BookSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 검색 기준(criteria) 검색어(키워드) 가져오기

        req.setCharacterEncoding("utf-8");

        String criteria = req.getParameter("criteria");
        String keyword = req.getParameter("keyword");

        BookDao dao = new BookDao();
        List<BookDto> list = dao.getSearchList(criteria, keyword);
        // list 란 이름으로 리스트 담기 스코프에 담기 req
        req.setAttribute("list", list);

        RequestDispatcher rd = req.getRequestDispatcher("/view/list.jsp");
        rd.forward(req, resp);
        // 리퀘스트에 담았기에 무조건 포워드

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }

}
