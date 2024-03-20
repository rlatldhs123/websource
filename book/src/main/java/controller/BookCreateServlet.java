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

@WebServlet("/create")
public class BookCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 한글 처리
        req.setCharacterEncoding("utf-8");
        // Integer.parseInt 가 공백이 넘어오면 => 익셉션발동으로 프로그램이 먹통이 됌
        // 넘겨준 코드받기
        String code = req.getParameter("code");
        String title = req.getParameter("title");
        String writer = req.getParameter("writer");
        String price = req.getParameter("price");
        String description = req.getParameter("description");

        BookDao dao = new BookDao();
        BookDto inserDto = new BookDto();

        inserDto.setCode(Integer.parseInt(code));
        inserDto.setTitle(title);
        inserDto.setWriter(writer);
        inserDto.setPrice(Integer.parseInt(price));
        inserDto.setDescription(description);

        int result = dao.insert(inserDto);

        if (result > 0) {
            resp.sendRedirect("list");

        } else {
            resp.sendRedirect("/view/create.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }

}
