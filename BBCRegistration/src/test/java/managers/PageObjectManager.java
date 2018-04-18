package managers;

import javax.imageio.spi.RegisterableService;

import org.openqa.selenium.WebDriver;

import objectRepository.RegistrationAge;
import objectRepository.RegistrationDetails;
import objectRepository.RegistrationPage;
import objectRepository.SignInPage;

public class PageObjectManager {

	public SignInPage signin;
	public RegistrationPage register;
	public WebDriver driver;
	public RegistrationAge age;
	public RegistrationDetails details;
	
	public PageObjectManager(WebDriver driver){
		this.driver=driver;
	}
	
	public SignInPage getSignInPage(){
		return (signin==null)? signin = new SignInPage(driver): signin;
	}
	
	public RegistrationPage getRegistrationPage(){
		return (register==null)? register = new RegistrationPage(driver):register;
	}

	public RegistrationAge getRegistrationAgePage(){
		return (age==null)? age = new RegistrationAge(driver):age;
	}

	public RegistrationDetails getRegistrationDetailsPage(){
		return (details==null)? details = new RegistrationDetails(driver):details;
	}
}
