package com.galleria.todo.controller;

import java.util.ArrayList;
import java.util.List;

import com.galleria.todo.model.Todo;
import com.galleria.todo.model.response.TodoResponse;
import com.galleria.todo.service.TodoService;
import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;

public class TodoController {

	private TodoService todoService;
	private Gson gson = new Gson();

	public TodoController() {
		this.todoService = new TodoService();
	}

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	public Route getAllTodos = (Request request, Response response) -> {
		List<Todo> todos = todoService.getAllTodos();
		List<TodoResponse> todoResList = new ArrayList<>();
		todos.forEach(todo -> {
			todoResList.add(new TodoResponse(todo));
		});
		return todoResList;
	};

	public Route getTodoById = (Request request, Response response) -> {
		String id = request.params(":id");
		Todo todo = todoService.getTodoById(id);
		TodoResponse todoRes = (todo == null) ? null : new TodoResponse(todo);
		return todoRes;
	};

	public Route getTodoByStatus = (Request request, Response response) -> {
		String statusStr = request.params(":status");
		Boolean status;
		if (statusStr.equalsIgnoreCase("pending") || statusStr.equalsIgnoreCase("done")) {
			status = (statusStr.equalsIgnoreCase("pending")) ? false : true;
		} else {
			status = Boolean.parseBoolean(request.params(":status"));
		}
		List<Todo> todos = todoService.getTodosByStatus(status);
		List<TodoResponse> todoResList = new ArrayList<>();
		todos.forEach(todo -> {
			todoResList.add(new TodoResponse(todo));
		});
		return todoResList;
	};

	public Route createTodo = (Request request, Response response) -> {
		Todo todo = gson.fromJson(request.body(), Todo.class);
		System.out.println("in Todo" );
		todo = todoService.createTodo(todo);
		TodoResponse todoRes = (todo == null) ? null : new TodoResponse(todo);
		return todoRes;
	};

	public Route updateTodo = (Request request, Response response) -> {
		Todo todo = gson.fromJson(request.body(), Todo.class);
		todo = todoService.updateTodoById(todo.getId(), todo);
		TodoResponse todoRes = (todo == null) ? null : new TodoResponse(todo);
		return todoRes;
	};

	public Route updateTodoStatusById = (Request request, Response response) -> {
		String statusStr = request.params(":status");
		Boolean status;
		if (statusStr.equalsIgnoreCase("pending") || statusStr.equalsIgnoreCase("done")) {
			status = (statusStr.equalsIgnoreCase("pending")) ? false : true;
		} else {
			status = Boolean.parseBoolean(request.params(":status"));
		}
		String id = request.params(":id");

		Todo todo = todoService.updateTodoStatusById(id, status);
		TodoResponse todoRes = (todo == null) ? null : new TodoResponse(todo);
		return todoRes;
	};

	public Route deteleTodoById = (Request request, Response response) -> {
		String id = request.params(":id");
		return todoService.deleteTodoById(id);
	};

}
