package com.allianz.common;

import com.sqs.core.common.logging.Logger;
import com.sqs.core.common.logging.LoggerProvider;
import com.sqs.core.common.reporting.Reporter;
import com.sqs.core.common.reporting.ReporterProvider;
import com.sqs.web.utils.Screenshot;
import com.sqs.web.webdriver.DriverProvider;
import io.qameta.allure.Attachment;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListener implements ITestListener {
  private static final Logger logger = LoggerProvider.getLogger("TestListener");
  private static Reporter reporter = ReporterProvider.getReporter("extent");

  @Override
  public synchronized void onStart(ITestContext context) {
  }

  @Override
  public synchronized void onFinish(ITestContext context) {
  }

  @Override
  public synchronized void onTestStart(ITestResult result) {
    try {
      reporter.startTest(result.getMethod().getMethodName());
    } catch (InstantiationException e) {
      e.printStackTrace();
    }
    logger.info("In TestListener.onTestStart");

    //XML values are from TestNGExecuteTests.xml
    //Used when running maven test goal
    String browserName = result.getMethod().getXmlTest().getAllParameters().get("browser");
    // if browser is null due to not running from xml the default to chrome
    if (browserName == null) {
      browserName = "Firefox";
    }

    //Set webdriver version you need in XML or manually in code
    String webDriverVersion = result.getMethod().getXmlTest().getAllParameters().get("webDriverVersion");

    String grid = result.getMethod().getXmlTest().getAllParameters().get("grid");
    String platform = result.getMethod().getXmlTest().getAllParameters().get("platform");
    String browserstackToLocal = result.getMethod().getXmlTest().getAllParameters().get("browserstackToLocal");
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("--disable-gpu");
    WebDriver driver = new ChromeDriver(options);
    DriverProvider.setDriver(driver);
    DriverProvider.setBrowser(browserName);
    //set specific version of the web driver to download. Search online for compatible version for your browser
    //recommended for Chromedriver
    DriverProvider.setBrowserDriverVersion(webDriverVersion);
    DriverProvider.setBrowserStackToLocal(browserstackToLocal);
    DriverProvider.setGrid(grid);
    DriverProvider.setPlatform(platform);


    DriverProvider.setHeadless(true);

    DriverProvider.initialize();
  }

  @Override
  public synchronized void onTestSuccess(ITestResult result) {
    logger.info("In TestListener.onTestSuccess");
    DriverProvider.end();
    reporter.pass("Test passed");
    reporter.endTest();
  }

  @Override
  public synchronized void onTestFailure(ITestResult result) {
    logger.info("In TestListener.onTestFailure");
    reporter.attachScreenshot(Screenshot.takeScreenshot(result.getMethod().getMethodName(), DriverProvider.getDriverImpl()).toString());
    getAllureScreenshot();
    DriverProvider.end();
    reporter.fail("Test failed: " + result.getThrowable());
    reporter.endTest();
  }

  @Override
  public synchronized void onTestSkipped(ITestResult result) {
    logger.info("In TestListener.onTestSkipped");
    DriverProvider.end();
    reporter.skip("Skipping test: " + result.getThrowable());
    reporter.endTest();
  }

  @Override
  public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
  }

  @Attachment
  private byte[] getAllureScreenshot() {
    return Screenshot.getScreenshot(DriverProvider.getDriverImpl());
  }

  public Object[][] getPlatformsAndBrowsers() {
    Object[][] platformsAndBrowsers = new Object[][] {
            {Platform.WIN8, "firefox"},
            {Platform.WIN8, "chrome"},
            {Platform.MAC, "safari"}
    };
    return platformsAndBrowsers;
  }
}
