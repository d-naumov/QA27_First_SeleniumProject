package homework_2_5;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class addToCartTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (!isLoginLinkPresent()) {
      clickOnSignOutButton();
    }
    clickOnLoginLink();
    fillLoginRegisterForm("ssd@gm.com", "Ssdir123$");
    clickOnLoginButton();
  }

  @Test
  public void addProductsToCartPositiveTest() {
    clickOnProduct("//a[contains(text(),'14.1-inch Laptop')]");
    clickOnAddToCartButton();

    clickOnHomeLink();

    clickOnProduct("//a[contains(text(),'Build your own cheap computer')]");

    clickOnAddToCartButton1();

    clickOnHomeLink();

    clickOnProduct("//a[contains(text(),'Build your own computer')]");

    // click on the select HDD
    clickOnSelectProductParametr();

    clickOnAddToCartButton2();
    pause(1000);

    clickOnShoppingCart();

    // Assert.assertTrue(isProductByCart("3"));
    Assert.assertTrue(isProductInCart("14.1-inch Laptop"));
    Assert.assertTrue(isProductInCart("Build your own cheap computer"));
    Assert.assertTrue(isProductInCart("Build your own computer"));
  }


}
