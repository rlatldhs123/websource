<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">Board Reply</h3>
		</div>
		<div style="height:20px"></div>
		<form action='<c:url value="/Reply.do "/>' method="post" role="form">
			<div class="box-body">
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">작성자</label>
					<div class="col-sm-10">
						<input type="text" name="name" size="10" class="form-control"
								maxlength='10'>
					</div>
				</div>
				<div class="form-group row">
					<label for="title" class="col-sm-2 col-form-label">제목</label>
					<div class="col-sm-10">
						<input type="text" name="title" size="50" class="form-control" maxlength='100' vlaue = "RE:${dto.title}" >
					</div>
				</div>
				<div class="form-group row">
					<label for="content" class="col-sm-2 col-form-label">내용</label>
					<div class="col-sm-10">
						<textarea name='content' cols='60' class="form-control" rows='15'>RE:${dto.content}</textarea>
					</div>
				</div>
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">비밀번호</label>
					<div class="col-sm-10">
						<input type="password" name="password" class="form-control" size="10" maxlength='10'>
					</div>
				</div>
				<div class="form-group row">
					<label for="filename" class="col-sm-2 col-form-label">파일첨부</label>
					<div class="col-sm-10">

					</div>
				</div>
				<div class="box-footer text-center">
					<button type="submit" class="btn btn-primary">등록</button>
					<button type="reset" class="btn btn-danger">취소</button>
				</div>
				<div style="height:20px"></div>
			</div>
			<%-- 원본글 정보 담아준 것 --%>
			<input type="hidden" name="reRef" value = "${dto.reRef}">
			<input type="hidden" name="reSeq" value = "${dto.reSeq}">
			<input type="hidden" name="reLev" value = "${dto.reLev}">
			<input type="hidden" name="bno" value = "${dto.bno}">


			<%-- 페이지 나누기 정보 --%>


				 <input type="hidden" name="page" value = "${searchDto.page}">
				<input type="hidden" name="amount" value = "${searchDto.amount}">
				<input type="hidden" name="criteria" value = "${searchDto.criteria}">
				<input type="hidden" name="keyword" value = "${searchDto.keyword}">
		</form>
	</div>
</section>
<%@include file="../include/footer.jsp"%>
