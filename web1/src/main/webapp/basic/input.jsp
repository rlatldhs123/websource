<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<%-- jsp 에서 자바코드 쓰는법 

자바코드는 <%   %> 안에 작성 해아함(위치는 상관 없음)
자바 코드 화면 출력은     <&= &>안에 쓰면 된다
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<% 

// for(int i =1; i<11; i++){
//     out.print(i);
// }
// 자바코드는 브라우저 해석이 안되서 톰캣이라고 하는  was 에서 해석해서 브라우저에 데브툴에 보여주는 것

// post 로 가져온 한글이 꺠지기에 만든 구문
//  jsp 내장 객체 이기에 변수명을 맘대로 바꿀 수 없다

// 1) HttpSevlerequest request 해당 변수로 고정
// 2) HttpSevletResponse response 해당 변수로 고정
// 3) Jspwriter out  { PrintWriter out = res.getWriter(); 이 것을 안써도 됌}

request.setCharacterEncoding("utf-8");

   String id = request.getParameter("id");
     String name = request.getParameter("name");
       String[] dogs = request.getParameterValues("dog");

    //    contentType="text/html; charset=UTF-8" 이구문이 이미 위에 있으니 쓸 필요가 없다





%>
<ul>
        <li>id : <%=id%></li>
        <li>name : <%=name%></li>
        <li>name : <% out.print(name);%></li>
        <%   for (String dog : dogs) {
            out.print("<li>dog : " + dog + "</li>");

        } 
        %>
                                                 </ul>
    
</body>
</html>

