<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<%!


// 만료기간 설정이 session 으로 들어오기에 브라우저를 전부 닫으면 그후 쿠키 값은 
// 가져 올 수 없다 


%>

<% 
// 쿠키 가져오기

Cookie[] cookies = request.getCookies();

String name = "";
String value = "";

for(Cookie c:cookies){
    if(c.getName().equals(name)) {
        name=c.getName();
        value = c.getValue();
    }

}

// lombok 자바 개발시 필수로 사용하는 개발 도구
   // 반복작업 어노테이션 처리를  도와줌
 %>

 <h4>쿠키 이름 : <%=name %></h4>
 <h4>쿠키 값 : <%=value %></h4>  
