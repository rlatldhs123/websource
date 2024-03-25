<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/header.jsp" %>
<h1>register</h1>
<form action="<c:url value='/register.do' />" method="post">
    <div class="mb-3 row">
        <label for="userid" class="col-sm-2 col-form-label">아이디</label>
        <div class="col-sm-5">
        <input type="text" class="form-control" id="userid" name="userid">
        </div>
         <div class="col-sm-5">
         <span class="form-text">아이디는 영문자 및 숫자를 이용해 6~12 자리로 작성해주세요</span>
        </div>

          <div class="mb-3 row">
            <label for="password" class="col-sm-2 col-form-label">패스워드</label>
            <div class="col-sm-5">
            <input type="password" class="form-control" id="password" name="password">
        </div>
          <div class="col-sm-5">
         <span class="form-text">비밀번호는 영문자 및 숫자 특수문자를 이용해 이용해 8~12 자리로 작성해주세요</span>
        </div>
          <div class="mb-3 row">
            <label for="name" class="col-sm-2 col-form-label">이름</label>
            <div class="col-sm-10">
            <input type="text" class="form-control" id="name" name="name">
        </div>
         <div class="mb-3 row">
            <label for="email" class="col-sm-2 col-form-label">이메일</label>
            <div class="col-sm-10">
            <input type="email" class="form-control" id="email" name="email">
        </div>

        <div class="form-group">
          <button type="submit" class="btn btn-success">회원가입</button></div>
          <button type="reset" class="btn btn-danger">취소</button></div>



</form>
<%@ include file="/include/section.jsp" %>
<%@ include file="/include/footer.jsp" %>