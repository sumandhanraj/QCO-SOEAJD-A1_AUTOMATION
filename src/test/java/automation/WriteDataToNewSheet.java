package automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToNewSheet
{
 public static void main(String[] args) throws Throwable 
 {
	//step 1 open the file in java readable format
	 FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\exceladvsel.xlsx");
	 
	 //step 2 create work book factory
	 Workbook wb = WorkbookFactory.create(fis);
	 
	 //step 3 create new sheet
	 Sheet sh = wb.createSheet("sheet3");
	 
	 //step 4 create new row
	Row row = sh.createRow(3);
	
	 //step 5 create new cell
	 Cell cel = row.createCell(3);
	 
	 //step 6 provide the required data
	 cel.setCellValue("SUMAN");
	 
	 //step 7 open the doccument in writable format
	 FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\exceladvsel.xlsx");
	 
	 //step 8 write the data
	 wb.write(fos);
	 System.out.println("data added successfully");
	 
	 //close the workbook
	 wb.close();
}
}
