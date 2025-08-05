package genericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTestData {
	
 	File absPath=new File("./src/test/resources/TutorialsNinjaTestData.xlsx");
 	Workbook wb;
 	Sheet sheet;
 	
 	
 	public String readStringData(String sheetName,int rowCount,int cellCount)
 	{
 		
 		try {
 			FileInputStream fis = new FileInputStream(absPath);
			wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		sheet=wb.getSheet(sheetName);
 		return sheet.getRow(rowCount).getCell(cellCount).toString();
 	}
 	
 	public Date readDateData(String sheetName,int rowCount,int cellCount)
 	{
 		
 		try {
 			FileInputStream fis = new FileInputStream(absPath);
			wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		sheet=wb.getSheet(sheetName);
 		return sheet.getRow(rowCount).getCell(cellCount).getDateCellValue();
 	}
 	
 	/**
 	 * 
 	 * @param sheetName
 	 * @return last count of row counts first row from : 0
 	 */
 	
 	public int getLastRow(String sheetName)
 	{
 		
 		try {
 			FileInputStream fis = new FileInputStream(absPath);
			wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		sheet=wb.getSheet(sheetName);
 		return sheet.getLastRowNum();
 	}
 	
	/**
 	 * 
 	 * @param sheetName
 	 * @return last count of row counts first row from : 1
 	 */
 	public int getAllRowCount(String sheetName)
 	{
 		try {
 			FileInputStream fis = new FileInputStream(absPath);
			wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		sheet=wb.getSheet(sheetName);
 		return sheet.getPhysicalNumberOfRows();
 	}
 	
	/**
 	 * 
 	 * @param sheetName
	 * @return last count of column counts first row from : 1
 	 */
 	public int getLastColumn(String sheetName)
 	{
 		try {
 			FileInputStream fis = new FileInputStream(absPath);
			wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		sheet=wb.getSheet(sheetName);
 		return sheet.getRow(0).getPhysicalNumberOfCells();
 	}



}
