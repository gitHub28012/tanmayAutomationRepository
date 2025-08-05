package working_with_TestNgExecution;

import org.testng.annotations.Test;

public class GroupExecution {
	
  @Test(groups = "Smoke")
  public void LoginTest() {
	  System.out.println("Executing login TestCase");
  }
  
  @Test(groups = "Smoke")
  public void RegisterTest()
  {
	  System.out.println("Executing register TestCase");
  }
  
  @Test(groups = "Functional")
  public void SearchTest()
  {
	  System.out.println("Exceuting serach TestCase");
  }
  
}

