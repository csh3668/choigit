<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
<%field_rent detail=(field_rent)request.getAttribute("detail"); %>
<%String uid = (String)session.getAttribute("Login_infoId"); %>
<meta charset="UTF-8">
<title>상세 페이지</title>
</head>
<body>

<table border="1"> <!-- forEach 밖에 table을 생성한 이유는 forEach는 반복문과 유사하기 
때문에 안에 넣으면 테이블도 반복해서 생성됨. -->
	<tr>
		<td><b>글 번호</b></td>
		<td><b>글 제목</b></td>		
		<td><b>글 내용</b></td>
		<td><b>작성 날짜</b></td>
	</tr>
	<tr>
	<td><%=detail.getRent_num() %></td>
	<td><%=detail.getRent_title() %></td>
	<td><%=detail.getRent_content() %></td>
	<td><%=detail.getRent_date() %><br></td>
	</tr>
</table>
<br><a href="page.choi3">글 목록</a>
</body>
</html>