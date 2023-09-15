package TestNgPractise;

import org.testng.annotations.Test;

public class TestngPriority
{
@Test(priority = 1)
public void createContact()
{
	System.out.println("create contact");
}

@Test(priority = 2)
public void modifyContact()
{
	System.out.println("modify contact");
}

@Test(priority = 3)
public void deleteContact()
{
	System.out.println("delete contact");
}
}
