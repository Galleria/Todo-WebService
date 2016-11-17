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
	
	@Test
	public void createTodo_ShouldBeReturn_newTodo_Id4(){
		Todo todo = new Todo( "new todo" , "new todo Testing" , pending );
		Assert.assertEquals( "4" ,  todoService.createTodo( todo ).getId() );
	}
	
	@Test
	public void updateTodoById_ShouldBeReturn_New_Topic(){
		Assert.assertEquals( "Design Architecture" ,  todoService.getTodoById("3").getTopic() );
		Todo updateTodo = new Todo( "Change Todo Topic" , "new todo Testing" , pending );
		Assert.assertEquals( "Change Todo Topic" ,  todoService.updateTodoById( "3" ,  updateTodo ).getTopic() );
	}
	
	@Test
	public void updateTodoById_ShouldBeReturn_New_Content(){
		Assert.assertEquals( "Fantastic" ,  todoService.getTodoById("3").getContent() );
		Todo updateTodo = new Todo( "Change Todo Topic" , "new todo Testing" , pending );
		Assert.assertEquals( "new todo Testing" ,  todoService.updateTodoById( "3" ,  updateTodo ).getContent() );
	}
	
	@Test
	public void updateTodoById_ShouldBeReturn_New_Status(){
		Assert.assertEquals( pending ,  todoService.getTodoById("2").getStatus() );
		Todo updateTodo = new Todo( "Change Todo Topic" , "new todo Testing" , done );
		Assert.assertEquals( done ,  todoService.updateTodoById( "2" ,  updateTodo ).getStatus() );
	}
	
	@Test
	public void updateTodoById_ShouldBeReturn_Null_NotFound(){
		Todo updateTodo = new Todo( "Change Todo Topic" , "new todo Testing" , done );
		Assert.assertNull( todoService.updateTodoById( "99" ,  updateTodo ) );
	}
	
	@Test
	public void updateTodoStatusById_ShouldBeReturn_Status_Done(){
		Assert.assertEquals( done ,  todoService.updateTodoStatusById( "2" ,  done ).getStatus() );
	}

	@Test
	public void updateTodoStatusById_ShouldBeReturn_Status_Pending(){
		Assert.assertEquals( pending ,  todoService.updateTodoStatusById( "2" ,  pending ).getStatus() );
	}
	
	@Test
	public void updateTodoStatusById_ShouldBeReturn_Null_NotFound(){
		Assert.assertNull( todoService.updateTodoStatusById( "99" ,  done ) );
	}
	
	@Test
	public void deleteTodoById_ShouldBeReturn_true_DeleteSuccess(){
		Assert.assertTrue( todoService.deleteTodoById("1") );
	}
	
	@Test
	public void deleteTodoById_ShouldBeReturn_false_DeleteFailed(){
		Assert.assertFalse( todoService.deleteTodoById("99") );
	}
	
	@Test
	public void deleteTodoById_ShouldBeReturn_true_DeleteSuccess_And_Return_false_NextDeleteSameIdBefore(){
		Assert.assertTrue( todoService.deleteTodoById("1") );
		Assert.assertFalse( todoService.deleteTodoById("1") );
	}
	
}
