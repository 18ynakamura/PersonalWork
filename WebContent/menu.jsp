<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
<%=(String)session.getAttribute("name") %>
	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>
	<p>
		<a href="taskRegister.jsp">Task登録</a> <a href="battle.jsp">Battle</a>
		<a href="logout.jsp">Logout</a>
	</p>
	<p>Task</p>
	<p>Unfinished</p>
	<p>
	<fieldset>
		<form action="taskFinish" method="post">
			<div>
				<c:forEach var="task" items="${userList}">
					<input type="checkbox" name="task"
						value="${fn:escapeXml(task.taskId)}">${fn:escapeXml(task.text)}<br>
				</c:forEach>
			</div>
			<input type="hidden" name="hidden" value="">
			<input type="submit" value="Finish">
		</form>
	</fieldset>
	</p>
	<p>Finished</p>
	<p>
	<fieldset>
		<form action="taskDelete" method="post">
			<div>
				<c:forEach var="task" items="${finishedList}">
				○${fn:escapeXml(task.text)}<br>
				</c:forEach>
			</div>
			<input type="submit" value="Delete">
		</form>
	</fieldset>
	</p>
	<div>
		<a href="index.jsp">TOP画面に戻る</a>
	</div>
	<p>Character</p>
	<img src="image/Penguins.jpg" width="205" height="180">
	<p>LV <%=(int)session.getAttribute("level") %></p>
	<p>Exp <%=(int)session.getAttribute("c_exp") %></p>
	<p>HP <%=(int)session.getAttribute("c_hp") %></p>
</body>
</html>