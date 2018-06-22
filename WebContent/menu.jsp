<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login.css">
<title>Menu</title>
</head>
<body>
	<div class = top>
	<p class="a">
		<a class="btn_left" href="taskRegister.jsp">Task登録</a> <a class="btn_center" href="battle.jsp">Battle</a>
		<a class="btn_right" href="logout.jsp">Logout</a>
	</p>
	</div>
	<h1 class="title">Task</h1>
	<div class="unfinished">
	<p class="task">○Unfinished○</p>
	<p>
	<fieldset>
		<form action="taskFinish" method="post">
			<div>
				<c:forEach var="task" items="${userList}">
					<p class="task"><input type="checkbox" name="task"
						value="${fn:escapeXml(task.taskId)}">${fn:escapeXml(task.text)}</p><br>
				</c:forEach>
			</div>
			<input type="hidden" name="hidden" value="">
			<input type="submit" value="Finish">
		</form>
	</fieldset>
	</p>
	</div>
	<div class="finished">
	<p class="task">○Finished○</p>
	<p>
	<fieldset>
		<form action="taskDelete" method="post">
			<div>
				<c:forEach var="task" items="${finishedList}">
				<p class="task">○${fn:escapeXml(task.text)}<p><br>
				</c:forEach>
			</div>
			<input type="submit" value="Delete">
		</form>
	</fieldset>
	</p>
	</div>
	<img src="image/Penguins.jpg" width="205" height="180">
	<p class="task">名前： <%=session.getAttribute("name") %></p>
	<p class="task">LV: <%=(int)session.getAttribute("level") %></p>
	<p class="task">Exp: <%=(int)session.getAttribute("c_exp") %>/<%=(int)session.getAttribute("exp") %></p>
	<p class="task">HP: <%=(int)session.getAttribute("c_hp") %>/<%=(int)session.getAttribute("hp") %></p>
	<br><br><br><br>
	<div>
		<a href="index.jsp">TOP画面に戻る</a>
	</div>
</body>
</html>