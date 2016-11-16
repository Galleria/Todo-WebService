package com.galleria.todo;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;

import com.galleria.todo.constants.TodoApiConstants;
import com.galleria.todo.controller.TodoController;

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
    	get( TodoApiConstants.getAllTodos , TodoController.getAllTodos );
    	get( TodoApiConstants.getTodoById , TodoController.getTodoById );
    	get( TodoApiConstants.getTodoByStatus , TodoController.getTodoByStatus );
    	
    	post( TodoApiConstants.createTodo , TodoController.createTodo );
    	
    	put( TodoApiConstants.editTodo , TodoController.createTodo );
    	put( TodoApiConstants.updateTodoStatusById , TodoController.updateTodoStatusById );
    	
    	delete( TodoApiConstants.deleteTodoById , TodoController.deteleTodoById );
    	
    }
    
    private static void setupSwaggerService(){
    	
    }
    
}
