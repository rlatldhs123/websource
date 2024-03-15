<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%
// info2.jsp 에 부여된  reqiest 를 forward.jsp 를 넘겨 주는 것


String id = request.getParameter("id");
// 가져 올 수 있음!!
//pageContext.forward("forward.jsp"); 구문 덕분임
//request 이여서 forward 를 써야지 여기까지 가져 올 수 있다



// ScopeServlet(info2.jsp) 에 할 수 있는작업들을  forward.jsp 에서도 할 수 있게 됨 






%>

<h3>forward.jsp</h3>

<h4><%= id %></h4>