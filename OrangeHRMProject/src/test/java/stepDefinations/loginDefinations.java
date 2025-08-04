package stepDefinations;

import com.orangeHRM.elementRepo.LoginPage;
import com.orangeHRM.genericPackage.BaseTest;
import com.orangeHRM.genericPackage.InitObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginDefinations extends BaseTest {
	  InitObjects init = new InitObjects();
	@Given("users should be navigate to {string} by opening the chrome browser")
	public void users_should_be_navigate_to_by_opening_the_chrome_browser(String url) {
       
		init.getWebDriver().get(url);

	}

	@When("user enters {string} as username and {string} as password")
	public void user_enters_as_username_and_as_password(String usn, String pass) {

		LoginPage lp = new LoginPage();
		lp.validLogin(usn, pass);

	}

	@Then("Home should be display")
	public void home_should_be_display() {

		System.out.println(init.driver.getTitle());

	}

}
