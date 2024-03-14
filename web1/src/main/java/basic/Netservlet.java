package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// "/net" URL에 매핑되는 서블릿
@WebServlet("/net")
public class Netservlet extends HttpServlet {

    // HTTP GET 요청을 처리하는 메서드
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 응답으로 HTML 형식의 컨텐츠를 보낼 것임을 설정
        res.setContentType("text/html;charset=utf-8");
        // HTML 컨텐츠를 작성하기 위한 PrintWriter 객체 생성
        PrintWriter out = res.getWriter();

        // HttpServletRequest 객체로부터 다양한 정보를 가져와서 출력
        // 1. 사용자 입력 가져오기

        // 요청 스킴을 가져옴 (http, https 등)
        out.print("Requset Scheme : " + req.getScheme() + "<br>" + "<br>");

        // 서버의 호스트명을 가져옴
        out.print("getServerName : " + req.getServerName() + "<br>" + "<br>");

        // 서버의 로컬 IP 주소를 가져옴
        out.print("getLocalAddr : " + req.getLocalAddr() + "<br>" + "<br>");

        // 서버가 리스닝하는 포트를 가져옴
        out.print("getServerPort : " + req.getServerPort() + "<br>" + "<br>");

        // 클라이언트의 IP 주소를 가져옴
        out.print("getRemoteAddr : " + req.getRemoteAddr() + "<br>" + "<br>");

        // 클라이언트의 호스트명을 가져옴
        out.print("getRemoteHost : " + req.getRemoteHost() + "<br>" + "<br>");

        // 클라이언트의 포트 번호를 가져옴
        out.print("getRemotePort : " + req.getRemotePort() + "<br>" + "<br>");

        // 요청 URI를 가져옴
        out.print("getRequestURI : " + req.getRequestURI() + "<br>" + "<br>");

        // 요청 URL을 가져옴
        out.print("getRequestURL : " + req.getRequestURL() + "<br>" + "<br>");

        // 컨텍스트 경로를 가져옴
        out.print("getContextPath : " + req.getContextPath() + "<br>" + "<br>");

        // 서블릿 경로를 가져옴
        out.print("getServletPath : " + req.getServletPath() + "<br>" + "<br>");
    }

    // HTTP POST 요청을 처리하는 메서드
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // doPost() 메서드에서는 doGet() 메서드로 요청을 위임한다.
        doGet(req, resp);
    }
}
