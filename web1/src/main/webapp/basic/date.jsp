<%@ page import= "java.time.LocalTime" %>
<%@ page import= "java.util.Date" %> 
<%--  자바안에 있는 클래스를 실행 할떄 해당 구문과 같이 임포트를 실행 해야 한다 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<h1>현재 시간</h1>
<%-- 1. 자바스크립트 2. 자바

// 404 일때 위치 및 별칭 잘 썼나 확인
// 서버도 확인하고 각파일마다 재저장후 다시 실행 해본다
// 500 에러 개발자 코드 오류 --%>


<%  

Date date = new Date();

out.print(date);

LocalTime currTime = LocalTime.now();
out.print(currTime);

%>
    
</body>
</html>