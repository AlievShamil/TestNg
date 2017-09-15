package steps;

import pages.MailPage;
import ru.yandex.qatools.allure.annotations.Step;
import util.TestProperties;

import java.util.HashMap;

import static steps.BaseSteps.getDriver;

public class MailPageSteps {

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value) {
        new MailPage(getDriver()).fillField(field,value);
    }

    @Step("заполняются поля")
    public void signInMail(HashMap<String, String> fields){
        fields.forEach(this::fillField);
        new MailPage(getDriver()).mailAuthBtn.click();
    }

    @Step("выполнено нажатие на Войти")
    public void clickIn(){
        new MailPage(getDriver()).mailAuthBtn.click();
    }

    @Step("проверка актуальности письма")
    public void checkRelevanceOfLetter(){
        new MailPage(getDriver()).checkRelevance();
    }

    @Step("выполнено открытие актуального письма")
    public void openLetter() {
//        new MailPage(getDriver()).verificationMail();
        new MailPage(getDriver()).openLetter();
        getDriver().get(TestProperties.getInstance().getProperties().getProperty("app.url"));
        getDriver().navigate().refresh();
    }
}
