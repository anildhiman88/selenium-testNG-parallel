package listeners;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporting.ReportManager;
import utils.ScreenshotUtils;

public class ExtentTestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        // Suite start
        ReportManager.initReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        // Suite end
        ReportManager.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ReportManager.createTest(testName);
        ReportManager.getTest().log(Status.INFO, "Starting test: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportManager.getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ReportManager.getTest().log(Status.FAIL, "Test failed: " + result.getThrowable());

        String screenshotPath = ScreenshotUtils.takeScreenshot(testName);
        if (screenshotPath != null) {
            try {
                ReportManager.getTest().addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReportManager.getTest().log(Status.SKIP, "Test skipped");
    }
}
