<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정 페이지</title>
</head>
<body>
	<form name="writeForm" action="/update.do" method="post">
		제목 <input type="text" name="title" value="${boardVO.title}"><br>
		작성자 <input type="text" name="writer" value="${boardVO.writer}"><br>
		내용<br>
		<textarea rows="10" cols="10" name="content">${boardVO.content}</textarea><br>
		<input type="hidden" name="bno" value="${boardVO.bno}">
		<input type="submit" value="글작성">
	</form>
</body>
</html>