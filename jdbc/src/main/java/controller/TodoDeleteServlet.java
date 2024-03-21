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
@WebServlet("/delete")
public class TodoDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8"); // 한글 처리

        // 체크박스 라디오 요소에 value 가 없는 경우에는 on 값을 가지고 오게 됨

        // 제목 클릭시 no 가져오기
        String no = req.getParameter("code");

        // db 작업
        ToDao dao = new ToDao();

        int result = dao.delete(no);

        resp.sendRedirect("list");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
