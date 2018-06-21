<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>battleLog</p>
		<c:forEach var="battle" items="${battleLog}">
				${fn:escapeXml(battle)}<br>
		</c:forEach>
		<br> <br>
	<p>Character</p>
	 <img src="image/Penguins.jpg" width="205" height="180">
	<p>LV 3</p>
	<p>HP 40/40</p>

	<p>VS</p>
	<p>Monster</p>
	<img src="image/Penguins.jpg" width="205" height="180">
	<p>LV 3</p>
	<p>HP 40/40</p>
	<div></div>
	<a href="menu.jsp">Menuに戻る</a>

</body>
</html>