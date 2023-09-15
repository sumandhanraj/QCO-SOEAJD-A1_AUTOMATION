package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consists of all the excel file data
 * @author suman
 *
 */
public class ExcelFileUtility
{
	/**
	 * this method reads the data from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @throws Throwable
	 */
public String readDataFromExcelFile(String sheetName,int rowNo,int cellNo) throws Throwable
{
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\exceladvsel.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	wb.close();
	return data;
	
}
/**
 * this method writes the data to excel
 * @param SheetName
 * @param RowNo
 * @param CellNo
 * @param value
 * @throws Throwable
 */
public void writaDataToExcel(String SheetName,int RowNo,int CellNo,String value) throws Throwable
{
	FileInputStream fisw = new FileInputStream(".\\src\\test\\resources\\exceladvsel.xlsx");
     Workbook wb1 = WorkbookFactory.create(fisw);
    wb1.createSheet(SheetName).createRow(RowNo).createCell(RowNo).setCellValue(value);

    FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\exceladvsel.xlsx");
    wb1.write(fos);
    wb1.close();
}

/**
 * this method will read multiple data from excel
 * @param Sheetname
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public Object[][]  readMutlipleDataFromExcel(String Sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream fism = new FileInputStream(".\\src\\test\\resources\\exceladvsel.xlsx");
	Workbook wb2 = WorkbookFactory.create(fism);
	Sheet sh = wb2.getSheet(Sheetname);
	int lastrow = sh.getLastRowNum();
	int lastcell = sh.getRow(0).getLastCellNum();
	
	Object[][] data= new Object[lastrow][lastcell];
	
	for(int i=0;i<lastrow;i++)
	{
		for(int j=0;j<lastcell;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return data;
	
}
}
