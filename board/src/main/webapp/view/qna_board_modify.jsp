<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">Board Modify</h3>
		</div>
		<div style="height:20px"></div>
		<form action="update.do" method="post" role="form">
			<div class="box-body">
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">글쓴이</label>
					<div class="col-sm-10" >
					<input type="text" name="name" size="10" class="form-control"	maxlength='10' value ="${dto.name}">
					</div>
				</div>
				<div class="form-group row">
					<label for="title" class="col-sm-2 col-form-label">제목</label>
					<div class="col-sm-10">
						<input type="text" name="title" size="50" class="form-control"	maxlength='100' value ="${dto.title}">
					</div>
				</div>
				<div class="form-group row">
					<label for="content" class="col-sm-2 col-form-label">내용</label value ="${dto.content}">
					<div class="col-sm-10">
						<textarea name='content' cols='60' class="form-control" rows='15'></textarea>
					</div>
				</div>
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">비밀번호</label>
					<div class="col-sm-10">
						<input type="password" name="password" class="form-control" size="10" maxlength='10' >
					</div>
				</div>
				<div class="form-group row">
					<label for="filename" class="col-sm-2 col-form-label">파일첨부</label>
					<div class="col-sm-10">
					<a href='<c:url value="/view/download.jsp?fileName=${dto.attach}"/>'>${dto.attach}</a>

					</div>
				</div>

				<div style="height:20px"></div>
				<div class="box-footer text-center">
					<button type="submit" class="btn btn-primary">수정</button>
					<button type="button" class="btn btn-danger">목록</button>
				</div>
				<div style="height:20px"></div>
			</div>
			<%--  사용자는 bno 가 필요 없지만 개발자는 필요하기에 숨겨서 보낸다 --%>
			<input type="hidden" name = bno value = "${dto.bno}">
		</form>
	</div>
	<script src='<c:url value="/js/modify.js"/>'></script>
</section>
<%@include file="/include/footer.jsp"%>
