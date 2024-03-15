<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<%

// 세션 설정
    session.setAttribute("name","Session Test!!!");
    session.setAttribute("age","25");

    session.setAttribute("q","26");

    session.setAttribute("w","27");

    session.setAttribute("e","28");

    session.setAttribute("r","29");

    session.setAttribute("t","30");

    response.sendRedirect("sessiontest.jsp"); // 페이지 이동 구문



%>