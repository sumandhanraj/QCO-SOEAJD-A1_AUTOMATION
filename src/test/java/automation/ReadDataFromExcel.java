package automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel
{
  public static void main(String[] args) throws Throwable
  {
	//step 1 read the file in java readable format
	  FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\exceladvsel.xlsx");
	  
	  //step 2 create work book
	Workbook wb = WorkbookFactory.create(fis);
	
	  //step 3 navigate to req sheet
	 Sheet sh = wb.getSheet("Organizations");
	 
	  //step 4 navigate to req row
	  Row row = sh.getRow(1);
	  
	  //step 5 navigate to req cell
	  Cell cell = row.getCell(2);
	  
	  //step 6 read the cell value
	 String data = cell.getStringCellValue();
	 System.out.println(data);
	 
	  //step 7 close the workbook
	 wb.close();
}
} 
