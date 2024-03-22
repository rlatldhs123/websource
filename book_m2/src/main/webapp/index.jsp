<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/header.jsp" %>
<h1>Main</h1>
<%@ include file="/include/section.jsp" %>
<%@ include file="/include/footer.jsp" %>

<%-- jsp 는  결과 보여주기 및 입력 받기만 하는데 쓰기 --%>
<%-- 서블릿 : dao 연동 --%>
<%-- dao :  db 연동  --%>
<%-- dto :  jsp <==> Sevlet <==> dao 데이터 주고 받기 위한 객체--%>

<%-- jsp 에서 입력되고 나면 서블릿으로 이동 dao 를 거치면서 db 를 연동
   dao 클래스는 db 커넥션을 위해 만들어진 약속된 클래스이다 --%>