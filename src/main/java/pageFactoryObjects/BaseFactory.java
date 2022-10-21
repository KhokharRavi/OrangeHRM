package pageFactoryObjects;

import org.openqa.selenium.WebElement;

abstract class BaseFactory {
	
	protected abstract WebElement getWaitUntilVisibilityOf(WebElement element);
}
