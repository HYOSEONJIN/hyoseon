<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	int result = (Integer)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/default.css">

<style>
</style>
</head>
<body>


	<%@ include file="/include/header.jsp" %>
	
	<%@ include file="/include/nav.jsp" %>


	<div class="contents">
		<h2 class="content_title">회원가입 완료</h2>
		<hr>
		<div class="content">
		
		<%
			if(result>0){
				out.println("회원가입이 정상적으로 처리되었습니다.");
			}else{
				out.println("회원가입이 실패했습니다.");
			}
		%>
		
		</div>
	</div>

	<%@ include file="/include/footer.jsp" %>

</body>
</html>