package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

import static steps.BaseSteps.getDriver;

public class MainPageSteps {

    @Step("выполнено нажатие на \'зарегистрируйтесь\'")
    public void goToRegistrationPage() {
        new MainPage(getDriver()).registrationBtn.click();
    }
}
