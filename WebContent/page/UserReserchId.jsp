<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 비밀번호 찾기</title>
<script type="text/javascript"> 
function checkValue1()
{
	var form = document.userInfo1;
    if(!form.userName.value){
        alert("이름을 입력하세요.");
        return false;
    }
}
function checkValue2()
{
	var form = document.userInfo2;
    if(!form.id.value){
        alert("아이디를 입력하세요.");
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
		<form action="searchPw.user" method="post">
			<table border="0" align=center>
				<tr>
					<th colspan=5" class="searchTitle">찾으시려는 비밀번호에 맞게 입력해주세요</th>
				</tr>
				<tr align="center">
					<td colspan=2 class="label">비밀번호 찾기(아이디,이름)</td>
				</tr>
				<tr align="center">
					<td class="label" align="right">아이디: </td>
					<td align="left"><input type="text" name="user_id" class="textbox" autofocus></td>
				</tr>
				<tr align="center">
					<td class="label" align="right">이름: </td>
					<td align="left"><input type="text" name="user_name" class="textbox"></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" value="검색" class="btn-signIn"></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>