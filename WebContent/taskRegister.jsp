<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<c:if test="${not empty msg}">
<p>${msg} </p>
</c:if>
<p>Taskを登録します</p>
<form action="taskRegister" method="post">
    <div>
   <input type="text" name="task" value="${fn:escapeXml(param.task)}">
    </div>
  <input type="submit" value="登録">
</form>
<div>
  <a href="index.jsp">TOP画面に戻る</a>
</div>
</body>
</html>