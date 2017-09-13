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

    @FindBy(xpath = "//*[@id='b-letters']/div[1]/div[2]/div/div[2]/div[3]/div/a/div[2]/span[2]/div")
    private WebElement mailMessage;

    @FindBy(name = "Перейти к покупкам")
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
        Wait<WebDriver> wait = new WebDriverWait(driver, 3, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//*[@id='b-letters']/div[1]/div[2]/div/div[2]/div[3]/div/a/div[2]/span[2]/div"))
        ));
        assertEquals("b-letterstatus b-letterstatus_unread", driver.findElement(By.xpath("//*[@id='b-letters']/div[1]/div[2]/div/div[2]/div[3]/div/a/div[2]/span[2]/div")).getAttribute("class"));

    }

    public void accountActivation() {
        mailMessage.click();

    }


}
