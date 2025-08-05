package working_with_TestNgExecution;

import org.testng.annotations.Test;

public class GroupExceution1 {
  @Test(groups = "Regression")
  public void AddToCartTest() {
	  System.out.println("Exceuting Add to cart TestCase");
  }
  
  @Test(groups = "Regression")
  public void SubscribeTest()
  {
	  System.out.println("Exceuting subscribe TestCase");
  }
  
  @Test(groups = "Functional")
  public void VoteTest()
  {
	  System.out.println("Exceuting Vote TestCase");
  }
}
