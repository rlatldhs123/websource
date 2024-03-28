<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/header.jsp"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>


<%-- 

EL : jsp 에서 사용
    getAttribute("name") == 대신 ${name} 사용가능
    getAttribute("loginDto") , <% loginDto.getName() %> == ${loginDto.name}사용가능
     --%>

<h1 class="mt-5">JSTL</h1>
<c:if test="${5<10}"> 
    <h4>5는 10보다 작다</h4> 
</c:if>

<c:if test="${5+3==9}"> 
    <h4>5+3은 9이다</h4> 
</c:if>

<c:choose>
    <c:when test="${5+10==50}">
        <h4>5+10은 50이다</h4>
    </c:when>
    <c:otherwise>
        <h4>5+10은 50이 아니다</h4>
    </c:otherwise>
</c:choose>

<%-- <c:forEach> 가장 많이 쓴다 --%>

<c:forEach var="test" begin="1" end="10" step="2">
    <b>${test}</b>
</c:forEach>


<%-- <c:out>  </c:out> --%>
<%-- 화면에 뿌려내는 것 --%>

<c:out value="${flag?"OK" : "Error"}"> </c:out>
<c:out value="${flag?'OK' : 'Error'}"/> 
<%-- 위는 간단하게 한 방식 바로 닫을 수 있다 --%>

<%@ include file="../include/footer.jsp"%>
