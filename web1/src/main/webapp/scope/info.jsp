<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>


<%
request.setCharacterEncoding("utf-8"); // 가져오는 한글 안꺠지게 하느 ㄴ코드


String id = request.getParameter("id");
String name = request.getParameter("name");
String age = request.getParameter("age");





//  <h3> id :<%= id %> </h3>
// <h3> name :<%= name %> </h3>
// <h3> age :<%= age %> </h3> 


// request  스코프를 사용해서 값을 담는 구문

request.setAttribute("id",id);
request.setAttribute("name",name);
request.setAttribute("age",age);


// info.jsp 에 부여된  reqiest 를 next.jsp 를 넘겨 주는 것
// info.jsp 에 할 수 있는작업들을  next.jsp 에서도 할 수 있게 됨 
pageContext.forward("next.jsp");



%>


 <h3> id :<%= id %> </h3>
<h3> name :<%= name %> </h3>
<h3> age :<%= age %> </h3>





<%-- 

 sesiion 스코프 사용
 session.setAttribute("id",id);
 session.setAttribute("name",name);
 session.setAttribute("age",age);


경로에 적힌 유알엘 과 내용을 보게 된다
 response.sendRedirect()
PageContext.forward(); 







밑에 방식으로 넘기느 방식이 post 방식이다

   <form action="next.jsp" method="post">
      <div>
        <label for="id">id</label>
        <input type="text" name="id" id="id" vlaue="<%=id%>" readonly/>
      </div>
      <div>
        <label for="name">이름</label>
        <input type="text" name="name" id="name"vlaue="<%=name%>" readonly/>
      </div>
      <div>
        <label for="age">나이</label>
        <input type="text" name="age" id="age"vlaue="<%=age%>" readonly/>
      </div>
      <div>
        <button type="submit">전송</button>
      </div>
    </form> 

    <a href="next.jsp?id=<%= id %>&name=<%= name %>&age=<%= age %>">다음 페이지</a>
          위 방식대로get 방식으로 어거지로 만들어서 보내느 방법이 있다 
가져오는 방식은 get / post 방식으로 넘기면 된다 a 태그에서 한 방식은 get 방식이다
          하지만 이방식은 비밀번호 같은 중요한 정보들은  a 태그나 url 코드에 정보가 다보이기 때문에 get은 중요정보를 넘기는데 쓰지는 않는다 

     info.jsp 가 알고 있는 값(사용자 입력 값 db 값)을 다른 페이지랑 공유 
       scope 방식 으로 넘겨주는 법
               1) page : 현재 page 잘 안씀
               2) request : HttpServletRequest  유효 범위 ***
               3) session : HttpSession 유효 범위 *** 브라우저를 닫기 전까지 유효 범위가 살아있다
               4) application : 톰캣 서버 범위 잘 안씀
               // 스코프 사용 메소드
               // setAttribute(), getAttribute()
               // 사용 방법 setAttribute("key",값), getAttribute("key") 
               
          
               
               
              

 <h3>
    <a href="next.jsp">다음 페이지</a>
</h3>  --%>
