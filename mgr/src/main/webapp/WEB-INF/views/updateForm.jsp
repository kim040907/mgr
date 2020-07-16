<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Join</title>
</head>
<body>
<h1>
	Join
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form action="/board/update" method="post">

<input type="hidden" name="num" value="${boardDetail.boardNum}"></input>
Title : <input type="text" name="title" value="${boardDetail.boardTitle}"></input>
contents : <input type="text" name="contents" value="${boardDetail.boardContents}"></input>


<input type="submit" value="UPDATE"></input>

</form>
</body>
</html>
