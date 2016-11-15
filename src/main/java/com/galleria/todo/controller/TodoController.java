package com.galleria.todo.controller;

import java.util.List;

import javax.swing.text.View;

import com.galleria.todo.model.Todo;

import spark.Request;
import spark.Response;
import spark.Route;

public class TodoController {
	
	public static Route getAllTodos = (Request request, Response response) ->{
		return "SS";
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
