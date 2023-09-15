package automation;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractise 
{
 public static void main(String[] args) throws Throwable {
	
 

	/*PropertyFileUtility putil = new PropertyFileUtility();
	String browser = putil.readDataFromropertyFile("browser");
	System.out.println(browser);
	
	String un = putil.readDataFromropertyFile("username");
	System.out.println(un);
	
	ExcelFileUtility eutil = new ExcelFileUtility();
	String data = eutil.readDataFromExcelFile("Contacts", 4, 3);
	System.out.println(data);
	
	eutil.writaDataToExcel("trial1", 0, 0, "spiderMan");
	System.out.println("data added successfully");*/
	 
	 
	 JavaUtility jutil = new JavaUtility();
	 int r = jutil.randomNumber();
	 System.out.println(r);
	 String date = jutil.getSystemDate();
	 System.out.println(date);
	
}
}

