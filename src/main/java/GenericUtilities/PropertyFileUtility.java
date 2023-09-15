package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * this class contains the generic utility
 * @author Suman
 *
 *
 */
public class PropertyFileUtility
{
	/**
	 * this method reads the data from property file and return to caller
	 * @param key
	 * @return
	 * @throws Throwable
	 */
 public String readDataFromPropertyFile(String key) throws Throwable
 {
	 FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Common.properties");
	 Properties putil = new Properties();
	 putil.load(fis);
	 String value = putil.getProperty(key);

	 return value;
 }
}

