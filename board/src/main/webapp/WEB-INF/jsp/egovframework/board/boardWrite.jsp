<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성 페이지</title>
</head>
<body>
	<form name="writeForm" action="/write.do" method="post">
		제목 <input type="text" name="title"><br>
		작성자 <input type="text" name="writer"><br>
		내용<br>
		<textarea rows="10" cols="10" name="content"></textarea><br>
		<input type="submit" value="글작성">
	</form>
</body>
</html>