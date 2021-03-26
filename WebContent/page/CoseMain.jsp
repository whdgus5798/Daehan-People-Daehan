<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코스</title>
<link rel="stylesheet" href="../css/routeCSS.css">
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<div class="routeContainer">
		<div class="routeHeader">
			<div class="title" align="left">
				#전체: 총 ${requestScope.cnt} 건
			</div>
			<div class="orderBy" align="right">
				<a href="showAllRoute.page?condition=최신순">최신순</a> | 
				<a href="showAllRoute.page?condition=조회순">조회순</a>
			</div>
		</div>

		<div class="routeContent">
			<table border="0">
				<tr align = "center">
					<th>이미지</th>
					<th>여행지</th>
					<th>조회수</th>
					<th>날짜</th>
				</tr>
				<c:forEach var="vo1" items="${rlist}">
					<tr class="routeData">
						<td align="center" width="280">
							<a href="showOneRoute.page?route_name=${vo1.route_name}">
								<img src="../img/${vo1.route_img}" alt="코스이미지" width="260px" height="170px">
							</a>
						</td>
						<td>
							<a href="showOneRoute.page?route_name=${vo1.route_name}">
								${vo1.route_name}
							</a>
						</td>
						<td align="center">${vo1.route_hit}</td>
						<td align="center">${vo1.route_regdate}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<jsp:include page="../include/footer.jsp" />

</body>
</html>