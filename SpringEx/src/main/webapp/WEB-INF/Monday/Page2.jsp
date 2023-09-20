<%@page import="model.Login_info"%>
<%@page import="model.field_rent"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
 <%request.setCharacterEncoding("utf-8"); %>   
<!DOCTYPE html>
<html>
<head>
<%request.getAttribute("ten"); %>
<%String uid = (String)session.getAttribute("Login_infoId"); %>
<meta charset="UTF-8">
<title>글 목록 페이지</title>
</head>
<body>

<h2><%=uid%> 회원님 환영합니다!</h2>
<table border="1"> <!-- forEach 밖에 table을 생성한 이유는 forEach는 반복문과 유사하기 
때문에 안에 넣으면 테이블도 반복해서 생성됨. -->
	<tr>
		<td><b>글 번호</b></td>
		<td><b>글 제목</b></td>		
		<td><b>글 내용</b></td>
		<td><b>작성 날짜</b></td>
		<td><b>글 삭제</b></td>
	</tr>
<c:forEach items="${ten}" var="i">
	<tr>
	<td>${i.rent_num}</td>
	<td><a href="page.choi6?num=${i.rent_num}">${i.rent_title}</a></td>
	<td>${i.rent_content}</td>
	<td>${i.rent_date}<br></td>
	<td><a href="page.choi5?num=${i.rent_num}">삭제</a></td>
	</tr>
</c:forEach>
</table>
<br><a href="page.choi2">글쓰러 가기</a>
</body>
</html>