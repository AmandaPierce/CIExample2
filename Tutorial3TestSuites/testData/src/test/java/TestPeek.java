
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestPeek {

	protected Stack stack = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("-----Peek-----");
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("-----End Peek-----");
	}
	
	@Before 
	public void setUp() throws Exception {
		stack = new Stack(5);
		
		
	}
	
	@After 
	public void tearDown() throws Exception {
		stack = null;
	}

	//In order to test if calling peek after a character is pushed gives the same character once peeked, I first add a single 
	//character to the empty stack to make sure once peeked it returns the same character. Then I fill up the stack before
	//checking if the top character is equal to the last character I added. This is to see how the stack behaves with n elements.
	//Req4: Pass
	@Test
	public void testPeekReturnsCorrectValue() {
	
		try{
			stack.push('a');
			assertEquals(stack.peek(), 'a');
			stack.push('b');
			stack.push('c');
			stack.push('d');
			stack.push('e');

			assertEquals(stack.peek(), 'e');

			System.out.println("Req4: true");
		}
		catch(AssertionError e){
			System.out.println("Req4: false");
		}
		
		
	}
	
	//In order to test if an empty stack returns an ERROR if call peek() I first make sure that the stack is empty then I call stack.peek(). 
	//If stack.peek() fails an An ArrayIndexOutOfBoundsException Error should occur.
	//Req3: Pass
	//The fail method is called here to make sure that should an Error not occur the test will still fail like it should
	@Test
	public void testPeekEmptyStack() {
		

		try{
			assertTrue(stack.empty());
			stack.peek();
			System.out.println("Req3: false");
			
			fail("ArrayIndexOutOfBoundsException Error not thrown");
		}
		catch(Exception e){
			System.out.println("Req3: true");
		}
		
		
	}

}
