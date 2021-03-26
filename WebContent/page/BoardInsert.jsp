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
<c:if test="${sessionScope.user_id == null }">
	<script>
		alert("회원만이 게시판을 이용할 수 있습니다.");
		location.href="UserLoginForm.jsp";
	</script>
</c:if>
	<jsp:include page="../include/header.jsp"/>
	<div class="boardContainer">
		<div class="detailView">
			<form action="boardInsert.board" method="post">
			<div class="articleHeader">
				<div class="contentTitle">
					<input type="text" class="titleTextBox" name="title" placeholder="제목을 입력하세요." autofocus>
				</div>
				<div class="articleInform">
					<div class="contentWriter">작성자: ${sessionScope.user_id }</div>
					<div class="contentDate">작성일자:</div>
					<div class="contentHit">조회수:</div>
				</div>
			</div>
			<div class="contentDetail">
				<textarea rows="10px" cols="auto" class="contentTextBox" name="content" placeholder="내용을 입력하세요."></textarea>
			</div>
			<div class="option" align = "right">
				<input type="submit" value="등록하기" class="btn">
				<button type="button" onclick="location.href='showAllBoard.board'" class="btn">목록으로</button>
			</div>
			</form>
		</div>
	</div>
	<jsp:include page="../include/footer.jsp"/>
</body>
</html>