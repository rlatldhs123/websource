<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>




<%!

private String getCookieValue(Cookie[] cookies,String name){
    if(cookies == null) return null;
    for(Cookie c:cookies){
        if(c.getName().equals(name)) return c.getValue();
    }

    return null;
}

// 만료기간 설정이 session 으로 들어오기에 브라우저를 전부 닫으면 그후 쿠키 값은 
// 가져 올 수 없다 


%>

<% 
// 쿠키 가져오기

Cookie[] cookies = request.getCookies();
 %>

  <h4>쿠키 이름 : <%=name %></h4>
