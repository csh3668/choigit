<%@page import="model.field_rent"%>
<%@page import="model.Login_info"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
 <form action="page.choi">
 <h1>로그인 페이지</h1>
 아이디 : <input type="text" name="log_id"><br>
  <!-- name에 필드명을 기재해줘야 받아올 수 있음/name를 안적어서 null로 받았던 것. -->
 비밀번호 : <input type="text" name="password"><br>
 <input type="submit" value="로그인">
 </form>
</body>
</html>