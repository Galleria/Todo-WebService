package com.galleria.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.galleria.todo.model.Todo;

public class TodoService {
	private List<Todo> todosList;

	public TodoService() {
		this.todosList = new ArrayList<>();
		mockTodos();
	}
	
	public TodoService(List<Todo> todos) {
		this.todosList = todos;
	}
	
	private Boolean pending = false;
	private Boolean done = true;
	
	private void mockTodos(){
		todosList.add( new Todo( "1" , "Create Todo Service" , "For Testing" , pending ) ) ;
		todosList.add( new Todo( "2" , "Create Api Document" , "..." , pending ) );
		todosList.add( new Todo( "3" , "Design Architecture" , "Fantastic" , done ) );
	}
	
	public List<Todo> getAllTodos(){
		return this.todosList;
	}
	
	public Todo getTodoById(String id){
		try{
			return todosList.stream().filter( td -> td.getId().equals(id) ).findFirst().get();
		}
		catch(NoSuchElementException ex){
			return null;
		}
	}

	public List<Todo> getTodosByStatus(Boolean status){
		try{
			return todosList.stream().filter( td -> td.getStatus().equals(status) ).collect( Collectors.toList() );
		}
		catch(NoSuchElementException ex){
			return null;
		}
	}
	
	public Todo createTodo(Todo todo){
		try{
			todo.setId( Integer.toString( todosList.size()+1 ) );
			this.todosList.add(todo);
			return todo;
		}
		catch(NoSuchElementException ex){
			return null;
		}
	}
	
	public Todo updateTodoById(String id,Todo updateTodo){
		try{
			Todo todo = todosList.stream().filter( td -> td.getId().equals(id) ).findFirst().get() ;
			todo.setTopic( updateTodo.getTopic() );
			todo.setContent( updateTodo.getContent() );
			todo.setStatus( updateTodo.getStatus() );
			return todo;
		}
		catch(NoSuchElementException ex){
			return null;
		}
	}
	
	public Todo updateTodoStatusById(String id,Boolean status){
		try{
			Todo todo = todosList.stream().filter( td -> td.getId().equals(id) ).findFirst().get() ;
			todo.setStatus( status );
			return todo;
		}
		catch(NoSuchElementException ex){
			return null;
		}
	}
	
	public Boolean deleteTodoById(String id){
		try{
			Todo todo = todosList.stream().filter( td -> td.getId().equals(id) ).findFirst().get() ;
			todosList.remove( todo ) ;
			return true;
		}
		catch(NoSuchElementException ex){
			return false;
		}
	}
}
