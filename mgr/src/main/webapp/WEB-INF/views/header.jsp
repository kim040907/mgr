<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
		<p>BUY TIME</p>
		<input type="button" onclick="location.href='/fund/list'" value="FUNDING"></input>
		
		<c:choose>
			<c:when test="${session == null}">
				<input type="button" onclick="location.href='/member/loginForm'" value="LOGIN"></input>
				<input type="button" onclick="location.href='/member/joinForm'" value="JOIN"></input>
			</c:when>
			<c:otherwise>
				<input type="button" onclick="location.href='/member/logout'" value="LOGOUT"></input>
			</c:otherwise>
		</c:choose>
</body>
</html>
