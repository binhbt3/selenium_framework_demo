package study.listeners;

import study.driver.DriverManager;
import study.helpers.CaptureHelpers;
import study.helpers.PropertiesHelpers;
import study.keywords.WebUI;
import study.report.AllureManager;
import study.report.ExtentReportManager;
import study.utils.EmailSendUtils;
import study.utils.LogUtils;
import com.aventstack.extentreports.Status;
import org.testng.*;

import static study.constants.FrameworkConstants.*;

public class TestListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    static int count_totalTCs;
    static int count_passedTCs;
    static int count_skippedTCs;
    static int count_failedTCs;

    public TestListener() {
    }

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // Before every method in the Test Class
        //System.out.println(method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // After every method in the Test Class
        //System.out.println(method.getTestMethod().getMethodName());
    }

    @Override
    public void onStart(ISuite iSuite) {
        System.out.println("========= INSTALLING CONFIGURATION DATA =========");
//        try {
//            FileUtils.deleteDirectory(new File("target/allure-results"));
//            System.out.println("Deleted Directory target/allure-results");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        PropertiesHelpers.loadAllFiles();
        AllureManager.setAllureEnvironmentInformation();
        ExtentReportManager.initReports();
        System.out.println("========= INSTALLED CONFIGURATION DATA =========");
        System.out.println("");
        LogUtils.info("========= Starting Suite: " + iSuite.getName() + " ========= ");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        LogUtils.info("========= End Suite: " + iSuite.getName() + " ========= ");
        LogUtils.info("===========================================================================================================");
        WebUI.stopSoftAssertAll();
        //End Suite and execute Extents Report
        ExtentReportManager.flushReports();
        //Zip Folder report
//        ZipUtils.zipReportFolder();
        //Send notification to Telegram
//        Send mail
        EmailSendUtils.sendEmail(count_totalTCs, count_passedTCs, count_failedTCs, count_skippedTCs);

        //Write information in Allure Report
        // AllureEnvironmentWriter.allureEnvironmentWriter(ImmutableMap.<String, String>builder().put("Test URL", FrameworkConstants.URL_CRM).put("Target Execution", FrameworkConstants.TARGET).put("Global Timeout", String.valueOf(FrameworkConstants.WAIT_DEFAULT)).put("Page Load Timeout", String.valueOf(FrameworkConstants.WAIT_PAGE_LOADED)).put("Headless Mode", FrameworkConstants.HEADLESS).put("Local Browser", String.valueOf(Browser.CHROME)).put("Remote URL", FrameworkConstants.REMOTE_URL).put("Remote Port", FrameworkConstants.REMOTE_PORT).put("TCs Total", String.valueOf(count_totalTCs)).put("TCs Passed", String.valueOf(count_passedTCs)).put("TCs Skipped", String.valueOf(count_skippedTCs)).put("TCs Failed", String.valueOf(count_failedTCs)).build());

        //FileHelpers.copyFile("src/test/resources/config/allure/environment.xml", "target/allure-results/environment.xml");
//        FileHelpers.copyFile("src/test/resources/config/allure/categories.json", "target/allure-results/categories.json");
//        FileHelpers.copyFile("src/test/resources/config/allure/executor.json", "target/allure-results/executor.json");

    }



    @Override
    public void onTestStart(ITestResult iTestResult) {
        LogUtils.info("===========================================================================================================");
        LogUtils.info("========= Test case: " + getTestDescription(iTestResult) + " is starting...========= ");
        count_totalTCs = count_totalTCs + 1;

        ExtentReportManager.createTest(iTestResult.getName());
//        ExtentReportManager.addAuthors(getAuthorType(iTestResult));
//        ExtentReportManager.addCategories(getCategoryType(iTestResult));
        ExtentReportManager.addDevices();

//        ExtentReportManager.info(BrowserInfoUtils.getOSInfo());

        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
            CaptureHelpers.startRecord(getTestName(iTestResult));
        }

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LogUtils.info("Test case: " + getTestDescription(iTestResult) + " is passed.");
        count_passedTCs = count_passedTCs + 1;

        if (SCREENSHOT_PASSED_STEPS.equals(YES)) {
            CaptureHelpers.captureScreenshot(DriverManager.getDriver(), getTestName(iTestResult));
        }

        AllureManager.saveTextLog("Test case: " + getTestName(iTestResult) + " is passed.");
        //ExtentReports log operation for passed tests.
        ExtentReportManager.logMessage(Status.PASS, "Test case: " + getTestName(iTestResult) + " is passed.");

        if (VIDEO_RECORD.trim().toLowerCase().equals(YES)) {
            CaptureHelpers.startRecord(getTestName(iTestResult));
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LogUtils.error("Test case: " + getTestDescription(iTestResult) + " is failed.");
        count_failedTCs = count_failedTCs + 1;

        if (SCREENSHOT_FAILED_STEPS.equals(YES)) {
            CaptureHelpers.captureScreenshot(DriverManager.getDriver(), getTestName(iTestResult));
        }

        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
            CaptureHelpers.stopRecord();
        }

        //Allure report screenshot file and log
        LogUtils.error("FAILED !! Screenshot for test case: " + getTestName(iTestResult));
        LogUtils.error(iTestResult.getThrowable());

        //Extent report screenshot file and log
        ExtentReportManager.addScreenShot(Status.FAIL, getTestName(iTestResult));
        ExtentReportManager.logMessage(Status.FAIL, iTestResult.getThrowable().toString());

        AllureManager.takeScreenshotToAttachOnAllureReport();
        AllureManager.saveTextLog(iTestResult.getThrowable().toString());

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LogUtils.warn("Test case: " + getTestDescription(iTestResult) + " is skipped.");
        count_skippedTCs = count_skippedTCs + 1;

        if (SCREENSHOT_SKIPPED_STEPS.equals(YES)) {
            CaptureHelpers.captureScreenshot(DriverManager.getDriver(), getTestName(iTestResult));
        }

        ExtentReportManager.logMessage(Status.SKIP, "Test case: " + getTestName(iTestResult) + " is skipped.");

        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
            CaptureHelpers.stopRecord();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LogUtils.error("Test failed but it is in defined success ratio: " + getTestDescription(iTestResult));
        ExtentReportManager.logMessage("Test failed but it is in defined success ratio: " + getTestDescription(iTestResult));
    }

}
