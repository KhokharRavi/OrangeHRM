package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactoryObjects.PageFactoryLogin;
import utils.Constant;
import utils.TestData;

public class LoginTest extends BaseTest {

	private WebDriver webDriver;
	private PageFactoryLogin pageLogin;

	@BeforeTest
	@Override
	protected void setUp() {
		// setup chrome or firefox driver
		webDriver = getChromeDriver(Constant.URL_ORANGEHRM_LOGIN);
		pageLogin = new PageFactoryLogin(webDriver);
		printTestStarted("Login page");
	}

	@Test(priority = 1)
	public void testLoginTitle() {
		// verify title first
		log("Verifying title using valid data");
		String title = pageLogin.getLoginPageTitle();
		Assert.assertTrue(title.equals("Login"));
		log("Test Passed...\n");
	}
	

	@Test(priority = 2)
	public void testLoginwithValidCredentials() {
		// verify user credentials
		log("Passing valid username and Password");
		pageLogin.executeLogin(TestData.USERNAME, TestData.PASSWORD);
		log("Verifying credentials...");
		Assert.assertTrue(webDriver.getCurrentUrl().equals(Constant.URL_ORANGEHRM_HOME), "Error, Login failed!! "+webDriver.getCurrentUrl());
		log("Test Passed...");
	}
	

	@AfterTest
	@Override
	protected void close() {
		printTestEnded("Login page");
		webDriver.close();
	}

}
