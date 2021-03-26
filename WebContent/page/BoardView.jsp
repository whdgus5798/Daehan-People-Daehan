<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/boardDetailCSS.css">
</head>
<body>
	<jsp:include page="../include/header.jsp"/>
<c:if test="${sessionScope.user_id == null }">
	<script>
		alert("회원만이 게시판을 이용할 수 있습니다.");
		location.href="UserLoginForm.jsp";
	</script>
</c:if>
	<div class="boardContainer">
		<div class="detailView">
			<div class="articleHeader">
				<div class="contentTitle">${boardVO.bd_title }</div>
				<div class="articleInform">
					<div class="contentWriter">작성자: ${boardVO.bd_writer }</div>
					<div class="contentDate">작성일자: ${boardVO.bd_date }</div>
					<div class="contentHit">조회수: ${boardVO.bd_hit }</div>
				</div>
			</div>
			<div class="contentDetail">${boardVO.bd_content }</div>
			<div class="option" align = "right">
				<c:if test="${sessionScope.user_id == boardVO.bd_writer }">
					<button type="button" onclick="location.href='boardModify.board?bd_id=${boardVO.bd_id}'" class="btn">수정하기</button>
					<a onclick="return confirm('삭제하시겠습니까?')" href="boardDelete.board?bd_id=${boardVO.bd_id}" class="abtn">삭제하기</a>
				</c:if>
				<button type="button" onclick="location.href='showAllBoard.board'" class="btn">목록보기</button>
			</div>
		</div>
	</div>
	<jsp:include page="../include/footer.jsp"/>
</body>
</html>