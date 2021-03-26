<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/userCSS.css">
</head>
<body>
<jsp:include page="../include/header.jsp"/>
	<div class="userContainer">
		<div class="title" align="center">My Page</div>
		<div class="pageContent" align="center">
			<div class="">${vo.user_id}(${vo.user_name}) 님의 마이페이지입니다.</div>
			<div class="pageSubContent">아이디: ${vo.user_id}</div>
			<div class="pageSubContent">이름: ${vo.user_name}</div>
			<div class="pageSubContent">비밀번호: ${vo.user_pw}</div>
		</div>
		<div class="userOption" align="center">
			<div align="center"><a href="userUpdate.user">정보 수정</a></div>
			<div align="center"><a onclick="return confirm('정말로 탈퇴하시겠습니까?')" href="userDelete.user" >회원 탈퇴</a></div>
		</div>
	</div>
<jsp:include page="../include/footer.jsp"/>
</body>
</html>