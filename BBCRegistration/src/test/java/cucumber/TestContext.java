package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManager;


public class TestContext {

	
	public WebDriverManager webDriverManager;
	public PageObjectManager page;
	
	public TestContext(){
		webDriverManager = new WebDriverManager();
		page = new PageObjectManager(webDriverManager.getDriver());
	}

	public WebDriverManager getWebDriverManager(){
		return webDriverManager;
	}

	public PageObjectManager getPageObjectrManager(){
		return page;
	}
	
}
