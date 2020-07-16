<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>FUNDING</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<h1>FUNDING</h1>


	<form action="/fund/searchFund" method="post">
		<select name="searchType">
			<option>all</option>
			<option>title</option>
			<option>contents</option>
		</select> <input type="text" name="searchWord"></input>
		<button type="submit">search</button>
	</form>

	<table>
		<tr>
			<th>NO</th>
			<td>CATEGORY</td>
			<td>TITLE</td>
			<td>CONTENTS</td>
			<td>STARTDATE</td>
			<td>ENDDATE</td>
			<td>NEEDMONEY</td>
		</tr>

		<c:forEach items="${fundList}" var="list">

			<tr>
				<th><c:out value="${list.fundNum}" /></th>
				<td><c:out value="${list.fundCategory}" /></td>
				<td><a href="/fund/fundDetail?fundNum=${list.fundNum}">${list.fundTitle}</a></td>
				<td><c:out value="${list.fundContents}" /></td>
				<td><c:out value="${list.fundStartDate}" /></td>
				<td><c:out value="${list.fundEndDate}" /></td>
				<td><c:out value="${list.fundNeedpoint}" /></td>
			</tr>
		</c:forEach>

	</table>

	<input type="button" onclick="location.href='/fund/writeForm'"
		value="Write"></input>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
