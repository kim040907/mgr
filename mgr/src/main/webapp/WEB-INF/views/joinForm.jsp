<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>JOIN</title>
</head>
<body>
<script>
 
function checkForm(){
	var form = document.joinForm;
	
	// Email Regex
	var emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	var email = document.getElementById("memberEmail").value;
	
	var memberPassword = document.getElementById("memberPassword").value;
	var memberCheckPassword = document.getElementById("memberCheckPassword").value;
	
	// Email Check
	if(emailReg.test(email) == false) {
		alert("Check Your Email");
		return false;
	}
	
	// Passwrod Check
	if(memberPassword != memberCheckPassword) {
		alert("Check Your Password");
		return false;
	}
	form.submit();
}
</script>

<jsp:include page="header.jsp"></jsp:include>
<h1>
	JOIN
</h1>

<form action="/member/join" method="post" name="joinForm">
	<input type="text" name="memberEmail" id="memberEmail" placeholder="E-MAIL" maxlength="30"></input>
	<input type="password" name="memberPassword" id="memberPassword" placeholder="PASSWORD" maxlength="12"></input>
	<input type="password" name="memberCheckPassword" id="memberCheckPassword" placeholder="CHECK PASSWORD" maxlength="12"></input>
	<input type="text" name="memberName" id="memberName" placeholder="NAME" maxlength="18"></input>
	<a href="#" onclick="checkForm()" >JOIN</a>
	<!-- <input type="submit" value="JOIN"></input>-->
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
