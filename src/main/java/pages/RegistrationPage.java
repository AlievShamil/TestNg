package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static steps.BaseSteps.getDriver;

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

    @FindBy(xpath = ".//*[@id='sbtBtn']")
    public WebElement submitBtn;

    @FindBy(xpath = ".//*[text()='Заменить учетную запись']")
    public WebElement changeReg;

    @FindBy(xpath = ".//*[contains(text(),'отправили вам ссылку')]")
    public WebElement linkToReg;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickSubmit(){
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();
        new WebDriverWait(getDriver(),5).until(ExpectedConditions.visibilityOf(changeReg));
        changeReg.click();
        new WebDriverWait(getDriver(),5).until(ExpectedConditions.visibilityOf(linkToReg));

    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Эл. почта":
                fillField(email, value);
                break;
            case "Подтверждение эл. почты":
                fillFieldIfPresent(remail, value);
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
                fillFieldIfPresent(phone, value);
                break;
        }
    }
}
