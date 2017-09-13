package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {

    @FindBy(id = "firstname")
    private WebElement firstname;

    @FindBy(id = "lastname")
    private WebElement lastname;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "remail")
    private WebElement remail;

    @FindBy(id = "PASSWORD")
    private WebElement password;

    @FindBy(id = "phoneFlagComp1")
    private WebElement phone;

    @FindBy(id = "ppaFormSbtBtn")
    public WebElement submitBtn;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Эл. почта":
                fillField(email, value);
                break;
            case "Подтверждение эл. почты":
                fillField(remail, value);
                break;
            case "Имя":
                fillField(firstname, value);
                break;
            case "Фамилия":
                fillField(lastname, value);
                break;
            case "Пароль":
                fillField(password, value);
                break;
            case "Телефон":
                fillField(phone, value);
                break;
        }
    }
}
