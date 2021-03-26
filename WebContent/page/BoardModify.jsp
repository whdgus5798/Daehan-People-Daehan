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
			<form action="boardModifyConfirm.board" method="post">
			<div class="articleHeader">
				<div class="contentTitle">
					<input type="text" name="title" class="titleTextBox" value="${boardVO.bd_title }" autofocus>
				</div>
				<div class="articleInform">
					<div class="contentWriter">작성자: ${boardVO.bd_writer }</div>
					<div class="contentDate">작성일자: ${boardVO.bd_date }</div>
					<div class="contentHit">조회수: ${boardVO.bd_hit }</div>
				</div>
			</div>
			<div class="contentDetail">
				<textarea rows="10px" cols="auto" class="contentTextBox" name="content">${boardVO.bd_content }</textarea>
			</div>
			<div class="option" align = "right">
				<input type="submit" value="수정하기" class="btn">
				<input type="hidden" name="bd_id" value="${boardVO.bd_id }">
				<button type="button" onclick="location.href='showAllBoard.board'" class="btn">목록으로</button>
			</div>
			</form>
		</div>
	</div>
	<jsp:include page="../include/footer.jsp"/>
</body>
</html>