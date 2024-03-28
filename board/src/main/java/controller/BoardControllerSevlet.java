package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.BoardCreateAction;
import action.BoardDeleteAction;
import action.BoardListAction;
import action.BoardModifyAction;
import action.BoardReadAction;
import action.BoardReplyAction;
import action.BoardSearchAction;
import action.BoardUpdateCountAction;

@WebServlet("*.do")
@MultipartConfig // 파일 업로드를 지원 해줄 수 있게 해주는 어노테이션
public class BoardControllerSevlet extends HttpServlet {
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

        if (cmd.equals("/qList.do")) {

            action = new BoardListAction("/view/qna_board_list.jsp");

        } else if (cmd.equals("/create.do")) {

            action = new BoardCreateAction("/qList.do");

        } else if (cmd.equals("/qRead.do")) {

            action = new BoardReadAction("/view/qna_board_view.jsp");

        } else if (cmd.equals("/modify.do")) {

            action = new BoardReadAction("/view/qna_board_modify.jsp");

        } else if (cmd.equals("/update.do")) {

            action = new BoardModifyAction("/qRead.do");

        } else if (cmd.equals("/delete.do")) {

            action = new BoardDeleteAction("/qList.do");

        } else if (cmd.equals("/ReplyView.do")) {

            action = new BoardReadAction("/view/qna_board_reply.jsp");

        } else if (cmd.equals("/Reply.do")) {

            action = new BoardReplyAction("/qList.do");

        } else if (cmd.equals("/Count.do")) {

            action = new BoardUpdateCountAction("/qRead.do");
        }

        // } else if (cmd.equals("/search.do")) {

        // action = new BoardSearchAction("/view/qna_board_list.jsp");

        // }

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
