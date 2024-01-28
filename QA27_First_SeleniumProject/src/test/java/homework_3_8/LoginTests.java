package homework_3_8;

import com.seleniumProject.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }

  }

  @Test
  public void loginPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegisterForm(new User()
        .setMail("ssd@gm.com")
        .setPassword("Ssdir123$"));
    app.getUser().clickOnLoginButton();

    Assert.assertTrue(app.getUser().isLogoutLinkPresent());
  }

}
