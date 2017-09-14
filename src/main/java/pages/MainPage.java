package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(),'зарегистрируйтесь')]")
    public WebElement signUpBtn;

    @FindBy(xpath = "//*[contains(text(),'Войдите')]")
    public WebElement signInBtn;

    @FindBy(id = "gh-btn")
    private WebElement findBtn;

    @FindBy(id = "gh-ac")
    private WebElement searchElement;

    @FindBy(id = "cbBtmElem")
    private WebElement displayAmountMenu;

    @FindBy(id = "gh-ug")
    private WebElement authorizationMenu;

    @FindBy(id = "gh-uu")
    private WebElement personalMenu;

    @FindBy(xpath = "//div[@class='ds3pHCnt']")
    public WebElement successfulExitElem;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void searchItem() {
        fillField(searchElement, "blackberry");
        findBtn.click();
    }

    public void checkDisplayQuantity() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", displayAmountMenu);
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(
                displayAmountMenu.findElement(By.xpath("//a[@aria-labelledby='e1-11']"))
        ));
        assertEquals(displayAmountMenu.findElement(By.xpath("//a[contains(@aria-labelledby,'e1-11')]")).getText(),"50");
    }

    public void scrollAndSignOut() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", authorizationMenu);
        authorizationMenu.findElement(By.xpath("//b[contains(@class,'gh-eb-arw')]")).click();
//        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(
//        )).click();
        personalMenu.findElement(By.xpath("//a[contains(text(),'Выход')]")).click();
    }

    public void successfulExit() {
        isElementPresent(successfulExitElem);
    }


}
