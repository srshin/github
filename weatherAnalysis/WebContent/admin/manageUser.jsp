<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>

function call(userid){
	ret = confirm("삭제하시겠습니까?");
	if(ret)
		location.href='userDelete.do?userid=' + userid;
}
</script>
<script>

function call2(userid){
	ret = confirm("수정하시겠습니까?");
	if(ret)
		location.href='userUpdate.do?userid=' + userid;
}
</script>
<script>
function retrieve(){
	var id = document.getElementById("id").value;
	var email = document.getElementById("email").value;
	var param = "id=" + id + "&email=" + email;
	
	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200 ) {
				document.getElementById("here").innerHTML = this.responseText;
			}
		};
		
		xhttp.open("GET", "finduser.do?" + param);
		xhttp.send();
}

</script>
</head>
<body>
<jsp:include page="adminHeader.jsp"></jsp:include>
<h1>회원 관리</h1>
<hr>
아이디 : <input type="text" id="id"><br>
이메일 : <input type="email" id="email"><br>
<button onclick="retrieve();">조회</button>
<hr>
<div id="here">
<table border="1">
	<tr>
		<th>아이디</th>
		<th>패스워드</th>
		<th>이메일</th>
		<th>회원관리</th>
	</tr>
	<c:forEach items="${allUser }" var="allUser">
	<tr>
		<td>${allUser.id }</td>
		<td>${allUser.password }</td>
		<td>${allUser.email }</td>
		<td><button onclick="call2('${allUser.id}');">수정</button><button onclick="call('${allUser.id}');">삭제</button></td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>