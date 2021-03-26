<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>축제메인</title>
<link rel="stylesheet" href="../css/festivalCSS.css">
</head>
<body>
	<jsp:include page="../include/header.jsp"></jsp:include>
	<div class = "festivalContainer">
		<table class="mainTable">
			<c:forEach var="vo1" items="${alist1}">
				<tr>
					<td><img src="../img/${vo1.festa_img}" alt="축제이미지"
						width="400px" height="200px"></td>
					<td><a href="showOneFestival.page?festa_name=${vo1.festa_name}">${vo1.festa_name}</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>