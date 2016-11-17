package com.galleria.todo.model;

import io.swagger.annotations.ApiModelProperty;

public class Todo {
	
	private String id;
	private String topic;
	private String content;
	private Boolean status;

	public Todo(String id, String topic, String content, Boolean status) {
		super();
		this.id = id;
		this.topic = topic;
		this.content = content;
		this.status = status;
	}

	public Todo(String topic, String content, Boolean status) {
		super();
		this.topic = topic;
		this.content = content;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
