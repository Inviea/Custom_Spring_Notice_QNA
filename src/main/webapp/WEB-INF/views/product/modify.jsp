<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="../00_header.jsp"></jsp:include>
<jsp:include page="../10_nav.jsp"></jsp:include>
<h2>상품 상세정보</h2>
<form method="post" enctype="multipart/form-data">
	<input type="hidden" name="imgfile" value="${pvo.imgfile }">
	<input type="hidden" name="pageNum" value="${cri.pageNum }">
	<input type="hidden" name="amount" value="${cri.amount }">
	<table class="table table-bordered">
		<tr>
			<th>등록 번호</th>
			<td><input type="text" name="pno" value="${pvo.pno }" readonly
				class="form-control"></td>
		</tr>
		<tr>
			<th>상품이름</th>
			<td><input type="text" name="title" value="${pvo.title }"
				class="form-control"></td>
		</tr>
		<tr>
			<th>등록자</th>
			<td>${pvo.writer }</td>
		</tr>
		<tr>
			<th>최종 수정일</th>
			<td>${pvo.modd8 }</td>
		</tr>
		<tr>
			<th>상세설명</th>
			<td><textarea rows="5" name="content" class="form-control">${pvo.content }</textarea></td>
		</tr>
		<tr>
			<th>기존 이미지</th>
			<td id="imgzone"><c:choose>
					<c:when test="${!pvo.imgfile.equals('NONE') }">
						<img src="/images/${pvo.imgfile }" width="33%">
					</c:when>
					<c:otherwise>
				${pvo.imgfile }
			</c:otherwise>
				</c:choose>
		</tr>
		<tr>
			<th>이미지 수정</th>
			<td><input type="file" name="new_imgfile"
				value="${pvo.imgfile }" class="form-control"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit" class="btn btn-primary">수정 완료</button>
			</td>
	</table>
</form>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function() {
		$(document).on("click", "img", function() {
			let inpno = '<c:out value="${pvo.pno }" />';
			let inimgfile = '<c:out value="${pvo.imgfile }" />';
			if (confirm("삭제 하시겠습니까?")) {
				$.ajax({
					url : "/product/rmimg",
					type : "POST",
					data : {
						pno : inpno,
						imgfile : inimgfile
					}
				}).done(function(result) {
					alert("이미지 삭제를 성공하였습니다.");
					location.replace("/product/detail?pno="+inpno);
				}).fail(function() {
					/* alert("이미지 삭제를 실패하였습니다"); */
				}).always(function() {
					/* $("img").remove();
					$("#imgzone").append().text("NONE"); */
					
				});
			} else {
				choice = 0
			}
		});
	});
</script>
<jsp:include page="../90_footer.jsp"></jsp:include>