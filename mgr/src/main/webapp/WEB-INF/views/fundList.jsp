<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/shop-homepage.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.css">
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
				<fmt:parseDate value="${today}" var="nowdate" pattern="yyyy-MM-dd" />
				<fmt:parseNumber value="${nowdate.time / (1000*60*60*24)}"
					integerOnly="true" var="nowDate"></fmt:parseNumber>

				<fmt:parseDate value="${list.fundEndDate}" var="endPlanDate"
					pattern="yyyy-MM-dd" />
				<fmt:parseNumber value="${endPlanDate.time / (1000*60*60*24)}"
					integerOnly="true" var="endDate"></fmt:parseNumber>

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
						<td><c:out
								value="${list.fundNeedpoint - list.fundCurrentpoint}" /></td>
					</c:when>
					<c:otherwise>
						<td>0</td>
					</c:otherwise>
				</c:choose>

				<td><fmt:formatNumber
						value="${list.fundCurrentpoint / list.fundNeedpoint}"
						type="percent" /></td>

			</tr>
		</c:forEach>

	</table>

	<input type="button" onclick="location.href='/fund/writeForm'"
		value="Write"></input>
	<script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
	<script
		src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>





<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/shop-homepage.css" rel="stylesheet">

</head>

<body>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-lg-3">

				<h1 class="my-4">Shop Name</h1>
				<div class="list-group">
					<a href="#" class="list-group-item">Category 1</a> <a href="#"
						class="list-group-item">Category 2</a> <a href="#"
						class="list-group-item">Category 3</a>
				</div>

			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block img-fluid" src="http://placehold.it/900x350"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="http://placehold.it/900x350"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="http://placehold.it/900x350"
								alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>

				<div class="row">
					<c:forEach items="${fundList}" var="list">
					
					
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="#"><img class="card-img-top"
									src="http://placehold.it/700x400" alt=""></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="/fund/fundDetail?fundNum=${list.fundNum}">${list.fundTitle}</a>
									</h4>
									<h5><c:out value="${list.fundNeedpoint}" /></h5>
									<p class="card-text"><c:out value="${list.fundCategory}" /> | Writer</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">&#9733; &#9733; &#9733;
										&#9733; &#9734;</small>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

