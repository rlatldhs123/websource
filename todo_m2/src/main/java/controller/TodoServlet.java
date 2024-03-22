package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.TodoCrateAction;
import action.TodoListAction;
import action.TodoReadAction;
import action.TodoUpdateAction;
import action.TododeleteAction;
import dao.TodoDao;
import dto.TodoDto;
import service.TodoService;
import service.TodoServiceImpl;

@WebServlet("*.do")
public class TodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 넘어오는 요청에 대해서 한글 처리를 함
        req.setCharacterEncoding("utf-8");
        // 2) 어디에서 온 요청인지 분리를 해야 하는 작업이 필요함
        // 3) 분리된 요청에 따라 Action 을 생성 하게 됨
        // 4) 생성된 action 에게 일 시키기 : action.execute(req);
        // *Action : 사용자가 보낸 정보 가져오기
        // 서비스 호출
        // 서비스 결과에 따라 이동 방식과 이동 경로를 객체로 생성 하게 됌
        // 이동방식 = true (session.setAttribute() or 다시 서블릿으로 요청이 가거니 or 가져갈 값이 없거나 )
        // false (req.setAttribute())

        // 5) 서블릿으로 돌아와서
        // 아래 구문을 실행
        // if (af.isRedirect()) {
        // resp.sendRedirect(af.getPath());
        // } else {
        // RequestDispatcher rd = req.getRequestDispatcher(af.getPath());
        // rd.forward(req, resp);
        // }

        // 3. 사용자에게는 결과 페이지 전송 되게 됨 (jsp)

        // 경로에서 요청 찾기
        String requestUri = req.getRequestURI(); // 8080 이후의 값
        String contextPath = req.getContextPath(); // 프로젝트명
        String cmd = requestUri.substring(contextPath.length()); // /create.do

        // System.out.println("requestUri " + requestUri);
        // System.out.println("contextPath " + contextPath);
        System.out.println("cmd " + cmd);

        Action action = null;

        if (cmd.equals("/list.do")) {
            action = new TodoListAction("/view/list.jsp");

        } else if (cmd.equals("/read.do")) {

            action = new TodoReadAction("/view/read.jsp");

            //
            // todo 를 read.jsp에 보여주기
            // RequestDispatcher rd = req.getRequestDispatcher("/view/read.jsp");
            // rd.forward(req, resp);
        } else if (cmd.equals("/modify.do")) {
            // 제목 클릭 시 no 가져오기

            action = new TodoReadAction("/view/modify.jsp");

        } else if (cmd.equals("/update.do")) {

            action = new TodoUpdateAction("list.do");

            // resp.sendRedirect("/list.do");

        } else if (cmd.equals("/delete.do")) {

            // resp.sendRedirect("/list.do");
            action = new TododeleteAction("/list.do");

        } else if (cmd.equals("/create.do")) {

            // 화면이동(list)
            // resp.sendRedirect("/list.do");
            action = new TodoCrateAction("/list.do");
        }

        ActionForward af = null;

        try {
            af = action.execute(req);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
