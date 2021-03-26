<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/header.jsp"/>
<title>Insert title here</title>
<link rel="stylesheet" href="../css/popularCSS.css">
</head>
<body>
	<div class="popularContainer">
		<div class="mainTitle" align="center">
			<span class="title"> 12월 인기여행지 top5 </span>
		</div>
		<div class="table">
			<table>
				<tr>
					<c:forEach var="vo1" items="${plist1}" begin="0" end="4">
						<td class="images">
							<a href="showOnePopularity.page?popular_name=${vo1.popular_name }">
								<img src="../img/${vo1.popular_img}" alt="인기이미지" width="300px" height="200px">
							</a>
						</td>
					</c:forEach>
				</tr>
				<tr align="center">
					<c:forEach var="vo1" items="${plist1 }" begin="0" end="4">
						<td class="subTitle">
							<a href="showOnePopularity.page?popular_name=${vo1.popular_name }">
								${vo1.popular_name }
							</a>
						</td>
					</c:forEach>
				</tr>
			</table>
		</div>
		<div class="mainTitle" align="center">
			<span class="title">SNS 인기여행지 top5</span>
		</div>
		<div class="table">
		<table>
			<tr>
				<c:forEach var="vo2" items="${plist1 }" begin="5" end="9">
					<td class="images">
						<a href="showOnePopularity.page?popular_name=${vo2.popular_name }">
							<img src="../img/${vo2.popular_img}" alt="인기이미지" width="300px" height="200px">
						</a>
					</td>
				</c:forEach>
			</tr>

			<tr align="center">
				<c:forEach var="vo1" items="${plist1 }" begin="5" end="9">
					<td class="subTitle">
						<a href="showOnePopularity.page?popular_name=${vo1.popular_name }">
							${vo1.popular_name }
						</a>
					</td>
				</c:forEach>
			</tr>
		</table>
		</div>
	</div>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>