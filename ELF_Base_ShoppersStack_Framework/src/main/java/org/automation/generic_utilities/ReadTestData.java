package org.automation.generic_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.automation.generic_utilities.ReadTestData.CheckExecutionRowException;
import org.automation.generic_utilities.ReadTestData.InvalidExecutionColumnException;
import org.automation.generic_utilities.ReadTestData.InvalidTestCaseIdException;

public class ReadTestData implements FrameworkConstants {

	public File absPath = new File(EXCEL_PATH);
	public Workbook wb = null;
	private Sheet dataSheet;
	private String testCaseName;
	private int totalRowsOfData, firstRowNum, lastRowNum, iterationRow;

	public int getTotalNoOfTestData() {
		return dataSheet.getPhysicalNumberOfRows();
	}

	private int getExecutionColumnNumber() {
		return dataSheet.getRow(firstRowNum).getPhysicalNumberOfCells();
	}

	private int getColumnCount() {
		int numOfCol = dataSheet.getRow(firstRowNum).getPhysicalNumberOfCells();
		return numOfCol;
	}

	private int getStartRowNo() throws InvalidTestCaseIdException {
		int count = 0;
		for (int i = 0; i < totalRowsOfData; i++) {
			String value = dataSheet.getRow(i).getCell(0).toString();
			if (value.equalsIgnoreCase(testCaseName.trim())) {
				count++;
				firstRowNum = i;
				break;
			}
		}

		if (count == 0)
			throw new InvalidTestCaseIdException();
		else
			return firstRowNum;
	}

	private int getLastRowNo() {
		for (int i = firstRowNum; i < totalRowsOfData; i++) {
			String value = dataSheet.getRow(i).getCell(0).toString();
			if (value.equalsIgnoreCase(testCaseName.trim())) {
				lastRowNum = i;
			}
		}
		return lastRowNum;
	}

	private int getNumOfIterationRows(int executionColumn) throws CheckExecutionRowException {
		for (int i = firstRowNum; i <= lastRowNum; i++) {
			if (dataSheet.getRow(i).getCell(executionColumn - 1).toString().equalsIgnoreCase("Yes")) {
				iterationRow++;
			}
		}
		if (iterationRow == 0)
			throw new CheckExecutionRowException();
		else
			return iterationRow;

	}

	public double readNumberDataFromExcel(String sheetName, int rowNum, int cellNum) {
		try {
			FileInputStream fis = new FileInputStream(absPath);
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
	}

	public boolean readBooleanDataFromExcel(String sheetName, int rowNum, int cellCount) {
		try {

			FileInputStream fis = new FileInputStream(absPath);
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellCount).getBooleanCellValue();
	}

	public String readStringDataFromExcel(String sheetName, int rowNum, int cellCount) {

		try {
			FileInputStream fis = new FileInputStream(absPath);
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		  Sheet sheet = wb.getSheet(sheetName);
          Row row = sheet.getRow(rowNum);
          Cell cell = row.getCell(cellCount);
          
          String data=null;
          
			if(cell.getCellType()==cell.getCellType().STRING)
			{
				data=cell.getStringCellValue();
			}
			else if(cell.getCellType()==cell.getCellType().NUMERIC)
			{
				
				data=String.valueOf(cell.getNumericCellValue());
			}
			return data;
      
	}
	

	public Date readDateDataFromExecl(String sheetName, int rowNum, int cellCount) {

		try {
			FileInputStream fis = new FileInputStream(absPath);
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellCount).getDateCellValue();
	}

	public String readAnyDataFromExcelInString(String sheetName,int rowNum,int cellNum)
	{
	  File absPath=new File(EXCEL_PATH);
	  Workbook wb=null;
	  
	  
	  try {
		FileInputStream fis = new FileInputStream(absPath);  
		wb=WorkbookFactory.create(fis);
	} catch (EncryptedDocumentException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	  
	  return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
	  
	}
	
	public String[][] readAllDataFromExcel(String sheetName)
	{
		try {
		FileInputStream fis = new FileInputStream(absPath);
		wb=WorkbookFactory.create(fis);
		}
		catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int phyRowCount = wb.getSheet(sheetName).getPhysicalNumberOfRows();
		int phyCellCount = wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
		
		String[][] sarr = new String [phyRowCount] [phyCellCount];
		
		for(int i=0;i<phyRowCount;i++)
		{
			for(int j=0;i<phyCellCount;i++)
			{
			 	sarr[i][j]=wb.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return sarr;
		
	}
	
	public String[][] readTestDataFromExcel(String sheetName, String testCaseName)
			throws InvalidTestCaseIdException, CheckExecutionRowException, InvalidExecutionColumnException {

		FileInputStream fis;
		this.testCaseName = testCaseName;
		try {
			fis = new FileInputStream(absPath);
			wb= WorkbookFactory.create(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		dataSheet = wb.getSheet(sheetName);
		totalRowsOfData = getTotalNoOfTestData();
		getStartRowNo();
		getLastRowNo();
		int executionColNum = getExecutionColumnNumber();
		int totalcolData = getColumnCount() - 2;
		getNumOfIterationRows(executionColNum);

		int row = 0;
		String[][] sarr = new String[iterationRow][totalcolData];
		for (int i = 0, k = firstRowNum; i <= (lastRowNum-firstRowNum); i++, k++) {
			if (dataSheet.getRow(k).getCell(executionColNum-1).toString().equalsIgnoreCase("Yes")) {
				for (int j = 0, l = 1; j < totalcolData; j++, l++) {
					sarr[row][j] = dataSheet.getRow(k).getCell(l).toString();
				}
				row++;
			}
		}
		return sarr;
	}
	public String readDataFromPropertyFile(String key) {

		File absPath;
		FileInputStream fis;
		Properties properties = null;
		try {
			absPath = new File(PROPERTY_PATH);
			fis = new FileInputStream(absPath);
			properties = new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

	public int getLastRowNum(String sheetName)
	{
		try {
			FileInputStream fis = new FileInputStream(absPath);
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb.getSheet(sheetName).getLastRowNum();
	}
	// *****************************************************************************
	// ==============================Custom Exceptions==============================
	// *****************************************************************************

	@SuppressWarnings("Serial")
	public class InvalidTestCaseIdException extends Exception {
		public InvalidTestCaseIdException() {
			super("Test Data for the given Test case id is not present in the given excel file");
		}
	}

	@SuppressWarnings("Serial")
	public class InvalidExecutionColumnException extends Exception {

		public InvalidExecutionColumnException() {
			super("Given Execution column number is invalid");

		}

	}

	@SuppressWarnings("serial")
	public class CheckExecutionRowException extends Exception {

		public CheckExecutionRowException() {
			super("Total number of iterations selected is 0. Please check execution column in test data file");
		}
	}

}
