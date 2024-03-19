<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ page import = "dao.ToDao" %>
<%@ page import = "dto.TodoDto" %>


<%-- 타이틀 (제목)에 클릭이 일어남 그 제목에 할당된 번호 (no) 를 리드 프로에 넘기고 싶음 --%>

<%
request.setCharacterEncoding("utf-8"); // 한글 처리


// 사용자가 입력한  todo 가져오기
String title = request.getParameter("title");
String description = request.getParameter("description");




// db 작업
ToDao dao = new ToDao();
TodoDto inserDto = new TodoDto();

inserDto.setTitle(title);
inserDto.setDescription(description);

int result=dao.insert(inserDto);


// 화면 이동 (list.jsp)
response.sendRedirect("list.jsp");

%>
