<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>BUY TIME</title>
</head>
<body>

<script>
function checkForm(){
	var form = document.loginForm;
	
	// Email Regex
	var emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	var email = document.getElementById("memberEmail").value;
	
	// Email Check
	if(emailReg.test(email) == false) {
		alert("Check Your Email");
		return false;
	}
	form.submit();
}
</script>
<jsp:include page="header.jsp"></jsp:include>
	<h1>LOGIN</h1>

	<form action="/member/login" method="post" name="loginForm">
		<input type="text" name="memberEmail" id="memberEmail" placeholder="E-MAIL" maxlength="30"></input>
		<input type="password" name="memberPassword" id="memberPassword" placeholder="PASSWORD" maxlength="12"></input>
		<a href="#" onclick="checkForm()">LOGIN</a>
	</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
