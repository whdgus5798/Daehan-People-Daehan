<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인기서브</title>
<link rel="stylesheet" href="../css/popularCSS.css">
</head>
<body>
	<jsp:include page="../include/header.jsp"></jsp:include>
	<div class="popularSubContainer">
		<div class="title" align="center">
			<div class="popularName">${ptv.popular_name}</div>
			<div class="subtitle">${ptv.popular_subtitle}</div>
			<div class="location">${ptv.popular_location}</div>
			<div class="imges">
				<img src="../img/${ptv.popular_img}" alt="축제이미지" width="700px" height="400px">
			</div>
		</div>
		<div class="basicInform">기본 정보</div>
		<div class="basicContent">
			<span>${ptv.popular_content}</span>
		</div>
		<div class="popularContent">[상세내용]</div>
		<div class="popularDetail">
			<div class="detail">
				<div>*전화번호 : &nbsp;&nbsp;${ptv.popular_tel }</div>
				<div>*상세주소 : &nbsp;&nbsp;${ptv.popular_address }</div>
				<div>*홈페이지 : &nbsp;&nbsp;${ptv.popular_url }</div>
				<div>*이용요금 : &nbsp;&nbsp;${ptv.popular_charge }</div>
			</div>
		</div>
		<div class="map">
			<c:set var="TextValue" value="${ptv.popular_coodinate }"></c:set>
			<fmt:formatNumber value="${fn:substring(TextValue,0,18) }"
				type="number" var="numberType"></fmt:formatNumber>
			<c:set var="TextValue2" value="${ptv.popular_coodinate }"></c:set>
			<fmt:formatNumber value="${fn:substring(TextValue2,19,37) }"
				type="number" var="numberType2"></fmt:formatNumber>
			<div id="map" style="width: 100%; height: 350px;"></div>
			<script type="text/javascript" 
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d883db333a4682a4429e9ed494fb1b4c">
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

		</script>
		</div>
		<div class="backSpace" align="right">
			<a href = "showAllPopularity.page">목록보기</a>
		</div>
		
</div>
<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>