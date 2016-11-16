package com.galleria.todo.controller;

import java.util.List;

import javax.swing.text.View;

import com.galleria.todo.model.Todo;
import com.galleria.todo.service.TodoService;

import spark.Request;
import spark.Response;
import spark.Route;

public class TodoController {
	
	private static TodoService todoService = new TodoService();
	
	public static Route getAllTodos = (Request request, Response response) ->{
		return todoService.getAllTodos();
	};
	
	public static Route getTodoById = (Request request, Response response) ->{
		String id = request.params("id");
		return todoService.getTodoById(id);
	};
	
	public static Route getTodoByStatus = (Request request, Response response) ->{
		String statusStr = request.params("status");
		Boolean status = ( statusStr.equalsIgnoreCase("pending") ) ? false : true;
		return todoService.getTodosByStatus(status);
	};
	
	public static Route createTodo = (Request request, Response response) ->{
		return null;
	};
	
	public static Route editTodo = (Request request, Response response) ->{
		return null;
	};
	
	public static Route updateTodoStatusById = (Request request, Response response) ->{
		return null;
	};
	
	public static Route deteleTodoById = (Request request, Response response) ->{
		return null;
	};
	
	/*
	
	public static List<Todo> getTodo(String id){
		return null;
	}
	
	public static Todo addTodo(String topic,String content){
		return null;
	}
	
	public static Todo editTodo(Boolean status){
		return null;
	}
	
	public static Todo updateTodoStatus(String id,Boolean status){
		return null;
	}
	*/
}
