<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 비밀번호 찾기</title>
<link rel="stylesheet" href="../css/userCSS.css">
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<div class="userContainer">
		<form action="UserUpdateConfirm.user" method="post">
			<div>
				<table border="0" align="center">
					<tr>
						<th colspan="3" class="title">회원정보 수정</th>
					</tr>
					<tr>
						<td class="label">아이디</td>
						<td class="label">${userVO.user_id}</td>
					</tr>
					<tr>
						<td class="label">비밀번호</td>
						<td colspan=2 align="left" >
							<input type="password" class="textbox" name="user_pw" maxlength="12" size=30 value="${userVO.user_pw}" autofocus>
						</td>
					</tr>
					<tr>
						<td class="label">이름</td>
						<td colspan=2 align="left">
							<input type="text" class="textbox" name="user_name" maxlength="12" size=30 value="${userVO.user_name}" ></td>
					</tr>
					<tr>
						<td colspan="3" align="center">
							<input type="submit" value="수정" class="btn-signIn">
							<input type="reset" value="초기화" class="btn-signIn">
							<button type="button" class="btn-signIn" onclick="history.back()">취소</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>