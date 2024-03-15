<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%

    //  JSP 내장객체
    //  1) HttpServletRequest request
    //  2) HttpServletResponse response
    //  3) JspWriter out
    //  4) PageContext pageContext : jsp 페이지에 대한 정보를 저장하고 있는 객체


    // sendRedirect(경로)
    // http://localhost:8080/response/response.jsp 요청
    // 다른 경로로 이동
    // response.sendRedirect("/basic/input.html");
    response.sendRedirect("https://www.naver.com");

%>