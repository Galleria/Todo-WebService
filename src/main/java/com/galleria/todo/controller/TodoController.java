package com.galleria.todo.controller;

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
	
	public Route getAllTodos = (Request request, Response response) ->{
		return todoService.getAllTodos();
	};
	
	public Route getTodoById = (Request request, Response response) ->{
		String id = request.params(":id");
		return todoService.getTodoById(id);
	};
	
	public Route getTodoByStatus = (Request request, Response response) ->{
		String statusStr = request.params(":status");
		Boolean status = ( statusStr.equalsIgnoreCase("pending") ) ? false : true;
		return todoService.getTodosByStatus(status);
	};
	
	public Route createTodo = (Request request, Response response) ->{
		Todo todo = gson.fromJson(  request.body() , Todo.class ); 
		todo = todoService.createTodo(todo);
		TodoResponse tdRes = new TodoResponse( todo );
		return tdRes;
	};
	
	public Route updateTodo = (Request request, Response response) ->{
		Todo todo = gson.fromJson(  request.body() , Todo.class ); 
		todo = todoService.updateTodoById( todo.getId() , todo);
		TodoResponse tdRes = new TodoResponse( todo );
		return tdRes;
	};
	
	public Route updateTodoStatusById = (Request request, Response response) ->{
		String statusStr = request.params(":status");
		Boolean status;
		if( statusStr.equalsIgnoreCase("pending") || statusStr.equalsIgnoreCase("done") ){
			status = ( statusStr.equalsIgnoreCase("pending") ) ? false : true;
		}else{
			status = Boolean.parseBoolean( request.params(":status") );
		}
		String id = request.params(":id");
		
		Todo todo = todoService.updateTodoStatusById( id , status );
		TodoResponse tdRes = new TodoResponse( todo );
		return tdRes;
	};
	
	public Route deteleTodoById = (Request request, Response response) ->{
		String id = request.params(":id");
		return todoService.deleteTodoById(id);
	};

}
