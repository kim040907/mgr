<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Login</title>
</head>
<body>
<h1>
	Boarddetail
</h1>


${boardDetail.boardNum}
${boardDetail.boardTitle}
${boardDetail.boardContents}

<input type="button" onclick="location.href='/board/list'" value="List"></input>
<input type="button" onclick="location.href='/board/updateForm?boardNum=${boardDetail.boardNum}'" value="UPDATE"></input>
<input type="button" onclick="location.href='/board/delete?boardNum=${boardDetail.boardNum}'" value="DELETE"></input>
</body>
</html>
