package entity;

public class Task {
private int taskId;
private int userId;
private String text;
private String stat;

public Task() {
}

public Task(int taskId, int userId, String text, String stat) {
	this.taskId = taskId;
	this.userId = userId;
	this.text = text;
	this.stat = stat;
}
public int getTaskId() {
	return taskId;
}
public void setTaskId(int taskId) {
	this.taskId = taskId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getStat() {
	return stat;
}
public void setStat(String stat) {
	this.stat = stat;
}


}
