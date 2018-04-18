package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationAge {

	
	public WebDriver driver;
	
	public RegistrationAge(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='day-input']")
	private WebElement inputDay;
	
	@FindBy(xpath="//input[@id='month-input']")
	private WebElement inputMonth;
	
	@FindBy(xpath="//input[@id='year-input']")
	private WebElement inputYear;
	
	@FindBy(xpath="//*[text()='Continue']")
	private WebElement buttonContinue;
	
	
	@FindBy(xpath="//p[@class='form-message__text']")
	private WebElement messageEmptyYear;
	
	@FindBy(xpath="//*[@id='form-message-dateOfBirth']")
	private WebElement messageDateOfBirth;
	
	//field field--active field--with-icon field--valid field--last
	@FindBy(xpath="//*[@class='field field--active field--with-icon field--valid field--last']")
	private WebElement messageValidationYear;
	
	public WebElement getDayField(){
		return inputDay;
	}
	
	public WebElement getMonthField(){
		return inputMonth;
	}
	
	public WebElement getYearField(){
		return inputYear;
	}
	
	public WebElement getContinueButton(){
		return buttonContinue;
	}
	
	public WebElement getEmptyYearFieldErrorMessage(){
		return messageEmptyYear;
	}
	
	public WebElement getDateOfBirthErrorMessage(){
		return messageDateOfBirth;
	}
	
	public WebElement getYearValidationTick(){
		return messageValidationYear;
	}
	
}
