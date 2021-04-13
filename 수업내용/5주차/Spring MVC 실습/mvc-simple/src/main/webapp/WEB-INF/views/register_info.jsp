<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/member.css" type="text/css"></link>
</head>
<body>
	<div align=center>
		<header>학생 정보</header><br>
		<c:if test="${student != null }"/>
		<table>
			<tr>
				<th>LoginID </th><td><c:out value="${student.id }"/></td>
			</tr>
			<tr>
				<th>LoginPWD </th><td><c:out value="${student.id }"/></td>
			</tr>
			<tr>
				<th>YourName</th><td><c:out value="${student.id }"/></td>
			</tr>
			<tr>
				<th>StudentNumber</th><td><c:out value="${student.id }"/></td>
			</tr>
		</table>
	</div>
</body>
</html>