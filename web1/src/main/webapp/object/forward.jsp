<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%

    //  JSP 내장객체
    //  1) HttpServletRequest request
    //  2) HttpServletResponse response
    //  3) JspWriter out
    //  4) PageContext pageContext : jsp 페이지에 대한 정보를 저장하고 있는 객체
    //      1) forward()
    //      2) include("포함할 페이지 경로") : ex) 디자인 템플릿 구성 시 사용

    // http://localhost:8080/object/forward.jsp 요청
    // forward("content.jsp") 에 있는 페이지가 화면에 보여짐
    // 주소는 요청 주소인 상태
    pageContext.forward("content.jsp");

%>