package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "sgnBt")
    public WebElement submitBtn;

    @FindBy(xpath = "//*[@placeholder='Адрес эл. почты или логин'][@type='text']")
    private WebElement email;

    @FindBy(xpath = "//*[@placeholder='Пароль'][@type='password']")
    private WebElement password;

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Эл. почта":
                fillField(email, value);
                break;
            case "Пароль":
                fillField(password, value);
                break;
        }
    }

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
