package automation;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractise 
{
@Test
public void test()
{
	System.out.println("hi hello");
	
	Assert.assertEquals("a", "a");
	
	System.out.println("good morning");
}

@Test
public void test2()
{
	SoftAssert sa = new SoftAssert();
	
	System.out.println("step 1");
	sa.assertEquals(1, 1);
	System.out.println("step 2");
	System.out.println("step 3");
	sa.assertEquals(true, true);
	System.out.println("step 4");
	sa.assertAll();
}
}
