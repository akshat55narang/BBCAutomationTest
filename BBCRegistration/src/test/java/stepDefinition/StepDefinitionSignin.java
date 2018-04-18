package stepDefinition;

import org.junit.Assert;

import objectRepository.SignInPage;
import managers.WebDriverManager;
import cucumber.TestContext;
import cucumber.api.java.en.*;

public class StepDefinitionSignin {

	public TestContext testContext;
	public SignInPage signin;
	
	public StepDefinitionSignin(TestContext test) {
		testContext=test;
		signin = testContext.getPageObjectrManager().getSignInPage();
	}
	
	@Given("^I launch https://account\\.bbc\\.com/signin$")
	public void i_launch_https_account_bbc_com_signin() throws Throwable {
	    
	    
	}

	@When("^I click \"([^\"]*)\" now$")
	public void i_click_now(String arg1) throws Throwable {
	   signin.getRegisterNowButton().click();
	}

	@Then("^I'm on the starting page for registration$")
	public void i_m_on_the_starting_page_for_registration() throws Throwable {
	    Assert.assertEquals("BBC – Register", testContext.getWebDriverManager().getDriver().getTitle());
	}

}
