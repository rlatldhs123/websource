<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>



<%

// 쿠키 :
//  1) 클라이언트 보관  
//  2) 유효기간 만료 반드시 설정
//  3) 요청이 들어올 때 쿠키 가져올 수 있음  

// 쿠키 저장

Cookie c = new Cookie("name","Hong");
c.setMaxAge(600); // 쿠키 만료 시간
response.addCookie(c); 



%>
<h3> 쿠키 데이터 저장</h3>
<a href="getCookie2.jsp">쿠키 확인</a>