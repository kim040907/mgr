<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Join</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>
	FUNDING WRITE
</h1>

<form action="/fund/fundWrite" method="post">

	CATEGORY : <input type="text" name="fundCategory"></input>
	TITLE : <input type="text" name="fundTitle"></input>
	CONTENTS : <input type="text" name="fundContents"></input>
	STARTDATE : <input type="date" name="fundStartDate"></input>
	ENDDATE : <input type="date" name="fundEndDate"></input>
	NEEDMONEY : <input type="text" name="fundNeedMoney"></input>
	
<input type="submit" value="WRITE"></input>

</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
