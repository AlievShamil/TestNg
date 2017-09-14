package steps;

import pages.RegistrationPage;
import ru.yandex.qatools.allure.annotations.Step;
import util.TestProperties;

import java.util.HashMap;
import java.util.Properties;

import static steps.BaseSteps.getDriver;

public class RegistrationPageSteps{

    @Step("поле {0} заполняется значением {1}")
    private void fillField(String field, String value){
        new RegistrationPage(getDriver()).fillField(field, value);
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach(this::fillField);
    }

    @Step("выполнено нажатие на \'Зарегестрироваться\'")
    public void clickToRegistration(){
        new RegistrationPage(getDriver()).clickSubmit();
    }

    @Step("выполнен переход в эл. почту")
    public void gotoMail() {
        getDriver().get(TestProperties.getInstance().getProperties().getProperty("mail.url"));
    }

}
