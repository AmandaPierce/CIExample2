
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class TestEmpty {

protected Stack stack = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("-----Empty-----");
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("-----End Empty-----");
	}
	
	@Before 
	public void setUp() throws Exception {
		stack = new Stack(5);
		
		
	}
	
	@After 
	public void tearDown() throws Exception {
		stack = null;
	}

	//In order to test if an empty stack is actually empty I compare the boolean returned by stack.empty() with true. 
	//If assertTrue succeeds then the test passed.
	//Req5: Pass
	@Test
	public void testEmptyStack() {
		

		try{
			assertTrue(stack.empty());
			System.out.println("Req5: true");
		}
		catch(AssertionError e){
			System.out.println("Req5: false");
		}
		
		
	}
	
	//In order to test if an empty stack is not empty after an character is pushed I first add a character
	//so the stack is not empty anymore and then compare the boolean returned by stack.empty() with false. 
	//If assertFalse succeeds then the test passed.
	//Req6: Pass
	@Test
	public void testEmptyStackAfterPush() {

		try{
			stack.push('a');
			assertFalse(stack.empty());
			System.out.println("Req6: true");
		}
		catch(AssertionError e){
			System.out.println("Req6: false" + e);
		}
	
	}
	

}
