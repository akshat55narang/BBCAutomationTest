package managers;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {
	
	public WebDriver driver;
	public ConfigFileManager fileReadManager;
	public WebDriverWait wait;
	private static String path = System.getProperty("user.dir");
	private Actions action;
	
	public WebDriverManager(){
		
	}
	
	public WebDriver getDriver(){
		return (driver==null)? driver = openBrowser():driver;
	}
	
	public Actions getAction(){
		return (action==null)?action = new Actions(getDriver()):action;
	}
	
	public WebDriver openBrowser(){
		
		String url = ConfigFileManager.getInstance().getConfiguration().getApplicationURL();
		String browser = ConfigFileManager.getInstance().getConfiguration().getApplicationBrowser();
		String implicitWait = ConfigFileManager.getInstance().getConfiguration().getimplicitWait();
		String chromeDriverLinux=ConfigFileManager.getInstance().getConfiguration().getChromeDriverPathLinux();
		String operatingSystem = ConfigFileManager.getInstance().getConfiguration().getOS();
		String chromeDriverWindows = ConfigFileManager.getInstance().getConfiguration().getChromeDriverPathWindows();
		
		if(browser.equals("chrome")){
			
			if(operatingSystem.equals("Linux")){
				System.setProperty("webdriver.chrome.driver", path+chromeDriverLinux);
				driver = new ChromeDriver();
			}
			
			else if(operatingSystem.equals("Windows")){
				System.setProperty("webdriver.chrome.driver", path+chromeDriverWindows);
				driver = new ChromeDriver();
			}
			
		}
		
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(implicitWait), TimeUnit.SECONDS);
		return driver;
	
	}
	
	public WebDriverWait getExplicitWait(WebElement element,String waitType){
		Long explicitWait = ConfigFileManager.getInstance().getConfiguration().getExplicitWait();
		
		wait = new WebDriverWait(getDriver(), explicitWait);
		if(waitType.equals("visibility")){
			wait.until(ExpectedConditions.visibilityOf(element));
			return wait;
		}
		else if(waitType.equals("visibility")){
			wait.until(ExpectedConditions.invisibilityOf(element));
			return wait;
		}
		else if(waitType.equals("clickable")){
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return wait;
		}
		else {
			throw new RuntimeException("Wait type "+waitType+" is not supported");
			
		}
	}
	
	public void closeBrowser(){
		getDriver().close();
	}
	
	

}
