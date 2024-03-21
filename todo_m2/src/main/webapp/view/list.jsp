<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file = "/include/header.jsp" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>




<%-- todo list 를 클릭시  => servlet 이동 => (db 작업,작업 결과를 scope에 담고 이동) 
=> list.jsp 에서 결과보여주기 --%>
















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

<%-- setAttribute 에 쓴 걸 써야한다 {items = }는 --%>




  <c:forEach var="dto" items="${list}">
    <tr>
      <th scope="row">${dto.no}</th>
      <td><a href='<c:url value="/read.do?no=${dto.no}"/>' class="text-decoration-none text-reset">${dto.title}</a></td>
      <td>${dto.createdAt}</td>
          <c:out value="${todo.completed?'checked' : ''}"/> >
      <td> 
       <input type="checkbox" class="form-check-input" id="completed"  name="completed" value="true" <c:out value="${dto.completed?'checked' : ''}"/> >

      </td>
    </tr>
  </c:forEach>
   
  </tbody>
</table>
<%@ include file = "../include/footer.jsp" %>
