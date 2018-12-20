<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">

<script>
function signup(){
	
	var id = document.getElementById("id").value;
	var password = document.getElementById("password").value;
	
	var param = "id=" + id + "&password=" + password;
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	
			if (this.readyState == 4 && this.status == 200 ) {
				
				if(this.responseText.trim()=="1") 
					location.href='../index.jsp';		
				
				else if(this.responseText.trim()=="2")	
					location.href='../admin/user.do';
				
				else
				document.getElementById("here").innerHTML = this.responseText;
			}
		};
		
		xhttp.open("POST", "login.do");
		xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		xhttp.send(param);
		document.getElementById("id").value="";
		document.getElementById("password").value="";
		document.getElementById("id").focus();
}
</script>

<title>Insert title here</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<div class="login">
	<div class="login-screen">
		<div class="app-title">
		<h1> 로그인 </h1>
		</div>
		<div class="login-form">
		
			<div class="control-group">
			<input type="text" name="id" id="id" placeholder="아이디" required="required">
			<span><i class="fas fa-user"></i></span>
			</div>
			<div class="control-group">
			<input type="password" name="password" id="password" placeholder="비밀번호" required="required">
			<span><i class="fas fa-unlock-alt"></i></span>
			</div>
			
			<button class='btn' onclick="signup();">로그인</button>
			<div id="here"></div>
	</div>
</div>
</div>
</body>
</html>