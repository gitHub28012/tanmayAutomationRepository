package tests;

import org.testng.annotations.Test;

import genericUtility.ReadTestData;

public class ReadAllDataTest {
	
	
	@Test
	public void readAllData()
	{
		
		ReadTestData rtd = new ReadTestData();
		
		int lastRow = rtd.getLastRow("registration");
		System.out.println("this method return last count of row from sheet counts from 0 : "+lastRow);
		System.out.println("this method return all rows count from given sheet counts from 1 : "+rtd.getAllRowCount("registration"));
		System.out.println("this method return all column count from given sheet counts from 1 : "+rtd.getLastColumn("registration"));
		System.out.println();
	
		for(int i=0;i<rtd.getAllRowCount("registration");i++)
		{
			for(int j=0;j<rtd.getLastColumn("registration");j++)
			{
				System.out.print(rtd.readStringData("registration", i, j)+" ");
				//System.out.println();
				
			}
			System.out.println();
			System.out.println();
		}
		
	}

}
