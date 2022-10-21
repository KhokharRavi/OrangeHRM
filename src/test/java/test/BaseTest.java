package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {

	private boolean isLogEnable = true;

	private boolean isChromeDriver = true;

	

	/**
	 * All setup or configuration will be done in this method before executing test
	 */

	protected abstract void setUp();

	/**
	 * Detach or release all resources after completing test cases
	 */

	protected abstract void close();
	
	protected void setChromeDriverEnable(boolean isChromeDriver) {
		this.isChromeDriver = isChromeDriver;
	}

	protected WebDriver getWebDriver(String url) {
		if (isChromeDriver)
			return getChromeDriver(url);
		return getFireFoxDriver(url);
	}
	
	protected WebDriver getChromeDriver(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\testing\\chrome-driver\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		// webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.get(url);
		return webDriver;
	}

	protected WebDriver getFireFoxDriver(String url) {
		System.setProperty("webdriver.gecko.driver", "C:\\testing\\gecko-driver\\geckodriver.exe");
		WebDriver webDriver = new FirefoxDriver();
		// webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.get(url);
		return webDriver;
	}

	

	protected void log(String message) {
		if (isLogEnable)
			System.out.println(message);
	}

	protected void printTestStarted(String title) {
		// log("==============================================");
		log("============== " + title.toUpperCase() + " TESTS STARTED" + " ==============\n");
	}

	protected void printTestEnded(String title) {
		log("\n============== " + title.toUpperCase() + " TESTS ENDED" + " ===============\n");
		// log("==============================================");
	}
}
