package steps;

import pages.LoginPage;
import pages.RegistrationPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static steps.BaseSteps.getDriver;

public class LoginPageSteps {
    @Step("поле {0} заполняется значением {1}")
    private void fillField(String field, String value){
        new LoginPage(getDriver()).fillField(field, value);
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach(this::fillField);
    }

    @Step("выполнен вход в личный кабинет'")
    public void login(){
        new LoginPage(getDriver()).submitBtn.click();
    }

}
