package stepDefinition;


import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import objectRepository.RegistrationAge;
import objectRepository.RegistrationDetails;
import objectRepository.RegistrationPage;
import cucumber.TestContext;
import cucumber.api.java.en.*;

public class StepDefinitionRegistration {
	
	public TestContext testContext;
	public RegistrationPage register;
	public RegistrationAge age;
	public RegistrationDetails details;
	//public Actions action;
		
	public StepDefinitionRegistration(TestContext test) {
		testContext=test;
		register=testContext.getPageObjectrManager().getRegistrationPage();
		age = testContext.getPageObjectrManager().getRegistrationAgePage();
		details = testContext.getPageObjectrManager().getRegistrationDetailsPage();
		
	}


@When("^I click on \"([^\"]*)\" button$")
public void i_click_on_button(String age) throws Throwable {
    if(age.equals("13 or over")){
    	register.getThirteenOrOverButton().click();
    	 }
    else if(age.equals("under 13")){
    	register.getThirteenOrUnderButton().click();
    	}
}

@Then("^I will go to the \"([^\"]*)\" registration$")
public void i_will_go_to_the_registration(String arg1) throws Throwable {
  Assert.assertEquals("BBC – Register – enter your date of birth", testContext.getWebDriverManager().getDriver().getTitle());
	
}

@Then("^I will receive the following message: \"([^\"]*)\"$")
public void i_will_receive_the_following_message(String message) throws Throwable {
    Assert.assertEquals(message,register.getUnderThirteenErrorMessage().getText());
}

@Given("^I'm on the date of birth registration page$")
public void i_m_on_the_date_of_birth_registration_page() throws Throwable {
    register.getThirteenOrOverButton().click();
    
}

@When("^The field Day is empty$")
public void the_field_Day_is_empty() throws Throwable {
	//Actions a = new Actions(testContext.getWebDriverManager().getDriver());
	//a.moveToElement(age.getDayField()).sendKeys(Keys.TAB).build().perform();
	age.getDayField().sendKeys(Keys.TAB);
}

@When("^The field Month is empty$")
public void the_field_Month_is_empty() throws Throwable {
	//Actions a = new Actions(testContext.getWebDriverManager().getDriver());
	//a.moveToElement(age.getMonthField()).click().sendKeys(Keys.TAB).build().perform();
	//age.getMonthField().sendKeys(Keys.TAB);
}

@When("^The field Year is empty$")
public void the_field_Year_is_empty() throws Throwable {
	age.getYearField().sendKeys(Keys.TAB);
	//age.getYearField().sendKeys(Keys.TAB);
	testContext.getWebDriverManager().getExplicitWait(age.getEmptyYearFieldErrorMessage(), "visibility");
}

@Then("^When I leave the year field I should receive the following message: \"([^\"]*)\"$")
public void when_I_leave_the_year_field_I_should_receive_the_following_message(String arg1) throws Throwable {
    Assert.assertEquals("Oops, that date doesn't look right. Make sure it's a real date written as DD-MM-YYYY e.g. the 5th of June 2009 is 05-06-2009.", age.getEmptyYearFieldErrorMessage().getText());
}

@When("^The field Day is (\\d+)$")
public void the_field_Day_is(int day) throws Throwable {
    age.getDayField().sendKeys(Integer.toString(day));
}

@When("^The field Month is (\\d+)$")
public void the_field_Month_is(int month) throws Throwable {
    age.getMonthField().sendKeys(Integer.toString(month));
    age.getMonthField().sendKeys(Keys.TAB);
    
}

@When("^The field Year is (\\d+)$")
public void the_field_Year_is(int year) throws Throwable {
	String years = Integer.toString(year);
	if(years.equals("2010")){
		age.getYearField().sendKeys(years);
		age.getYearField().sendKeys(Keys.TAB);
		
		}
	else if(years.equals("1990")){
		age.getYearField().sendKeys(years);
		age.getYearField().sendKeys(Keys.TAB);
		}
}

@When("^Click the \"([^\"]*)\" button$")
public void click_the_button(String arg1) throws Throwable {
	Thread.sleep(5000);
	Actions action = new Actions(testContext.getWebDriverManager().getDriver());
	action.moveToElement(age.getContinueButton()).click().build().perform();
  }

@Then("^When I click I should receive the following message: \"([^\"]*)\"$")
public void when_I_click_I_should_receive_the_following_message(String message) throws Throwable {
   if(message.equals("Sorry, you need to be 13 or over.")){
		Assert.assertTrue(age.getDateOfBirthErrorMessage().getText().equals(message));
	}
}

@Then("^When I click I should go to the email registration page$")
public void when_I_click_I_should_go_to_the_email_registration_page() throws Throwable {
	
	Assert.assertEquals("BBC – Register – enter your details", testContext.getWebDriverManager().getDriver().getTitle());
}

@Given("^I'm on the registration page for e-mail and password$")
public void i_m_on_the_registration_page_for_e_mail_and_password() throws Throwable {
	register.getThirteenOrOverButton().click();
	testContext.getWebDriverManager().getExplicitWait(age.getDayField(), "visibility");
	age.getDayField().sendKeys("03");
	age.getMonthField().sendKeys("03");
	age.getYearField().sendKeys("1990");
    Thread.sleep(5000);
	Actions action = new Actions(testContext.getWebDriverManager().getDriver());
	action.moveToElement(age.getContinueButton()).click().build().perform();
  //  testContext.getWebDriverManager().getExplicitWait(element, waitType)
}

@When("^The field e-mail is filled in by \"([^\"]*)\"$")
public void the_field_e_mail_is_filled_in_by_whoknowshotmail_com(String email) throws Throwable {
    if(email.equals("whoknows@hotmailcom")){
    	details.getEmailInputField().sendKeys(email);
    	details.getEmailInputField().sendKeys(Keys.TAB);
    	 }
    else if(email.equals("whoknows@hotmail.com")){
    	details.getEmailInputField().sendKeys(email);
    	details.getEmailInputField().sendKeys(Keys.TAB);
    }
}

@When("^Go to password field$")
public void go_to_password_field() throws Throwable {
   // details.getPasswordImputField().click();
   // testContext.getWebDriverManager().getExplicitWait(details.getEmailErrorMessage(), "visibility");
    
    
  }

@Then("^I'll receive the message: \"([^\"]*)\"$")
public void i_ll_receive_the_message(String message) throws Throwable {
     Assert.assertTrue(details.getEmailErrorMessage().getText().equals(message));
    System.out.println(details.getEmailErrorMessage().getText());

}

@Then("^I should not receive an error$")
public void i_should_not_receive_an_error() throws Throwable {
	System.out.println(details.getListOfEmailErrorMessage().size());
}

@When("^The field password is filled in with: \"([^\"]*)\"$")
public void the_field_password_is_filled_in_with(String password) throws Throwable {
	if(password.equals("Whokno3")){
    details.getPasswordImputField().sendKeys(password);
    details.getPasswordImputField().sendKeys(Keys.TAB);
	}
	
	else if(password.equals("Whoknows")){
	    details.getPasswordImputField().sendKeys(password);
	    details.getPasswordImputField().sendKeys(Keys.TAB);
		}
	
	else if(password.equals("@345678!")){
	    details.getPasswordImputField().sendKeys(password);
	    details.getPasswordImputField().sendKeys(Keys.TAB);
		}
}

@Then("^I should receive the error: \"([^\"]*)\"$")
public void i_should_receive_the_error(String error) throws Throwable {
    if(error.equals("Sorry, that password is too short. It needs to be eight characters or more.")){
    	Assert.assertEquals(error, details.getPasswordErrorMessage().getText());
    }
    
    else if(error.equals("Sorry, that password isn't valid. Please include something that isn't a letter.")){
    	Assert.assertEquals(error, details.getPasswordErrorMessage().getText());
        
    }
    
    else if(error.equals("Sorry, that password isn't valid. Please include a letter.")){
    	Assert.assertEquals(error, details.getPasswordErrorMessage().getText());
        
    }
    
}

}
