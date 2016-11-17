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
    	TodoController todoController = new TodoController();
    	get( TodoApiConstants.getAllTodos , todoController.getAllTodos );
    	get( TodoApiConstants.getTodoById , todoController.getTodoById );
    	get( TodoApiConstants.getTodoByStatus , todoController.getTodoByStatus );
    	
    	post( TodoApiConstants.createTodo , todoController.createTodo );
    	
    	put( TodoApiConstants.editTodo , todoController.createTodo );
    	put( TodoApiConstants.updateTodoStatusById , todoController.updateTodoStatusById );
    	
    	delete( TodoApiConstants.deleteTodoById , todoController.deteleTodoById );
    	
    }
    
    private static void setupSwaggerService(){
    	
    }
    
}
