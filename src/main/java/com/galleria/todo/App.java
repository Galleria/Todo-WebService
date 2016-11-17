package com.galleria.todo;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;

import com.galleria.todo.constants.TodoApiConstants;
import com.galleria.todo.controller.TodoController;
import com.google.gson.Gson;

public class App 
{
	private static int port = 8083;
	
    public static void main( String[] args ){
    	setupService();
    	initialService();
    	setupSwaggerService();
    }
    
    private static void setupService(){
    	port( port );
    }
    
    private static void initialService(){
    	TodoController todoController = new TodoController();
    	get( TodoApiConstants.getAllTodos , todoController.getAllTodos , new Gson()::toJson);
    	get( TodoApiConstants.getTodoById , todoController.getTodoById , new Gson()::toJson);
    	get( TodoApiConstants.getTodoByStatus , todoController.getTodoByStatus , new Gson()::toJson);
    	
    	post( TodoApiConstants.createTodo , todoController.createTodo , new Gson()::toJson);
    	
    	put( TodoApiConstants.editTodo , todoController.createTodo , new Gson()::toJson);
    	put( TodoApiConstants.updateTodoStatusById , todoController.updateTodoStatusById , new Gson()::toJson);
    	
    	delete( TodoApiConstants.deleteTodoById , todoController.deteleTodoById );
    	
    }
    
    private static void setupSwaggerService(){
    	
    }
    
}
