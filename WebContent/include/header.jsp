<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대한사람 대한으로</title>
<link rel="stylesheet" href="../css/includeCSS.css"> 
</head>
<body>
	<header>
		<div class="brand" align = "center">
			<a href="mainPage.page" class="home">대한사람 대한으로</a>
		</div>
		<div align = "center">
		<nav>
			<ul class = "navigator">
				<li><a href="showAllPopularity.page">인기</a></li>
				<li><a href="showAllRoute.page?condition=">코스</a></li>
				<li><a href="showAllFestival.page">축제</a></li>
				<li><a href="showAllBoard.board">건의사항</a></li>
				<c:choose>
					<c:when test="${sessionScope.user_id == null }">
						<li><a href = "../page/UserLoginForm.jsp">LOGIN</a></li>
						<li><a href = "../page/UserAddForm.jsp" style="color:red">JOIN</a></li>				
					</c:when>
					<c:otherwise>
						<li><a href = "MyPage.user">MYPAGE</a></li>
						<li><a href = "Logout.user" style="color:red">LOGOUT</a></li>				
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
		</div>
	</header>
</body>
</html>