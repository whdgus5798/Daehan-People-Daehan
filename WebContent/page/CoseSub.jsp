<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>완주</title>
<link rel="stylesheet" href="../css/routeCSS.css">
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<div class="routeSubContainer">
		<div class="routeSubHeader" align="center">
			<div class="subTitle">${vo.route_name}</div>
			<div class="tag">
				<span>🐷일정: ${vo.route_schedule }</span>
				<span>🐷테마: ${vo.route_theme }</span>
				<span>🐷태그: ${vo.route_hashtag }</span>
			</div>
		</div>
		<div class="contentTitle">세부내용</div>
		<div class="content">${vo.route_content }</div>
		
		<div class="map">
			<!-- 위도 경도 문자열 -> 숫자로 바꾸기 -->
			<c:set var="TextValue" value="${vo.route_coordinate}" />
			<fmt:formatNumber value="${fn:substring(TextValue,0,17)}"
				type="number" var="numberType" />
			<c:set var="TextValue2" value="${vo.route_coordinate}" />
			<fmt:formatNumber value="${fn:substring(TextValue2,18,36)}"
				type="number" var="numberType2" />
			<div id="map" style="width: 100%; height: 350px;"></div>

			<script type="text/javascript" 
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c2c4f0a75389dbde465834b3f330ce60">
			</script>

			<script>
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
   				mapOption = {center: new kakao.maps.LatLng(${numberType}, ${numberType2}), // 지도의 중심좌표
        					level: 3 // 지도의 확대 레벨
    						};

				var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

				// 마커가 표시될 위치입니다 
				var markerPosition  = new kakao.maps.LatLng(${numberType}, ${numberType2}); 

				// 마커를 생성합니다
				var marker = new kakao.maps.Marker({ position: markerPosition });

				// 마커가 지도 위에 표시되도록 설정합니다
				marker.setMap(map);

			</script>
		</div>
		<div class="addLocation">
			<div class="addTitle">그외 더 갈만한 곳</div>
			<div class="addContent">
				<div class="add1">
					<div>${vo.route_addname1 }</div>
					<div>${vo.route_addaddress1 }</div>
					<div>
						<img src = "../img/${vo.route_addimage1 }" width="340px"  height="210px"/>
					</div>
				</div>
				<div class="add2">
					<div>${vo.route_addname2 }</div>
					<div>${vo.route_addaddress2 }</div>
					<div>
						<img src = "../img/${vo.route_addimage2 }" width="340px"  height="210px"/>
					</div>
				</div>
				<div class="add3">
					<div>${vo.route_addname3 }</div>
					<div>${vo.route_addaddress3 }</div>
					<div>
						<img src = "../img/${vo.route_addimage3 }" width="340px"  height="210px"/>
					</div>
				</div>
			</div>
		</div>
		<div class="backSpace" align="right">
			<a href = "showAllRoute.page?condition=''">목록보기</a>
		</div>
	</div>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>