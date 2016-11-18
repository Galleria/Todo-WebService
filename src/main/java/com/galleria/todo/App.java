package com.galleria.todo;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.options;

import static spark.Spark.before;
import static spark.Spark.after;
import static spark.Spark.staticFileLocation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.galleria.todo.constants.Constants;
import com.galleria.todo.constants.SwaggerApiConstants;
import com.galleria.todo.constants.TodoApiConstants;
import com.galleria.todo.controller.TodoController;
import com.galleria.todo.util.SwaggerParser;
import com.google.gson.Gson;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import spark.Spark;

@SwaggerDefinition(
		host = "localhost:8083",
		info = @Info(
				description = "Todo Webservice API for testing", 
				title = "Todo Webservice", 
				version = "V0.1",
				contact = @Contact(name = "Supachai", url = "https://github.com/Galleria/Todo-WebService")
		),
		schemes = { SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS },
		consumes = { "application/json" },
		produces = { "application/json" },
		tags = { @Tag(name = "swagger") }
)
public class App {
	private static int port = 8083;

	public static void main(String[] args) throws JsonProcessingException {
		setupService();
		initialService();
		setupSwaggerService();
	}

	private static void setupService() {
		port(port);
		staticFileLocation(Constants.swaggerUIPath);
		Spark.staticFiles.disableMimeTypeGuessing();
		
		before( new CorsFilter() );
		after( (req,res) -> {
			res.type("application/json");
		});
	}

	private static void initialService() {
		TodoController todoController = new TodoController();
		get(TodoApiConstants.getAllTodos , todoController.getAllTodos, new Gson()::toJson);
		get(TodoApiConstants.getTodoById, todoController.getTodoById, new Gson()::toJson);
		get(TodoApiConstants.getTodoByStatus, todoController.getTodoByStatus, new Gson()::toJson);

		post(TodoApiConstants.createTodo, todoController.createTodo, new Gson()::toJson);
		options(TodoApiConstants.createTodo, todoController.createTodo, new Gson()::toJson);
		
		put(TodoApiConstants.editTodo, todoController.createTodo, new Gson()::toJson);
		options(TodoApiConstants.editTodo, todoController.createTodo, new Gson()::toJson);
		put(TodoApiConstants.updateTodoStatusById, todoController.updateTodoStatusById, new Gson()::toJson);
		options(TodoApiConstants.updateTodoStatusById, todoController.updateTodoStatusById, new Gson()::toJson);
		
		delete(TodoApiConstants.deleteTodoById, todoController.deteleTodoById);
		options(TodoApiConstants.deleteTodoById, todoController.deteleTodoById);
	}

	private static void setupSwaggerService() throws JsonProcessingException {
		final String swaggerJson = SwaggerParser.getSwaggerJson(Constants.packageSwaggerPath);
		get(SwaggerApiConstants.getSwaggerJson, (req, res) -> {
			return swaggerJson;
		});
	}

}
