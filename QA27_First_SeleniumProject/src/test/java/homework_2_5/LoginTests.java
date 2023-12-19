package homework_2_5;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (!isLoginLinkPresent()) {
      clickOnSignOutButton();
    }
  }

  @Test
  public void loginPositiveTest() {
    //click on the Login link
    clickOnLoginLink();
    fillLoginRegisterForm("ssd@gm.com", "Ssdir123$");
    //click on the Login button
    clickOnLoginButton();
    // assert: Log out button is present
    Assert.assertTrue(isLogoutLinkPresent());

  }


}
