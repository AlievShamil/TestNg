package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;

    protected void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
    public boolean isElementPresent(WebElement element) {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return false;
    }


    public void fillFieldIfPresent(WebElement element, String value) {
        if (isElementPresent(element)) {
            element.clear();
            element.sendKeys(value);
        }
    }
}
