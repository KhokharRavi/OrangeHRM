package pageFactoryObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Constant;

public class PageFactoryLogin extends BaseFactory {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name = "username")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login;
	
	@FindBy(xpath =  "//h5")
	private WebElement title;
	
	@FindBy(xpath =  "//h6")
	private WebElement homeTitle;

	public PageFactoryLogin(WebDriver driver) {
		super();
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(Constant.WAIT_DURATION));
		PageFactory.initElements(this.driver, this);
	}

	public void setUserName(String userName) {
		getWaitUntilVisibilityOf(this.userName).sendKeys(userName);
	}

	public void setPassword(String password) {
		getWaitUntilVisibilityOf(this.password).sendKeys(password);
	}

	public void clickLogin() {
		login.click();
	}
	
	public void executeLogin(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
		this.clickLogin();
	}

	public String getLoginPageTitle() {
		return getWaitUntilVisibilityOf(title).getText();
	}
	
	public String getHomePageTitle() {
		return getWaitUntilVisibilityOf(homeTitle).getText();
	}

	@Override
	protected WebElement getWaitUntilVisibilityOf(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

}
