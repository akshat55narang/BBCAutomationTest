package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationDetails {

public WebDriver driver;
	
	public RegistrationDetails(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='user-identifier-input']")
	private WebElement inputEmail;
	
	@FindBy(xpath="//input[@id='password-input']")
	private WebElement inputPassword;
	
	@FindBy(xpath="//div[@id='form-message-email']")
	private WebElement messageEmailError;
	
	@FindAll(value = { @FindBy(xpath="//div[@id='form-message-email']") })
	private List<WebElement> listEmailErrorMessage;
	
	@FindAll(value = { @FindBy(xpath="//div[@id='form-message-password']") })
	private List<WebElement> listPasswordErrorMessage;	
	
	@FindBy(xpath="//div[@id='form-message-password']")
	private WebElement messagePasswordError;
	
	
	@FindBy(xpath="//p[@class='form-message__text']")
	private WebElement messageEmptyYear;
	
	@FindBy(xpath="//*[@id='form-message-dateOfBirth']")
	private WebElement messageDateOfBirth;
	
	public WebElement getEmailInputField(){
		return inputEmail;
	}
	
	public WebElement getPasswordImputField(){
		return inputPassword;
	}
	
	public WebElement getEmailErrorMessage(){
		return messageEmailError;
	}
	
	public WebElement getPasswordErrorMessage(){
		return messagePasswordError;
	}
	
	public WebElement getEmptyYearFieldErrorMessage(){
		return messageEmptyYear;
	}
	
	public WebElement getDateOfBirthErrorMessage(){
		return messageDateOfBirth;
	}
	
	public List<WebElement> getListOfEmailErrorMessage(){
		return listEmailErrorMessage;
	}
	
	public List<WebElement> getListOfPasswordErrorMessage(){
		return listEmailErrorMessage;
	}
	
	
}
