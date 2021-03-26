<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
	<script type="text/javascript">
    
        // 회원가입 화면의 입력값들을 검사한다.
        function checkValue() {
        	var form = document.userInfo;
            if(!form.loginId.value){
                alert("아이디를 입력하세요.");
                return false;
            }
            if(!form.loginPw.value){
                alert("비밀번호를 입력하세요.");
                return false;
            }
        }
	</script>
<link rel="stylesheet" href="../css/userCSS.css">
</head>
<body>
	<jsp:include page="../include/header.jsp"></jsp:include>
	
	<div class="userContainer">
		<form action="login.user" method="post">
			<table border="0" align="center">
				<tr>
					<th colspan="3" class="title">로그인 화면</th>
				</tr>
				<tr class="loginContent">
					<td class="label">아이디</td>
					<td><input type="text" name="loginId" class="textbox" autofocus></td>
					<td rowspan="2" class="loginbtn"><input type="submit" value="로그인" class="btn"></td>
				</tr>
				<tr>
					<td class="label">비밀번호</td>
					<td><input type="password" name="loginPw" class="textbox"></td>
				</tr>
			</table>
		</form>
		<div class="loginbottom" align="center">
			<div class="loginbottom-1" align="center">
				아이디가 없으면 <a href="UserAddForm.jsp">회원가입</a>을 클릭하세요.
			</div>
			<div class="loginbottom-2" align="center">
				비밀번호를 잊어버리셨다면 <a href="UserReserchId.jsp?keyword=pw">비밀번호 찾기</a>를 클릭하세요.
			</div>
		</div>
	</div>
	
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>