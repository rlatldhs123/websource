<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h1 class="border-bottom mb-3">도서추가</h1>

<form action="<c:url value='/create' />" method="post">
<div class="mb-3">
  <label for="code" class="form-label">code</label>
  <input type="text" class="form-control" id="code"  name="code" >
</div>
<div class="mb-3">
  <label for="title" class="form-label">title</label>
  <input type="text" class="form-control" id="title"name="title" >
</div>
<div class="mb-3">
  <label for="writer" class="form-label">writer</label>
  <input type="text" class="form-control" id="writer" name="writer" >
</div>
<div class="mb-3">
  <label for="price" class="form-label">price</label>
  <input type="text" class="form-control" id="price"  name="price" >
</div>
<div class="mb-3">
  <label for="description" class="form-label">description</label>
  <textarea class="form-control" id="description" rows="3" name="description">${dto.description}</textarea>
</div>
<div class="mb-3">
<button type="submit" class="btn btn-success">추가</button>
<a href='<c:url value="/list"/>' class="btn btb-primary">목록</a>
</div>
</form>


<%@ include file="/include/section.jsp" %>

<script src="<c:url value='/js/create.js'/>"></script>
<%@ include file="/include/footer.jsp" %>