<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file = "../include/header.jsp" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ page import = "dao.ToDao" %>
<%@ page import = "dto.TodoDto" %>
<%@ page import = "java.util.List" %>

<%-- todo list 를 클릭시  => servlet 이동 => (db 작업,작업 결과를 scope에 담고 이동) 
=> list.jsp 에서 결과보여주기 --%>


<%

// DB 연동 하는 코드

ToDao dao = new ToDao();
List<TodoDto> list =dao.getList();



 %>





<h1>Todo list</h1>
<table class="table">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성일</th>
      <th scope="col">완료여부</th>
    </tr>
  </thead>
  <tbody>



  <% for(TodoDto dto:list){%>
    <tr>
      <th scope="row"><%=dto.getNo()%></th>
      <td><a href="readPro.jsp?no=<%=dto.getNo()%>" class="text-decoration-none text-reset"><%=dto.getTitle()%></a></td>
      <td><%=dto.getCreatedAt()%></td>
          <c:out value="${todo.completed?'checked' : ''}"/> >
      <td> 

      <% 

       out.print("<input type='checkbox' class='form-check-input' id='completed'  name='completed' value='true'disabled ");
       if(dto.isCompleted()){

        out.print("checked >");
       }else{
        out.print(">");
       }


       %>

      </td>
    </tr>
    <% } %>
   
  </tbody>
</table>
<%@ include file = "../include/footer.jsp" %>
