<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file = "../include/header.jsp" %>
<%@ page import = "dao.ToDao" %>
<%@ page import = "dto.TodoDto" %>



  <%-- <% TodoDto todo= (TodoDto)request.getAttribute("todo"); %>
      ${} 를 쓸시 필요가 없어지게 된다 --%>

<h1 class="mt-5">todo Modify</h1>
<%-- /update  가 아닌 update 만 쓴 이유는 뒤에 주소만 바꾸기 되기에  update 만 붙혀서 해당 주소로 이동 --%>
<form action="update.do" method="post"><div class="mb-3">

  <label for="title" class="form-label">title</label>
  <%-- <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="title" name="title" value="<%=todo.getTitle()%>"> --%>
  <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="title" name="title" value="${todo.title}" >
</div>
<div class="mb-3">
  <label for="createdAt" class="form-label">CreatedAt</label>
  <%-- <input type="text" class="form-control" id="createdAt" placeholder="createdAt" name="createdAt"  value="<%=todo.getCreatedAt()%>"> --%>
  <input type="text" class="form-control" id="createdAt" placeholder="createdAt" name="createdAt"  value="${todo.createdAt}" >
</div>
<div class="mb-3">
  <label for="completed" class="form-check-label">completed</label>
  <%-- completed 가  true 면 check 표시   --%>
  <input type="checkbox" class="form-check-input" id="completed"  name="completed" value="true" <c:out value="${todo.completed?'checked' : ''}"/> >
</div>
<div class="mb-3">
  <label for="description" class="form-label">description</label>

  <textarea class="form-control" id="description" rows="3" name="description"  >${todo.description}</textarea>
</div>
<div>

<button class="btn btn-danger" type = "submit">확인</button>
<a class="btn btn-danger" href='<c:url value = "/delete.do?no=${todo.no}"/>'>삭제</a>
<a class="btn btn-success" href='<c:url value="/list.do"/>'>목록</a>
</div>
<input type="hidden"name="no" value="${todo.no}">
</form>
<%-- 여기는 수정 파일이다 수정 버튼을 클릭시 
readonly 속성을 날리기 때문에 수정이 가능 해진다 --%>
<%@ include file = "../include/footer.jsp" %>