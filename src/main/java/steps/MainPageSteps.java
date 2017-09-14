package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

import static steps.BaseSteps.getDriver;

public class MainPageSteps {

    @Step("выполнено нажатие на \'зарегистрируйтесь\'")
    public void goToRegistrationPage() {
        new MainPage(getDriver()).signUpBtn.click();
    }

    @Step("выполнено нажатие на \'Войдите\'")
    public void goToLoginPage() {
        new MainPage(getDriver()).signInBtn.click();
    }

    @Step("поиск товара blackberry")
    public void searchBlackberry() {
        new MainPage(getDriver()).searchItem();
    }

    @Step("проверенно количество отображаемого товара(50)")
    public void displayAmount() {
        new MainPage(getDriver()).checkDisplayQuantity();
    }

    @Step("выход из под своей учетной записи")
    public void signOut() {
        new MainPage(getDriver()).scrollAndSignOut();
    }

    @Step("успешный выход из учетной записи")
    public void checkSignOut() {
        new MainPage(getDriver()).successfulExit();
    }

}
