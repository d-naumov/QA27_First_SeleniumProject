package homework_3_8;

import com.seleniumProject.fm.ApplicationManager;
import java.lang.reflect.Method;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
      Browser.CHROME.browserName()));

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  @AfterMethod(enabled = false)
  public void startTest(Method method) {
    logger.info("Start test" + method.getName());
  }

  @AfterMethod
  public void stopTest(ITestResult result) {
    if (result.isSuccess()) {
      logger.info("PASSED: " + result.getMethod().getMethodName());
    } else {
      logger.error("FAILED: " + result.getMethod().getMethodName());
    }
    logger.info("Stop test");
    logger.info("**************************************************");
  }

  @BeforeSuite
  public void setup() {
    app.init();
  }

  @AfterSuite(enabled = true)
  public void tearDown() {
    app.stop();
  }


}
