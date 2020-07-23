<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			<td>REMAINDATE</td>
			<td>NEEDPOINT</td>
			<td>CURRENTPOINT</td>
			<td>REMINPOINT</td>
			<td>POINTRATE</td>
		</tr>

		<c:forEach items="${fundList}" var="list">

			<tr>
				<th><c:out value="${list.fundNum}" /></th>
				<td><c:out value="${list.fundCategory}" /></td>
				<td><a href="/fund/fundDetail?fundNum=${list.fundNum}">${list.fundTitle}</a></td>
				<td><c:out value="${list.fundContents}" /></td>
				<td><c:out value="${list.fundStartDate}" /></td>
				<td><c:out value="${list.fundEndDate}" /></td>
				
				<!-- Calculate RemainDate -->
				
				<jsp:useBean id="toDay" class="java.util.Date" />
				
				<fmt:formatDate value="${toDay}" pattern="yyyy-MM-dd" var="today" />
				<fmt:parseDate value="${today}" var="nowdate" pattern="yyyy-MM-dd"/>
				<fmt:parseNumber value="${nowdate.time / (1000*60*60*24)}" integerOnly="true" var="nowDate"></fmt:parseNumber>

				<fmt:parseDate value="${list.fundEndDate}" var="endPlanDate" pattern="yyyy-MM-dd"/>
				<fmt:parseNumber value="${endPlanDate.time / (1000*60*60*24)}" integerOnly="true" var="endDate"></fmt:parseNumber>

				<c:choose>
				<c:when test="${endDate -nowDate >= 0}">
					<td><c:out value="${endDate -nowDate}" /></td>
				</c:when>
				<c:otherwise>
					<td>DeadLine</td>
				</c:otherwise>
				</c:choose>
				
				
				
				
				<td><c:out value="${list.fundNeedpoint}" /></td>
				<td><c:out value="${list.fundCurrentpoint}" /></td>
				
				<c:choose>
					<c:when test="${list.fundNeedpoint - list.fundCurrentpoint >= 0}">
						<td><c:out value="${list.fundNeedpoint - list.fundCurrentpoint}" /></td>
					</c:when>
					<c:otherwise>
						<td>0</td>
					</c:otherwise>
				</c:choose>
				
				<td><fmt:formatNumber value="${list.fundCurrentpoint / list.fundNeedpoint}" type="percent"/></td>
				
			</tr>
		</c:forEach>

	</table>

	<input type="button" onclick="location.href='/fund/writeForm'"
		value="Write"></input>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
