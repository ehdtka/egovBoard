<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트 페이지</title>
</head>
<body>
${pagination }
	<table border="1">
		<tr>
			<td>글 번호</td>
			<td>글 제목</td>
			<td>작성자</td>
			<td>작성 날짜</td>
			<td>조회 수</td>
		</tr>
		<c:forEach items="${boardList}" var="boardVO">
			<tr>
				<td>${boardVO.bno }</td>
				<td><a href="#" onclick="detailViewGo(${boardVO.bno})">${boardVO.title}</a></td>
				<td>${boardVO.writer }</td>
				<td><fmt:formatDate value="${boardVO.regDate}" pattern="yyyy.MM.dd"/> </td>
				<td>${boardVO.viewCount }</td>
			</tr>
		</c:forEach>
	</table>
	<!-- 이전 -->
	<c:if test="${pagination.prev == true}">
		<a href="#" onclick="pageFormSub(${pagination.startPage - 1})">&lt;</a>
	</c:if>
	<c:forEach var="i" begin="${pagination.startPage}"
					   end="${pagination.endPage}">
			<a
		<c:if test="${pagination.paging.page != i}">
			<a href="#" onclick="pageFormSub(${i})"
		</c:if>
			>${i}</a>
	</c:forEach>
	<!-- 다음 -->
	<c:if test="${pagination.next == true}">
		<a href="#" onclick="pageFormSub(${pagination.endPage + 1})">&gt;</a>
	</c:if>
	<br>
	<!-- 검색 -->
	<select id="searchKey">
		<option value="title">제목</option>
		<option value="writer">작성자</option>
	</select>
	<input type="text" id="searchValue">
	<button onclick="searchFormsub()">검색</button>
	<br>
	<button onclick="writePageGo()">글 작성</button>

<form name="pageForm" action="/list.do">
	<input type="hidden" name="page"
		value="${pagination.paging.page}">
	<input type="hidden" name="perPage"
		value="${pagination.paging.perPage}">
	<input type="hidden" name="searchKey"
		value="${pagination.paging.searchKey }">
	<input type="hidden" name="searchValue"
		value="${pagination.paging.searchValue }">
</form>
<script type="text/javascript">
	
	function writePageGo() {
		location.href = "writeView.do";
	}
	
	function detailViewGo(bno) {
		location.href = "detail.do?bno=" + bno;
	}
	
	function pageFormSub(pageData) {
		var pageForm = document.pageForm;
		pageForm.page.value = pageData;
		pageForm.submit();
	}
	
	function searchFormsub() {
		var pageForm = document.pageForm;
		var searchValue = document.getElementById("searchValue").value;
		var searchKey = document.getElementById("searchKey").value;
		pageForm.searchValue.value = searchValue;
		pageForm.searchKey.value = searchKey;
		pageForm.page.value = 1;
		pageForm.submit();
	}
	
	
</script>
</body>
</html>