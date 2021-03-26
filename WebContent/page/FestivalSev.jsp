<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>축제서브</title>
<link rel="stylesheet" href="../css/festivalCSS.css">
</head>
<body>
	<jsp:include page="../include/header.jsp"></jsp:include>
	<div class="festivalContainer">


		<div class="title" align="center">
			<span class="festaName">${ftv.festa_name}</span>
			<h4>${ftv.festa_period}</h4>
			<br> <br> <img src="../img/${ftv.festa_img}" alt="축제이미지"
				width="600px" height="400px"> <br> <br>
		</div>

		<div class="basicInform">기본 정보</div>
		<div class="basicContent">
			<span>${ftv.festa_content}</span>
		</div>
		<div class="festaContent">[행사내용]</div>
		
		<div class="festaDetail">
			<c:set var="TextValue" value="${ftv.festa_period}" />
			<div class="detail-1">
				<div>＊시작일: &nbsp;&nbsp;${fn:substring(TextValue,0,10)}</div>
				<div>＊종료일:	&nbsp;&nbsp;${fn:substring(TextValue,11,21)}</div>
				<div>＊전화번호:&nbsp;&nbsp;${ftv.festa_tel}</div>
				<div>＊홈페이지:&nbsp;&nbsp;<a href="${ftv.festa_url}">${ftv.festa_url}</a></div>
			</div>
			<div class="detail-2">
				<div>＊주관:&nbsp;&nbsp;${ftv.festa_host}</div>
				<div>＊주소:&nbsp;&nbsp;${ftv.festa_address}</div>
				<div>＊행사장소:&nbsp;&nbsp;${ftv.festa_location}</div>
				<div>＊이용요금:&nbsp;&nbsp;${ftv.festa_charge}</div>
			</div>
		</div>
		
		<div class="map">
			<!-- 위도 경도 문자열 -> 숫자로 바꾸기 -->
			<c:set var="TextValue" value="${ftv.festa_coodinate}" />
			<fmt:formatNumber value="${fn:substring(TextValue,0,7)}"
				type="number" var="numberType" />
			<c:set var="TextValue2" value="${ftv.festa_coodinate}" />
			<fmt:formatNumber value="${fn:substring(TextValue2,8,16)}"
				type="number" var="numberType2" />
			<div id="map" style="width: 100%; height: 350px;"></div>

			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=86d9bb03557d2cea0d4486ac79e0571a">
</script>

			<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(${numberType}, ${numberType2}), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(${numberType}, ${numberType2}); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);    
</script>
		</div>
		


	<div class="backSpace" align="right">
		<a href = "showAllFestival.page">목록보기</a>
	</div>
	</div>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>