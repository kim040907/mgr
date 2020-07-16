<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>BUY TIME</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<h1>LOGIN</h1>

	<form action="/member/login" method="post">
		<input type="text" name="memberEmail" placeholder="E-MAIL"></input> 
		<input type="password" name="memberPassword" placeholder="PASSWORD"></input>
		<input type="submit" value="LOGIN"></input>
	</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
