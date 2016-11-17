package com.galleria.todo.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.galleria.todo.model.Todo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Todo List Api")
@Path("/")
public class SwaggerController {

	@GET
	@Path("todos")
	@Produces("application/json")
	@ApiOperation(value = "get all todo list")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response = Todo.class, responseContainer = "Array") })
	public void getAllTodos() {

	}
	
	@GET
	@Path("todos/{id}")
	@Produces("application/json")
	@ApiOperation(value = "get todo by id")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response=Todo.class ),
	})
	public void getTodoById (@ApiParam(value = "todo id", required = true) @PathParam("id")String id){

	}
	
	@GET
	@Path("todos/status/{status}")
	@Produces("application/json")
	@ApiOperation(value = "get todo by status" , notes="staus is pending or false , done or true")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response=Todo.class, responseContainer = "Array") ,
	})
	public void getTodoByStatus (@ApiParam(value = "todo status", required = true) @PathParam("status")String status){

	}
	
	@POST
	@Path("todo/create")
	@Produces("application/json")
	@ApiOperation(value = "create todo")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response=Todo.class) ,
	})
	public void createTodo ( Todo todo ){

	}
	
	@PUT
	@Path("todo/{id}/edit")
	@Produces("application/json")
	@ApiOperation(value = "update todo by id")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response=Todo.class) ,
	})
	public void updateTodo (  @ApiParam(value = "todo id", required = true) @PathParam("id")String id,
			Todo todo){

	}

	@PUT
	@Path("/todo/{id}/staus/{status}")
	@Produces("application/json")
	@ApiOperation(value = "update todo status by id" , notes="staus is pending or false , done or true")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response=Todo.class) ,
	})
	public void updateTodoStatusById ( @ApiParam(value = "todo id", required = true) @PathParam("id")String id ,
			@ApiParam(value = "todo status", required = true) @PathParam("status")String status){

	}
	
	@DELETE
	@Path("/todo/{id}/delete")
	@Produces("application/json")
	@ApiOperation(value = "delete todo by id" )
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response=String.class ,responseContainer="success or failed") 
	})
	public void deleteTodoById ( @ApiParam(value = "todo id", required = true) @PathParam("id")String id ){

	}
}
