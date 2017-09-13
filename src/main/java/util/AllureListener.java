package util;

import org.testng.ITestResult;
import ru.yandex.qatools.allure.testng.AllureTestListener;
import steps.BaseSteps;

public class AllureListener extends AllureTestListener {
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        BaseSteps.takeScreenshot();
        super.onTestFailure(iTestResult);
    }
}
