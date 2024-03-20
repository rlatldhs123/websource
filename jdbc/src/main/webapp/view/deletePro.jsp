    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ page import = "dao.ToDao" %>


    <%
    request.setCharacterEncoding("utf-8"); // 한글 처리



    // 체크박스 라디오 요소에  value 가 없는 경우에는  on  값을 가지고 오게 됨

    // 제목 클릭시  no 가져오기
    String no =  request.getParameter("no");

    // db 작업
    ToDao dao = new ToDao();

    int result= dao.delete(no);

    response.sendRedirect("list.jsp");


    // todo 를 read.jsp 에  보여주기





    // 화면 이동 (list.jsp)
    // response.sendRedirect("list.jsp"); 얘는 못쓴다 

    // request 에 담았기에 포워드로 써야 한다 둘은 거의 같이 간다 보면 됌







    %>

