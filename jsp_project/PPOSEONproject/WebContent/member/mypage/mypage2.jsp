<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/loginCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default.css">

<style>
</style>
</head>
<body>


	<%@ include file="/include/header.jsp"%>

	<%@ include file="/include/nav.jsp"%>


	<div class="contents">
		<h2 class="content_title">my page 2</h2>
		<hr>
		<div class="content">

			<%=session.getAttribute("loginInfo")%>

		</div>
	</div>

	<%@ include file="/include/footer.jsp"%>

</body>
</html>