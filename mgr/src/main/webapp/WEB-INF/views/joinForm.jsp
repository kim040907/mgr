<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>JOIN</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>
	JOIN
</h1>

<form action="/member/join" method="post">
	<input type="email" name="memberEmail" placeholder="E-MAIL"></input>
	<input type="password" name="memberPassword" placeholder="PASSWORD"></input>
	<input type="password" name="memberCheckPassword" placeholder="CHECK PASSWORD"></input>
	<input type="text" name="memberName" placeholder="NAME"></input>
	<input type="submit" value="JOIN"></input>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
