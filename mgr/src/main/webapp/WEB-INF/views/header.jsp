<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body onload="init();">
<script type="text/javascript">
function init() {
	// Active Header Menu Button 
	if(getUrlParam(3) == "fund") {
		document.getElementById("navabar").childNodes[3].classList.toggle("active");
	} else if(getUrlParam(4) == "loginForm") {
		document.getElementById("navabar").childNodes[5].classList.toggle("active");
	} else if(getUrlParam(4) == "joinForm") {
		document.getElementById("navabar").childNodes[7].classList.toggle("active");
	} else {
		document.getElementById("navabar").childNodes[1].classList.toggle("active");
	}
}
function getUrlParam(param) {
	var sPageURL = location.href.split("/")[param];
	return sPageURL;
}
</script>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.css">
</head>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">BUY TIME</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto" id="navabar">
				<li class="nav-item"><a class="nav-link" href="/">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/fund/list">Funding</a></li>
				<c:choose>
					<c:when test="${session == null}">
						<li class="nav-item"><a class="nav-link"
							href="/member/loginForm">Login</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/member/joinForm">Join</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link"
							href="/member/logout">Logout</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>
</body>
</html>
