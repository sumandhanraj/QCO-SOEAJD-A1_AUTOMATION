package GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * this class consists of all the reusable methods related to java
 * @author ASUS
 *
 */
public class JavaUtility 
{
	
public int randomNumber()
/**
 * this method will give random numbers
 * @return
 */
{
	Random r = new Random();
	int ran = r.nextInt(1000);
	return ran;
}

public String getSystemDate()
/**
 * this method will generate system date in specified format
 * @return
 */
{
	Date d = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
	String date = formatter.format(d);
	return date;
	
}
}
