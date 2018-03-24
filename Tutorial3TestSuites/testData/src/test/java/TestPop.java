
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPop {

protected Stack stack = null;
protected Stack2 stack2 = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	
	@Before 
	public void setUp() throws Exception {
		stack = new Stack(5);
		stack2 = new Stack2(5);
		
		
	}
	
	@After 
	public void tearDown() throws Exception {
		stack = null;
	}

	//In order to test if an empty stack will return an empty stack on pop() I first check if the stack is indeed empty. 
	//Once this has been verified I pop() an element off the empty stack.
	//Req1: Fails
	//This method fails as calling pop() on an empty stack gives an ArrayIndexOutOfBoundsException Error instead of returning an empty stack 
	//because it tries to return an element at index -1. 
	@Test
	public void testPopOnEmptyStack() {
		
		try
		{
			assertTrue(stack.empty());
			stack.pop();
			assertTrue(stack2.empty());
			stack2.pop();
			
			
			System.out.println("Req1a: true");
			
		}
		catch(AssertionError e)
		{
			
			System.out.println(e + "Req1a: false");
		}
		catch(Exception e)
		{	
			System.out.println("Req1a: false. When the pop() function is called it tries to remove an item in the empty char elements array. The variable top is -1 and thus an ArrayIndexOutOfBoundsException error is thrown as pop() tries to return items[-1].");
		}
		
	}
	
	//In order to test if calling pop after you pushed a character returns the same character I first push a character onto
	//the empty stack and then compare it to the value returned by pop(). If it is equal I continue. I then fill up the stack and
	//compare them to the values they should be. Once they have all been removed from the Stack I test that the stack is 
	//empty again.
	//Req2: Pass
	
	@Test
	public void testPopAfterPushValue() {
		
		try
		{
			stack.push('a');
			assertEquals(stack.pop(), 'a');
			stack.push('a');
			stack.push('b');
			stack.push('c');
			stack.push('d');
			stack.push('e');
			
			
			assertEquals(stack.pop(), 'e');
			assertEquals(stack.pop(), 'd');
			assertEquals(stack.pop(), 'c');
			assertEquals(stack.pop(), 'b');
			assertEquals(stack.pop(), 'a');
			
			
			assertTrue(stack.empty());
			
			
			System.out.println("Req2: true");
		}
		catch(AssertionError e)
		{
			System.out.println(e + "Req2: false");
			
		}
		
	}


}
