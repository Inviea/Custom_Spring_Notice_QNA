<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="00_header.jsp"></jsp:include>
<jsp:include page="10_nav.jsp"></jsp:include>
<div class="jumbotron jumbotron-fluid mt-5">
  <div class="container">
    <h1>Spring test</h1>
    <p>Bootstrap is the most popular HTML, CSS...</p>
    <p>Now = ${serverTime }</p>
  </div>
</div>

<jsp:include page="90_footer.jsp"></jsp:include>