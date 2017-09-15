package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class ScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    LoginPageSteps loginPageSteps = new LoginPageSteps();
    MailPageSteps mailPageSteps = new MailPageSteps();
    RegistrationPageSteps regPageSteps = new RegistrationPageSteps();

    @When("^выполненно нажатие на Зарегистрируйтесь")
    public void clickRegistration() {
        mainPageSteps.goToRegistrationPage();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> regPageSteps.fillField(field, value));
    }
}
