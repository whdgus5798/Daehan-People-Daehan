<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/boardCSS.css">
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
		<div class="boardTitle">
			<div class="title">건의사항</div>
		</div>
		<table border = "0">
			<thead>
				<tr>
					<th>글번호</th>
					<th>글쓴이</th>
					<th>글제목</th>
					<th>글쓴날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo1" items="${boardList}">
					<tr>
						<td>${vo1.bd_id}</td>
						<td>${vo1.bd_writer}</td>
						<td><a href="showBoardInfo.board?bd_id=${vo1.bd_id}">${vo1.bd_title}</a></td>
						<td>${vo1.bd_date}</td>
						<td>${vo1.bd_hit}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" id="td_btn" align="right">
						<form action="searchBoard.board">
							<input type = "text" name = "keyword" placeholder="제목검색" class="searchBox">
							<input type="submit" value="검색" class="btn_search">
							<button type = "button" class="btn_insertForm" onclick="location.href='./BoardInsert.jsp'">글쓰기</button>
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<jsp:include page="../include/footer.jsp"/>
</body>
</html>