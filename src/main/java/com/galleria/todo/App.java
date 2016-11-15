package com.galleria.todo;

import com.galleria.todo.controller.TodoController;
import com.galleria.todo.util.Constants;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	port(8083);
        //get( Constants.getAllTodos , TodoController.getAllTodo );
    	get( "/dd" , (req,res)->{
    		return "Hello world";
    	});
    	get( Constants.getAllTodos , TodoController.getAllTodos );
    }
    
}
