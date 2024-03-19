<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import = "dao.ToDao" %>
<%@ page import = "dto.TodoDto" %>

<%
request.setCharacterEncoding("utf-8"); // 한글 처리

// 제목 클릭시  no 가져오기

String no = request.getParameter("no");








// db 작업
ToDao dao = new ToDao();
TodoDto todo = dao.getRow(no);

// todo 를 read.jsp 에  보여주기


request.setAttribute("todo",todo);




// 화면 이동 (list.jsp)
// response.sendRedirect("list.jsp"); 얘는 못쓴다 

// request 에 담았기에 포워드로 써야 한다 둘은 거의 같이 간다 보면 됌


pageContext.forward("modify.jsp");

%>

