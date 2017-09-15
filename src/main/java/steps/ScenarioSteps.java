package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;

public class ScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    LoginPageSteps loginPageSteps = new LoginPageSteps();
    MailPageSteps mailPageSteps = new MailPageSteps();
    RegistrationPageSteps regPageSteps = new RegistrationPageSteps();

    @When("^выполненно нажатие на \"Зарегистрируйтесь\"")
    public void clickRegisterNow() {
        mainPageSteps.goToRegistrationPage();
    }

    @And("^заполняются поля:$")
    public void fillForm(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> regPageSteps.fillField(field, value));
    }
    @Then("^выполнено нажатие на \"Зарегестрироваться\"")
    public void clickToRegister() {
        regPageSteps.clickToRegistration();
    }

    @When("^выполнен переход на почтовый ящик$")
    public void gotoEmail(DataTable fields) {
        regPageSteps.gotoMail();
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> mailPageSteps.fillField(field, value));
        mailPageSteps.clickIn();
    }

    @Then("^выполнена проверка актуальности письма")
    public void checkRelevanceOfLetter() {
        mailPageSteps.checkRelevanceOfLetter();
    }

    @And("^выполнен переход из письма на eBay")
    public void gotoEbay() {
        mailPageSteps.openLetter();
    }

    @When("^выполнен вход в личный кабинет$")
    public void logIn(DataTable fields) {
        mainPageSteps.clickLogin();
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> loginPageSteps.fillField(field, value));
        loginPageSteps.clickSigIn();

    }

    @When("^выполнен поиск по товарам blackberry")
    public void searchProduct() {
        mainPageSteps.searchBlackberry();
    }

    @When("^выполнена проверка отображения товаров на странице")
    public void checkDisplayAmount() {
        mainPageSteps.displayAmount();
    }
    @When("^выполнен выход из под своей учетной записи")
    public void signOut() {
        mainPageSteps.signOut();
    }

    @When("^выполнена проверка выход из под своей учетной записи")
    public void checkSignOut() {
        mainPageSteps.checkSignOut();
    }
}
