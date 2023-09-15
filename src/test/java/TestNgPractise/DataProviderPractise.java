package TestNgPractise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise
{
@Test(dataProvider = "getInfo")
public void addProductToCart(String name,String model)
{
	System.out.println(name+ "-"+model );
}
@Test(dataProvider = "getData")
public void addProductToCart1(String name,String model,int price)
{
	System.out.println(name+ "-"+model+ "-"+price);
}
@DataProvider
public Object[][] getData()
{
	Object[][] data = new Object[4][3];
	
	data[0][0] = "Redmi";
	data[0][1] = "7pro";
	data[0][2] = 14000;
	
	data[1][0] = "Realme";
	data[1][1] = "8pro";
	data[1][2] = 15000;
	
	data[2][0] = "oppo";
	data[2][1] = "5pro";
	data[2][2] = 17000;
	
	data[3][0] = "vivo";
	data[3][1] = "11pro";
	data[3][2] = 19000;
	return data;
	
}
@DataProvider
public Object[][] getInfo()
{
	Object[][] data = new Object[2][2];
	
	data[0][0] = "nokia";
	data[0][1] = "7pro";
	
	
	data[1][0] = "oneplus";
	data[1][1] = "8pro";
  return data;
}
}