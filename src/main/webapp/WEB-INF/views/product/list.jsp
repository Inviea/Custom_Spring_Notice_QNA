<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="../00_header.jsp"></jsp:include>
<jsp:include page="../10_nav.jsp"></jsp:include>
<h2>상품 목록</h2>
<p>The .table-bordered class adds borders on all sides of the table
	and the cells:</p>
<p class="text-right">
	<a href="/product/write" class="btn btn-outline-primary"> 상품등록</a>
</p>
<table class="table table-bordered table-hover thead-dark">
	<thead>
		<tr>
			<th>등록 번호</th>
			<th>상품명</th>
			<th>등록자</th>
			<th>조회수</th>
			<th>등록날짜</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${list ne null && list.size() != 0 }">
				<c:forEach items="${list }" var="pvo">
					<tr>
						<td>${pvo.pno }</td>
						<td><a href="/product/detail?pno=${pvo.pno }&pageNum=${pgvo.cri.pageNum }&amount=${pgvo.cri.amount }">${pvo.title }</a></td>
						<td>${pvo.writer }</td>
						<td>${pvo.readcount }</td>
						<td>${pvo.modd8 }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5">
						<h3>등록된 상품이 없습니다</h3>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<ul class="pagination">
	<c:if test="${pgvo.prev }">
		<li class="page-item"><a class="page-link" href="/product/list?pageNum=${pgvo.startPage-1 }&amount=${pgvo.cri.amount}">Prev</a></li>
	</c:if>
	<c:forEach var="i" begin="${pgvo.startPage }" end="${pgvo.endPage }">
	<li class="page-item ${pgvo.cri.pageNum == i ? 'active' : '' }">
	<a class="page-link" href="/product/list?pageNum=${i }&amount=${pgvo.cri.amount }">${i }</a></li>
	</c:forEach>
	<c:if test="${pgvo.next }">
		<li class="page-item"><a class="page-link" href="/product/list?pageNum=${pgvo.endPage+1 }&amount=${pgvo.cri.amount}">Next</a></li>
	</c:if>
</ul>
<script>
	let result = '<c:out value="${result}"/>';
	if (result === 'write_ok') {
		alert("상품 등록이 완료되었습니다.");
	} else if (result === 'delete_ok') {
		alert("상품 삭제가  완료되었습니다.");
	}
	result = "";
</script>
<jsp:include page="../90_footer.jsp"></jsp:include>