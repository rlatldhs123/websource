package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.BookCreateAction;
import action.BookDeleteAction;
import action.BookListAction;
import action.BookReadAction;
import action.BookUpdateAction;
import action.BookDeleteAction;

@WebServlet("*.do")
public class BookControllerSevlet extends HttpServlet {
    @Override
    // 사용자의 요청을 받고싶으면 req 의 객채가 있어야 한다
    // 그러해서 바로 아래 있는 req 를 af=action.execute(req); 이러한 식으로 넘긴다
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 한글처리
        req.setCharacterEncoding("utf-8");
        // *********************************

        // URI 분리 작업

        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        String cmd = requestURI.substring(contextPath.length());
        // *********************************

        // cmd 를 가지고 액션을 생성 해야 함

        Action action = null;
        if (cmd.equals("/list.do")) {
            // 작업이 끝난 후 보여줄 페이지 경로를 적어주면 된다
            action = new BookListAction("view/list.jsp");
        }
        // 생성된 action 에게 일을 시키기(원래는 서블릿이 전부 담당하고 해야 했던 일 이지만 액션에게 넘긴다)
        else if (cmd.equals("/create.do")) {
            // 작업이 끝난 후 보여줄 페이지 경로를 적어주면 된다
            action = new BookCreateAction("/list.do");
        } else if (cmd.equals("/read.do")) {
            // 작업이 끝난 후 보여줄 페이지 경로를 적어주면 된다
            action = new BookReadAction("/view/read.jsp");

        } else if (cmd.equals("/update.do")) {
            // 작업이 끝난 후 보여줄 페이지 경로를 적어주면 된다
            action = new BookUpdateAction("/read.do");
        } else if (cmd.equals("/.do")) {
            // 작업이 끝난 후 보여줄 페이지 경로를 적어주면 된다
            action = new BookUpdateAction("/read.do");
        } else if (cmd.equals("/delete.do")) {
            // 작업이 끝난 후 보여줄 페이지 경로를 적어주면 된다
            action = new BookDeleteAction("/list.do");
        }

        // --------------------------------------------------------------------------------------------------------------------
        // --------------------------------------------------------------------------------------------------------------------
        // --------------------------------------------------------------------------------------------------------------------
        ActionForward af = null;
        try {
            af = action.execute(req); // 이렇게만 쓰면 엑션인이 난다 그러니 일하다가 익셉션이 나면 오류가 나는 것이기에 트라이 캐치를 한다

        } catch (Exception e) {

            e.printStackTrace();
        }

        // 이동 방식과 경로에 따라 움직이기
        if (af.isRedirect()) {
            resp.sendRedirect(af.getPath());

        } else {
            RequestDispatcher rd = req.getRequestDispatcher(af.getPath());
            rd.forward(req, resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
