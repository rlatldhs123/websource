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
    <%
    HttpSession session = request.getSession();

    //  JSP 내장객체
    //  1) HttpServletRequest request
    //  2) HttpServletResponse response
    //  3) JspWriter out
    //  4) PageContext pageContext : jsp 페이지에 대한 정보를 저장하고 있는 객체
    //      1) forward()
    //      2) include("포함할 페이지 경로") : ex) 디자인 템플릿 구성 시 사용


    // sendRedirect(경로)
    // http://localhost:8080/response/response.jsp 요청    
    // response.sendRedirect("/basic/input.html"); 페이지가 보여짐
    // url 도 이동된 주소로 변경됨

    // 5)HttpSession session 
    //     세션 : 특정 서버와 연결된 상태
    //     https or http 프로토콜 특징
    //    -무상태 (stateless) <==> 상태 (stateful)
//          클라이언트 상태를 저장하지 ㅇ낳음
//          상태 저장 필요하다면
//          1) 서버 측에 저장 - 세션
//          2) 클라이언트 측에 저장 - 쿠키/ 브라우저에 저장
// 브라우저가 다르면 크롬 OR 엣지 브라우저당 벨류가 전부 다르다 
// 새창에서 열어도 사용자가 다르지 않으면 벨류 값은 똑같다 벨류값 보기는 데브툴즈 -> 어플리케이션 -> 쿠키 에서 본다










%>


<h2>세션 테스트</h2>
<ul>
  <li> isNew() : <%=session.isNew() %></li>
  <li> 생성 시간 : <%=session.getCreationTime() %></li>
  <li> 최종접속시간 : <%=session.getLasAccessedTime() %></li>
 <li> 세션id : <%=session.getId() %></li>
</ul>
</body>
</html>