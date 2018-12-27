package listeners;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Attachment;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestListener implements IInvokedMethodListener, ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        int TEST_STATUS = testResult.getStatus();
        String subName = testResult.getTestClass().getName() + ".";
        String name = subName + testResult.getName();
        String sessID = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();

        if (!testResult.isSuccess()) {
            try {

                makeScreenshotOnFailure(name);
            } catch (Exception e) {
                System.out.println("Failed to execute the afterInvocation method. Message: " + e.getMessage()
                        + "; Stack trace: \n");
                e.printStackTrace();
            }
        }
        if (method.isTestMethod()) {
            System.out.println("Test " + name + " (session id: " + sessID
                    + ") was finished with status " + TEST_STATUSES.values()[TEST_STATUS - 1].name()
                    + " in " + (testResult.getEndMillis() - testResult.getStartMillis()) / 1000 + " seconds");
        }
    }

    @Attachment(value = "{0}", type = "image/png")
    private byte[] makeScreenshotOnFailure(String name) throws IOException {
        File lastSelenideScreenshot = Screenshots.takeScreenShotAsFile();
        return com.google.common.io.Files.toByteArray(lastSelenideScreenshot);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    private enum TEST_STATUSES {
        /**
         * Tests statuses
         */
        PASSED, FAILED, SKIPPED
    }

}