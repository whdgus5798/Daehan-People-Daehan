<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 
	result값
	//result == 1 >>> 아이디: 일치 / 비밀번호: 일치
	//result == -1 >>> 아이디: 일치 / 비밀번호: 불일치
	//result = 0 >>> 아이디: 불일치 / 비밀번호: 검사하지 않음
	//result == 10 >> 아이디 중복(등록된 아이디가 존재)
	//result == -10 >> 아이디 중복되지 않음(등록된 아이디가 존재하지 않음)
--%>
<c:choose>
	<c:when test="${result == 1}">
		<script>
			alert("로그인 성공");
			location.href="MyPage.user";
		</script>
	</c:when>
	<c:when test="${result == -1}">
		<script>
			alert("로그인 실패\n비밀번호 불일치");
			history.back();
		</script>
	</c:when>
	<c:when test="${result == 0}">
		<script>
			alert("로그인 실패\n아이디 불일치");
			history.back();
		</script>
	</c:when>
	<c:when test="${result == 10}">
		<script>
			alert("회원가입 성공");
			location.href="UserLoginForm.jsp";
		</script>
	</c:when>
	<c:when test="${result == -10}">
		<script>
			alert("이미 등록된 아이디가 존재합니다.");
			history.back();
		</script>
	</c:when>
	<c:when test="${result == -100 }">
		<script>
			alert("회원탈퇴되었습니다.");
			location.href="mainPage.page";
		</script>
	</c:when>
	<c:when test="${result == 100 }">
		<script>
			alert("로그아웃 되었습니다.");
			location.href="mainPage.page";
		</script>
	</c:when>
</c:choose>
<c:choose>
	<c:when test="${resultStr == x}">
		<script>
			alert("입력한 정보와 일치하는 회원정보가 없습니다.");
			history.back;
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("회원님의 비밀번호는 ${resultStr} 입니다.");
			location.href="UserLoginForm.jsp";
		</script>
	</c:otherwise>
</c:choose>