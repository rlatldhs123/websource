<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/header.jsp" %>
<h3 class="border-bottom mb-3">도서검색</h3>

<form action="<c:url value='/search.do' />" method="post">

<div class="row mb-3">
  <div class="col">
    <select name="criteria" id="criteria" class="form-select">
    <option selected >검색 조건 선택</option>
    <option value="code">코드</option>
    <option value="writer">작가</option>
    
    </select>
  </div>
  <div class="col">
    <input type="text" class="form-control" placeholder="검색어"name="keyword" id="keyword">
  </div>
</div>
<div>

<button type="submit" class="btn btn-success">검색</button>
<a href='<c:url value="/list.do"/>' class="btn btb-primary">목록</a>
</div>

</form>
<%@ include file="/include/section.jsp" %>
<script src='<c:url value="/js/search.js"/>'></script>
<%@ include file="/include/footer.jsp" %>

<%-- jsp 는  결과 보여주기 및 입력 받기만 하는데 쓰기 --%>
<%-- 서블릿 : dao 연동 --%>
<%-- dao :  db 연동  --%>
<%-- dto :  jsp <==> Sevlet <==> dao 데이터 주고 받기 위한 객체--%>

<%-- jsp 에서 입력되고 나면 서블릿으로 이동 dao 를 거치면서 db 를 연동
   dao 클래스는 db 커넥션을 위해 만들어진 약속된 클래스이다 --%>