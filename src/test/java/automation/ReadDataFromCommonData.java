package automation;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromCommonData 
{
 public static void main(String[] args) throws Throwable 
 {
	//step 1 readthe file in java readable
	 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Common.properties");
	
	 //step 2 create obj for property class
	 Properties p=new Properties();
	 
	 //step 3 load the file into properties
	 p.load(fis);
	 
	 //step 4 provide the key and read the value
	String BROWSER = p.getProperty("browser");
	System.out.println(BROWSER);
	String USERNAME = p.getProperty("username");
	System.out.println(USERNAME);
}
}
