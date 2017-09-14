package steps;

import pages.MailPage;
import ru.yandex.qatools.allure.annotations.Step;
import util.TestProperties;

import java.util.HashMap;

import static steps.BaseSteps.getDriver;

public class MailPageSteps {

    @Step("поле {0} заполняется значением {1}")
    private void fillField(String field, String value) {
        new MailPage(getDriver()).fillField(field,value);
    }

    @Step("заполняются поля")
    public void signInMail(HashMap<String, String> fields){
        fields.forEach(this::fillField);
        new MailPage(getDriver()).mailAuthBtn.click();
    }

    @Step("проверка актуальности письма")
    public void checkRelevanceOfLetter(){
        new MailPage(getDriver()).checkRelevance();
    }

    @Step("переходим на Ebay")
    public void gotoEbay() {
        new MailPage(getDriver()).mailMessage.click();
        getDriver().get(TestProperties.getInstance().getProperties().getProperty("app.url"));
    }
}
