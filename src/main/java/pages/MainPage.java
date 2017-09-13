package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{

    @FindBy(xpath = "//*[contains(text(),' зарегистрируйтесь')]")
    public WebElement registrationBtn;

    @FindBy(id = "gh-ac")
    public WebElement searchElement;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }



}
