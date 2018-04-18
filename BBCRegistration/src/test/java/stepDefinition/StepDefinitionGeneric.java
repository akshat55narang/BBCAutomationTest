package stepDefinition;


import com.aventstack.extentreports.model.Log;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class StepDefinitionGeneric {

	public TestContext testContext;
	
	public StepDefinitionGeneric(TestContext test) {
		testContext=test;
	}
	
	@Before
	public void before(Scenario scenario ){
		System.out.println(scenario.getName());
	}
	
	@After
	public void after(){
		testContext.getWebDriverManager().closeBrowser();
	}
}
