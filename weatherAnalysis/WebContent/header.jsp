<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
<script> 
function go() {
	var user_id = "<%=session.getAttribute("user")%>";
	if( user_id =="null") {
		alert("해당 서비스는 로그인 후 이용 가능합니다.");
	}else {
		window.location.href = '/BrainMining/predict/predict.do';
	}
	
	
	
};
</script>

<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<ul class="topnav">
<li><a class="icon" style="padding:0" href="${path }/index.jsp"><img src='${path }/image/brain.jpg' width=50 /></a></li>
<li><a class="mainmenu" class="active" href="${path }/intro/intro.do">사이트 소개 </a></li>
<li><a class="mainmenu" href="${path }/onion/onion.do">양파생산량분석</a></li>
<li><a class="mainmenu" href="${path }/weather/weather.do">기상데이타분석</a></li>
<li><a class="mainmenu" href="javascript:void(0);" onclick="go();">양파생산량예측</a></li>
<c:if test = "${sessionScope.user == null }">
<li class="right"><a  class="mainmenu" href="${path }/login/signup.do">가입</a></li>
<li class="right"><a  class="mainmenu" href="${path }/login/login.do">로그인</a></li>

</c:if>
<c:if test = "${sessionScope.user!=null}">
<li class="right"><a  class="mainmenu" href="${path }/login/logout.do">로그아웃</a></li>
</c:if>
</ul>

</body>
</html>
    