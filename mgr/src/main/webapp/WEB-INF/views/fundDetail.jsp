<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>
	FUNDDETAIL
</h1>


${fundDetail.fundNum}
${fundDetail.fundTitle}
${fundDetail.fundContents}
${fundDetail.fundStartDate} ~
${fundDetail.fundEndDate}

${fundDetail.fundNeedpoint}
${fundDetail.fundCurrentpoint}
${fundDetail.fundNeedpoint - fundDetail.fundCurrentpoint}

<input type="button" onclick="location.href='/fund/list'" value="List"></input>








<input type="button" onclick="location.href='/fund/updateForm?fundNum=${fundDetail.fundNum}'" value="UPDATE"></input>
<input type="button" onclick="location.href='/fund/delete?fundNum=${fundDetail.fundNum}'" value="DELETE"></input>




<form action="/fund/fundPoint" method="post">


	<input type="hidden" name="fundNum" value="${fundDetail.fundNum}"></input>

	<input type="text" placeholder="FUND MONEY" name="fundPoint"></input>
	
	<input type="submit" value="FUNDING"></input>
</form>



<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
