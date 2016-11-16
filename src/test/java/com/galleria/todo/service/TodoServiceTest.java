package com.galleria.todo.service;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.galleria.todo.model.Todo;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {
	
	private TodoService todoService;

	private ArrayList<Todo> todosList;
	
	private Boolean pending = false;
	private Boolean done = true;
	
	@Before
	public void init(){
		todosList = new ArrayList<>();
		todosList.add( new Todo( "1" , "Create Todo Service" , "For Testing" , pending ) ) ;
		todosList.add( new Todo( "2" , "Create Api Document" , "..." , pending ) );
		todosList.add( new Todo( "3" , "Design Architecture" , "Fantastic" , done ) );
		todoService = new TodoService(todosList);
	}
	
	@Test
	public void getAlltodos_ShouldBeReturn_Size_3(){
		Assert.assertEquals( 3 , todoService.getAllTodos().size() );
	}
	
	@Test
	public void getTodoById_1_ShouldBeReturnAndEqual_TodoId_1(){
		Assert.assertEquals( todosList.get(0) , todoService.getTodoById("1") );
	}
	
	@Test
	public void getTodoById_3_ShouldBeReturnButNotEuqal_TodoId_1(){
		Assert.assertNotEquals( todosList.get(1) , todoService.getTodoById("3") );
	}
	
	@Test
	public void getTodoById_99_ShouldBeReturnNull(){
		Assert.assertNull( todoService.getTodoById("99") );
	}
	
	@Test
	public void getTodoByStatus_Pending_ShouldBeReturn_Size_2(){
		Assert.assertEquals( 2 , todoService.getTodosByStatus(pending).size() );
	}
	
	@Test
	public void getTodoByStatus_Done_ShouldBeReturn_Size_1(){
		Assert.assertEquals( 1 , todoService.getTodosByStatus(done).size() );
	}
	
	
}
