package com.sqs.allianztests.base;

import com.allianz.basepages.PageObjectBase;
import com.sqs.core.common.logging.Logger;
import com.sqs.core.common.logging.LoggerProvider;
import org.testng.ITestContext;
import org.testng.annotations.*;

/**
 * The Allianz base test.
 */
@Listeners( {com.allianz.common.TestListener.class})
public abstract class AllianzBaseTest {

  Logger logger = LoggerProvider.getLogger("AllianzBaseTest");

  @Parameters("browser")
  @BeforeTest
  protected void setupTest(@Optional("firefox") String browser, ITestContext context) {
  // DriverProvider.setBrowser(browser);
    //DriverProvider.initialise();
    //logger.startTestCase(context.getName());
  }

  /**
   * Tear down.
   *
   * @param context the context for the test case
   */
  @AfterTest
  protected void tearDownTest(ITestContext context) {

  }

  public <D extends PageObjectBase> D waitFor(Class<D> aclass) {
    D newPage = null;
    try {
      newPage = aclass.newInstance();
    } catch (Exception e) {
      logger.info(
          "Unable to navigate to page: '"
              + aclass.getSimpleName()
              + "' due to exception: "
              + e.toString());
    }
    return newPage;
  }
}
