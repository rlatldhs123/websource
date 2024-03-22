<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h1 class="border-bottom mb-3">도서목록</h1>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>도서목록</title>
   
</head>
<body>

<table class="table border-black">
  <thead>
    <tr class="table-success">
      <th scope="col" class="text-center">code</th>
      <th scope="col" class="text-center">title</th>
      <th scope="col" class="text-center">writer</th>
      <th scope="col" class="text-center">price</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="dto" items="${list}">
   <tr>
      <th scope="row" class="text-center">${dto.code}</th>
      <td> <a      href='<c:url value = "/read.do?code=${dto.code}"/>' class="text-decoration-none text-reset">${dto.title}</a></td>
      <td class="text-center">${dto.writer}</td>
      <td class="text-end"><fmt:formatNumber type="number" maxFractionDigits="3" value="${dto.price}" />

      
      
      </td>

    </tr>
      </c:forEach>
  
  
    
  </tbody>
</table>
    
</body>
</html>

<%@ include file="/include/section.jsp" %>
<%@ include file="/include/footer.jsp" %>