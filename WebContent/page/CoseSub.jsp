<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>μμ£Ό</title>
<link rel="stylesheet" href="../css/routeCSS.css">
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<div class="routeSubContainer">
		<div class="routeSubHeader" align="center">
			<div class="subTitle">${vo.route_name}</div>
			<div class="tag">
				<span>π·μΌμ : ${vo.route_schedule }</span>
				<span>π·νλ§: ${vo.route_theme }</span>
				<span>π·νκ·Έ: ${vo.route_hashtag }</span>
			</div>
		</div>
		<div class="contentTitle">μΈλΆλ΄μ©</div>
		<div class="content">${vo.route_content }</div>
		
		<div class="map">
			<!-- μλ κ²½λ λ¬Έμμ΄ -> μ«μλ‘ λ°κΎΈκΈ° -->
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
				var mapContainer = document.getElementById('map'), // μ§λλ₯Ό νμν  div 
   				mapOption = {center: new kakao.maps.LatLng(${numberType}, ${numberType2}), // μ§λμ μ€μ¬μ’ν
        					level: 3 // μ§λμ νλ λ λ²¨
    						};

				var map = new kakao.maps.Map(mapContainer, mapOption); // μ§λλ₯Ό μμ±ν©λλ€

				// λ§μ»€κ° νμλ  μμΉμλλ€ 
				var markerPosition  = new kakao.maps.LatLng(${numberType}, ${numberType2}); 

				// λ§μ»€λ₯Ό μμ±ν©λλ€
				var marker = new kakao.maps.Marker({ position: markerPosition });

				// λ§μ»€κ° μ§λ μμ νμλλλ‘ μ€μ ν©λλ€
				marker.setMap(map);

			</script>
		</div>
		<div class="addLocation">
			<div class="addTitle">κ·ΈμΈ λ κ°λ§ν κ³³</div>
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
			<a href = "showAllRoute.page?condition=''">λͺ©λ‘λ³΄κΈ°</a>
		</div>
	</div>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>