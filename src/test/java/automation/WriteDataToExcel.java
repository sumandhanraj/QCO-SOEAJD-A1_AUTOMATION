package automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel 
{
 public static void main(String[] args) throws Throwable 
 {
	//step 1 open the file in java readable format
	 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\exceladvsel.xlsx");
	 
	 //step 2 create the workbook factory
	 Workbook wb = WorkbookFactory.create(fis);
	 
	 //step 3 navigate to sheet
	Sheet sh = wb.getSheet("Contacts");
	
	 //step 4 navigate to row
	     Row row = sh.getRow(4);
	     
	 //step 5 create to cell
	 Cell cel = row.createCell(5);
	 
	 //step 6 provide the data to be written
	 cel.setCellValue("SELINIUM");
	 
	 //step 7 open docc in writable format
	 FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\exceladvsel.xlsx");
	 
	 //step 8 write the data
	 wb.write(fos);
	 System.out.println("data added successfully");
	 
	 //step 9 close the workbook
	 wb.close();
}
}
