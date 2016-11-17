package com.galleria.todo.model.response;

import org.junit.Assert;
import org.junit.Test;

import com.galleria.todo.model.Todo;

public class TodoResponseTest {

	private Boolean pending = false;
	private Boolean done = true;
	
	private String pendingStr = "pending";
	private String doneStr = "done";
	
	@Test
	public void createTodoResponse_ShouldBeReturn_Status_Pending(){
		TodoResponse tdRes = new TodoResponse("XXX", "YYY", pending);
		Assert.assertEquals( pendingStr , tdRes.getTodoStatus() );
	}
	
	@Test
	public void createTodoResponse_ShouldBeReturn_Status_Done(){
		TodoResponse tdRes = new TodoResponse("XXX", "YYY", done);
		Assert.assertEquals( doneStr , tdRes.getTodoStatus() );
	}

	@Test
	public void createTodoResposne_Clone_ShouldBeReturn_Same_Todo_pending(){
		Todo todo = new Todo("99","Clone Todo","cloning",pending);
		TodoResponse tdRes = new TodoResponse(todo);
		Assert.assertEquals( todo.getId() , tdRes.getId() );
		Assert.assertEquals( todo.getTopic() , tdRes.getTopic() );
		Assert.assertEquals( todo.getContent() , tdRes.getContent() );
		Assert.assertEquals( pendingStr , tdRes.getTodoStatus() );
	}
	
	@Test
	public void createTodoResposne_Clone_ShouldBeReturn_Same_Todo_done(){
		Todo todo = new Todo("99","Clone Todo","cloning",done);
		TodoResponse tdRes = new TodoResponse(todo);
		Assert.assertEquals( todo.getId() , tdRes.getId() );
		Assert.assertEquals( todo.getTopic() , tdRes.getTopic() );
		Assert.assertEquals( todo.getContent() , tdRes.getContent() );
		Assert.assertEquals( doneStr , tdRes.getTodoStatus() );
	}
}
