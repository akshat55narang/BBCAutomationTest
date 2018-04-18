package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	public WebDriver driver;
	
	public SignInPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='link link--primary']")
	private WebElement buttonRegisterNow;
	
	public WebElement getRegisterNowButton(){
		return buttonRegisterNow;
	}
}
