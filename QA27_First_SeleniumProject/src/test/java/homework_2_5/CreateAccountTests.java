package homework_2_5;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

  //precondition : user should be log out
  // if login link not present
  //click Log out link

  // click on the Register link
  // click on the gender male
  //enter First name
  //enter Last name
  //enter email
  //enter password
  //enter Confirm password
  //click on the Registration button
  // click on the Continue button
  // assert: Log out button is present

  @BeforeMethod
  public void ensurePrecondition() {
    if (!isLoginLinkPresent()) {
      clickOnSignOutButton();
    }
  }

  @Test
  public void registerNewUserPositiveTest() {

    clickOnLoginLink();
    clickOnRegisterLink();

    fillGenderOnRegisterForm();

    fillFirstNameOnRegisterForm("edi");

    fillLastNameOnRegisterForm("edi");

    fillLoginRegisterForm("ssd@gm.com", "Ssdir123$");
    clickOnConfirmPassword("Ssdir123$");

    clickOnRegisterButton();
    clickOnContinueButton();

    // assert: Log out button is present
    Assert.assertTrue(isLogoutLinkPresent());

  }


}
