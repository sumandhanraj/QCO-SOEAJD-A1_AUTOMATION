package TestNgPractise;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(GenericUtilities.ListenerImplementation.class)

public class ListnerPractise
{
@Test
public void demo()
{
	Assert.fail();
	System.out.println("Hi");
}
@Test
public void demo1()
{
	System.out.println("Hello");
}
}
