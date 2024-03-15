<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%
// id name age

// id name age 
// 여기서 가져온 것들은 form 에서 보낸게 아니라  info.jsp 에서 a 태그가 get 방식으로 보내준 것이다
// 왜냐하면 유효 범위가  form  action 부분에 적힌 jsp 위치 까지만 벨류가 닿는 거리이기 때문이다


// String id = request.getParameter("id");
// String name = request.getParameter("id");
// String age = request.getParameter("age");
// 이런건 안된다

// request.setAttribute("id",id); 이 메소드는 값을 오브젝트로 담기에
// 스트링으로 형변환을 해줘야 읽어 낼 수 있다

String id = (String)session.getAttribute("id");
String name = (String)session.getAttribute("name");
String age =(String) session.getAttribute("age");

// HttpSevletRequest : 이 객체의 유효 범위는 제한적이다
// request.getParameter("")  : 이 메소드를 사용해서 사용자의 입력 값을 가지고 올떄  범위가 제한되어 있음
// 이 주소로 가져 올 수 있는건 form 에  액션 부분에 써준 페이지까지만 가능 하다

// 

    // <%-- info.jsp 가 알고 있는 값(사용자 입력 값 db 값)을 다른 페이지랑 공유 --%>
    //       <%-- scope 방식 으로 넘겨주는 법
    //            1) page : 현재 page 잘 안씀
    //            2) request : HttpServletRequest  유효 범위 ***
    //            3) session : HttpSession 유효 범위 *** 브라우저를 닫기 전까지 유효 범위가 살아있다
    //            4) application : 톰캣 서버 범위 잘 안씀
    //            // 스코프 사용 메소드
    //            // setAttribute(), getAttribute()
    //            // 사용 방법 setAttribute("key",값), getAttribute("key")
               
               
               
               
    //            --%>






%>
<h2>세션(session)에서 데이터 가져오기</h2>


<h3> id :<%=id %> </h3>
<h3> name :<%=name%> </h3>
<h3> age :<%=age%> </h3>






