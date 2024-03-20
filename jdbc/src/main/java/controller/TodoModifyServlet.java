package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ToDao;
import dto.TodoDto;

// 별칭 @WebServlet("/read")
@WebServlet("/modify")
public class TodoModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // DB 연동
        req.setCharacterEncoding("utf-8"); // 한글 처리

        // 제목 클릭시 no 가져오기

        String no = req.getParameter("no");

        // db 작업
        ToDao dao = new ToDao();
        TodoDto todo = dao.getRow(no);

        // todo 를 modify.jsp 에 보여주기

        req.setAttribute("todo", todo);
        RequestDispatcher rd = req.getRequestDispatcher("/view/.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
