package homework_2;

import org.openqa.selenium.By;
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
    if (!isElementPresent(By.cssSelector("[href='/login']"))) {
      driver.findElement(By.cssSelector("[href='/logout']")).click();
    }

  }

  @Test
  public void registerNewUserPositiveTest() {
    //click on the Login link
    driver.findElement(By.cssSelector("[href='/login']")).click();

    // click on the Register link
    driver.findElement(
            By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/input[1]"))
        .click();

    // click on the gender male
    driver.findElement(By.cssSelector("#gender-male")).click();

    //enter First name
    //  -> By.name
    driver.findElement(By.name("FirstName")).click();
    driver.findElement(By.name("FirstName")).clear();
    driver.findElement(By.name("FirstName")).sendKeys("edi");

    //enter Last name
    //  -> By.name
    driver.findElement(By.name("LastName")).click();
    driver.findElement(By.name("LastName")).clear();
    driver.findElement(By.name("LastName")).sendKeys("edi");

    //enter email
    //email -> By.name
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).clear();
    driver.findElement(By.name("Email")).sendKeys("ssd@gm.com");
    //enter password
    driver.findElement(By.name("Password")).click();
    driver.findElement(By.name("Password")).clear();
    driver.findElement(By.name("Password")).sendKeys("Ssdir123$");

    //enter Confirm password
    driver.findElement(By.name("ConfirmPassword")).click();
    driver.findElement(By.name("ConfirmPassword")).clear();
    driver.findElement(By.name("ConfirmPassword")).sendKeys("Ssdir123$");

    //click on the Register button
    driver.findElement(By.name("register-button")).click();

    // click on the Continue button
    driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[2]/input[1]"))
        .click();

    // assert: Log out button is present
    Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));

  }

}
