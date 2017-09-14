import org.testng.annotations.Test;
import steps.*;

import java.util.HashMap;

public class MyTest extends BaseSteps  {
    MainPageSteps mainPageSteps = new MainPageSteps();
    RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();
    MailPageSteps mailPageSteps = new MailPageSteps();
    LoginPageSteps loginPageSteps = new LoginPageSteps();

    HashMap<String,String> testData = new HashMap<>();


    @Test(description = "Регистрация на ebay и поиск товара")
    public void test() {
        testData.put("Эл. почта","aplanatestng@mail.ru");
        testData.put("Подтверждение эл. почты","aplanatestng@mail.ru");
        testData.put("Пароль","123N123_nb");
        testData.put("Имя","Иван");
        testData.put("Фамилия","Иванов");

        mainPageSteps.goToRegistrationPage();
        registrationPageSteps.fillFields(testData);
        registrationPageSteps.clickToRegistration();
        registrationPageSteps.gotoMail();

        testData.put("Password","qwert12345");
        mailPageSteps.signInMail(testData);
        mailPageSteps.checkRelevanceOfLetter();
        mailPageSteps.gotoEbay();

        mainPageSteps.goToLoginPage();

        testData.clear();
        testData.put("Эл. почта","aplanatestng@mail.ru");
        testData.put("Пароль","123N123_nb");
        loginPageSteps.fillFields(testData);
        loginPageSteps.login();

        mainPageSteps.searchBlackberry();
        mainPageSteps.displayAmount();
        mainPageSteps.signOut();
        mainPageSteps.checkSignOut();
    }
}
