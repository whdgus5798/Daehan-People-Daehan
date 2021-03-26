<%@page import="com.sun.corba.se.impl.protocol.giopmsgheaders.Message"%>
<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>
<script type="text/javascript">
    
        // 회원가입 화면의 입력값들을 검사한다.
        function checkValue()
        {
        	var form = document.userInfo;
            if(!form.id.value){
                alert("아이디를 입력하세요.");
                return false;
            }
            if(!form.passWd.value){
                alert("비밀번호를 입력하세요.");
                return false;
            }
            if(!form.userName.value){
                alert("이름을 입력하세요.");
                return false;
            }
        } 
   </script>
<link rel="stylesheet" href="../css/userCSS.css">
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<div class="userContainer">
		<form action="registMember.user" method="post">
			<table border="0" align="center">
				<tr>
					<th colspan="3" class="title">회원가입</th>
				</tr>
				<tr>
					<td class="label">아이디</td>
					<td colspan="2">
						<input type="text" name="user_id" maxlength="12" size="30" class="textbox-signIn" autofocus>
					</td>
				</tr>
				<tr>
					<td class="label">비밀번호</td>
					<td colspan=2 align="left">
						<input type="password" name="user_pw" maxlength="12" size=30 class="textbox-signIn">
					</td>
				</tr>
				<tr>
					<td class="label">이름</td>
					<td colspan=2 align="left">
						<input type="text" name="user_name" maxlength="12" size=30 class="textbox-signIn">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="가입" class="btn-signIn">
						<input type="reset" value="취소" class="btn-signIn">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>