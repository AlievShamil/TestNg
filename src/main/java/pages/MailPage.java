package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MailPage extends BasePage {
    @FindBy(id = "mailbox__login")
    private WebElement mailLogin;

    @FindBy(id = "mailbox__password")
    private WebElement mailPassword;

    @FindBy(id = "mailbox__auth__button")
    public WebElement mailAuthBtn;

    @FindBy(xpath = "(//div[contains(@class,'item_unread')][.//div[text()='eBay']]//div[contains(text(),'Подтвердите ваш адрес')])[1]")
    public WebElement mailMessage;

    @FindBy(xpath = "//span[contains(text(),'Start Shopping')]")
    private WebElement gotoShoppingBtn;


    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Эл. почта":
                fillField(mailLogin, value);
                break;
            case "Password":
                fillField(mailPassword, value);
                break;
        }
    }

    public void checkRelevance() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath(".//*[@class='rbVideoBanner']"))
        ));
        assertTrue(mailMessage.isDisplayed());
    }
}



