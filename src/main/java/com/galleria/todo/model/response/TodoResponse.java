package com.galleria.todo.model.response;

import com.galleria.todo.model.Todo;

public class TodoResponse extends Todo{
	
	private String todoStatus;
	
	public TodoResponse(String topic, String content, Boolean status) {
		super(topic, content, null);
		setTodoStatusByStatus(status);
	}
	
	private void setTodoStatusByStatus(Boolean status){
		todoStatus = status ? "done" : "pending";
	}
	
	public TodoResponse(Todo todo){
		super( todo.getId() , todo.getTopic() , todo.getContent() , null );
		setTodoStatusByStatus( todo.getStatus() );
	}

	public String getTodoStatus() {
		return todoStatus;
	}

	public void setTodoStatus(String todoStatus) {
		this.todoStatus = todoStatus;
	}

}
