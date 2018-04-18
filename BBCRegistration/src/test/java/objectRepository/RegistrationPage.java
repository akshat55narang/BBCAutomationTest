package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	public WebDriver driver;
	
	public RegistrationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='Under 13']")
	private WebElement buttonThirteenOrUnder;
	
	@FindBy(xpath="//span[text()='13 or over']")
	private WebElement buttonThirteenOrOver;
	
	@FindBy(xpath="//p[@class='text heading u-padding-bottom-single']/span")
	private WebElement messageUnder13ErrorMessage;
	
	@FindBy(id="submit-button")
	private WebElement buttonContinue;
	
	//form-message__text
	@FindBy(className="form-message__text")
	private WebElement messageIncorrectDate;
	
	public WebElement getThirteenOrOverButton(){
		return buttonThirteenOrOver;
	}

	public WebElement getThirteenOrUnderButton(){
		return buttonThirteenOrUnder;
	}
	
	public WebElement getUnderThirteenErrorMessage(){
		return messageUnder13ErrorMessage;
	}
	
	public WebElement getContinueButton(){
		return buttonContinue;
	}
	
	public WebElement getIncorrectDateMessage(){
		return messageIncorrectDate;
	}
}
