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

    @FindBy(xpath = ".//*[@id='sbtBtn']")
    public WebElement submitBtn;

    @FindBy(xpath = ".//*[@id='ppaFormSbtBtn']")
    public WebElement subBtn;

    @FindBy(xpath = ".//*[text()='Заменить учетную запись']")
    public WebElement changeReg;

    @FindBy(xpath = ".//*[contains(text(),'отправили вам ссылку')]")
    public WebElement linkToReg;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickSubmit() {
        if(isElementPresent(subBtn)){
            new WebDriverWait(getDriver(),10).until(ExpectedConditions.elementToBeClickable(subBtn)).click();
        } else {
            new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        }
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(changeReg));
        changeReg.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(linkToReg));

    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Имя":
                fillField(firstname, value);
                break;
            case "Фамилия":
                fillField(lastname, value);
                break;
            case "Эл. почта":
                fillField(email, value);
                break;
            case "Пароль":
                fillField(password, value);
                break;
            case "Подтверждение эл. почты":
                fillFieldIfPresent(remail, value);
                break;
        }
    }
}
