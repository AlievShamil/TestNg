package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;

    protected void fillField(WebElement element, String value) {
        if (isElementPresent(element)) {
            element.clear();
            element.sendKeys(value);
        }
    }

    private boolean isElementPresent(WebElement element) {
        try {
//            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return false;
    }
}
