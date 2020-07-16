<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>FUNDING</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<h1>${session}</h1>

	<form action="/board/search" method="post">
		<select name="searchType">
			<option>all</option>
			<option>title</option>
			<option>contents</option>
		</select> <input type="text" name="searchWord"></input>
		<button type="submit">search</button>
	</form>

	<div style="float: right;">
		<select id="cntPerPage" name="sel" onchange="selChange()">
			<option value="10"
				<c:if test="${paging.cntPerPage == 10}">selected</c:if>>10ROW</option>
			<option value="20"
				<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20ROW</option>
			<option value="30"
				<c:if test="${paging.cntPerPage == 30}">selected</c:if>>30ROW</option>
		</select>
	</div>

	<table>
		<tr>
			<th>NO</th>
			<td>TITLE</td>
			<td>CONTENTS</td>
		</tr>

		<c:forEach var="boardVO" items="${boardList}">

			<tr>
				<th><c:out value="${boardVO.boardNum}" /></th>
				<td><a href="/board/detail?boardNum=${boardVO.boardNum}">${boardVO.boardTitle}</a></td>
				<td><c:out value="${boardVO.boardContents}" /></td>
			</tr>
		</c:forEach>

	</table>

	<input type="button" onclick="location.href='/board/writeForm'"
		value="Write"></input>

	<div style="display: block; text-align: center;">
		<c:if test="${paging.startPage != 1 }">
			<a
				href="/board/list?currentPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }"
			var="p">
			<c:choose>
				<c:when test="${p == paging.currentPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.currentPage }">
					<a
						href="/board/list?currentPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a
				href="/board/list?currentPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>

	<script>
		function selChange() {
			var sel = document.getElementById('cntPerPage').value;
			location.href = "list?currentPage=${paging.currentPage}&cntPerPage="
					+ sel;
		}
	</script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
