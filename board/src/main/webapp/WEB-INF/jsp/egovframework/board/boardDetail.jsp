<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
</head>
<body>
	조회수 : ${boardVO.viewCount} 글작성 날짜 : <fmt:formatDate value="${boardVO.regDate}" pattern="yyyy.MM.dd"/> <br>
	제목 : ${boardVO.title}<br>
	작성자 : ${boardVO.writer}<br>
	<p>내용 : </p>
	<p>${boardVO.content}</p>
	
	<button onclick="listGo()">목록</button>
	<button onclick="updateGo()">글 수정</button>
	<button onclick="deleteFn()">글 삭제</button>
<script type="text/javascript">
	function listGo() {
		location.href = "list.do";
	}
	
	function updateGo() {
		location.href = "updateView.do?bno=${boardVO.bno}";
	}
	
	function deleteFn() {
		location.href = "delete.do?bno=${boardVO.bno}";
	}
</script>
</body>
</html>