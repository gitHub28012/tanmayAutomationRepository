package good;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.SystemOutLogger;

import com.automation.genericpackage.FrameworkConstants;

public class Demo implements FrameworkConstants  {
	
	int firstRowNo;
	int lastRowNo;
	
	 public static void main(String[] args) throws EncryptedDocumentException, IOException, InvalidTestCaseIdException {
		 
		 Demo demo = new Demo();
	
		 System.out.println(demo.getTotalNoOfTestData());
		 System.out.println(demo.getStartRowNo());
		 System.out.println(demo.getLastRowNo());
		
	}
	 
	 
      // returns the total number of rows which has data/value present	 
	 public int getTotalNoOfTestData() throws EncryptedDocumentException, IOException
	 {
		 FileInputStream fis = new FileInputStream(EXCEL_PATH1);
		 return WorkbookFactory.create(fis).getSheet("Sheet1").getPhysicalNumberOfRows();
	 }
	 
	 
	 //returns the row from which you want to start reading the data/value
	 public int getStartRowNo() throws EncryptedDocumentException, IOException, InvalidTestCaseIdException
	 {
		int totalRowsOfData=4; 
		int count=0;
		String testCaseID="TC_Register_001";
		for(int i=0;i<totalRowsOfData;i++)
		{
			 FileInputStream fis = new FileInputStream(EXCEL_PATH1);
			 String value = WorkbookFactory.create(fis).getSheet("Sheet1").getRow(i).getCell(0).toString();
			 if(value.equalsIgnoreCase(testCaseID.trim()))
			 {
				 count++;
				 firstRowNo=i;
			 }		
	      }
		if (count == 0)
			throw new InvalidTestCaseIdException();
		else
			return firstRowNo;
}
	 //returns the row from which you want to last reading the data/value
	 public int getLastRowNo() throws EncryptedDocumentException, IOException
	 {
		int firstRowNo=1;
		 int totalRowsOfData=3; 
		 String testCaseID="TC_Register_001";
		 
		 for(int i=firstRowNo;i<totalRowsOfData;i++)
		 {
			 FileInputStream fis = new FileInputStream(EXCEL_PATH1);
			 String value = WorkbookFactory.create(fis).getSheet("Sheet1").getRow(i).getCell(0).toString();
			 if(value.equalsIgnoreCase(testCaseID.trim()))
			 {
				 lastRowNo=i;
			 }		
		 }
		 
		 return lastRowNo;
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @SuppressWarnings("serial")
		public class InvalidExecutionColumnException extends Exception {

			public InvalidExecutionColumnException() {
				super("Given Execution column number is invalid");
			}
		}
	 

		@SuppressWarnings("serial")
		public class InvalidTestCaseIdException extends Exception {

			public InvalidTestCaseIdException() {
				super("Test Data for the given Test case id is not present in the given excel file");
			}
		}

		@SuppressWarnings("serial")
		public class CheckExecutionRowException extends Exception {

			public CheckExecutionRowException() {
				super("Total number of iterations selected is 0. Please check execution column in test data file");
			}
		}

	 
	 
	 
	 
}