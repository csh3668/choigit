<%@page import="model.field_rent"%>
<%@page import="model.Login_info"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%String uid = (String)session.getAttribute("Login_infoId"); %>
<meta charset="UTF-8">
<title>입력 페이지</title>
</head>
<body>
<h2>글쓰기 페이지 입니다.</h2>
<form action="page.choi4" accept-charset="UTF-8">
 입력 하실 내용을 해당 칸에 작성해주세요.<br><br>
 <span>글 제목</span>
 <input type="text" name="rent_title"><br>
 <span>글 내용</span>
 <input type="text" name="rent_content"><br>
 <input type="submit" value="글 쓰기">

</form>
</body>
</html>