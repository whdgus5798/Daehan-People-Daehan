<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대한사람 대한으로</title>
<link rel="stylesheet" href="../css/mainCSS.css">
 </head>
 
 <body>
 
 <jsp:include page="../include/header.jsp" />
 
 <div class = "back">
	<table border="0" align= "center">
		<tr>
			<td class="title" colspan=2 ><div class = "balloon_01">안전여행 수칙 동영상</div></td>
			<td class="title" colspan=2 ><div class = "balloon_02">인기 코스</div></td>
		</tr>

		<tr>
			<td colspan=2 width=600px align=left>
				<video width="700" height="400" controls autoplay muted>
					<source src="../img/vd_Corona.mp4 " type="video/mp4" />
				</video>
			</td>
			<c:forEach var="vo1" items="${rlist}" begin="0" end="1">
				<td class="block">
				<a href="showOneRoute.page?route_name=${vo1.route_name}">
					${vo1.route_name}<br><br>
					<img src="../img/${vo1.route_img}" alt="이미지없음"/><!-- alt="이미지 실패"--> <br><br> 
				</a>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<td class = "title" colspan="4"><div class = "balloon_03">축제</div></td>
		</tr>
		<tr>
			<c:forEach var="vo1" items="${flist}" begin="0" end="3">
				<td class="block">
				<a href="showOneFestival.page?festa_name=${vo1.festa_name}">
					${vo1.festa_name}<br><br>
					<img src="../img/${vo1.festa_img}" alt="이미지 실패"/><br><br> 
					${vo1.festa_period}
				</a>
				</td>
			</c:forEach>
		</tr>
	</table>
</div>

	<jsp:include page="../include/footer.jsp"></jsp:include>

</body>
</html>