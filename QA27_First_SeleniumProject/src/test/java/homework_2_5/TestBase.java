package homework_2_5;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

  WebDriver driver;

  @BeforeMethod
  public void setup() {
    driver = new ChromeDriver();
    driver.get("https://demowebshop.tricentis.com/");

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod(enabled = false)
  public void tearDown() {
    driver.quit();
  }


  public boolean isElementPresent(By locator) {
    return driver.findElements(locator).size() > 0;
  }

  public void pause(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public boolean isProductByCart(String text) {
    List<WebElement> product = driver.findElements(By.xpath("//span[contains(text(),'(3)')]"));
    for (WebElement element : product) {
      if (element.getText().contains(text)) {
        return true;
      }
    }
    return false;
  }

  // public void clickOnSignOutButton() {
  //   driver.findElement(By.cssSelector("[href='/logout']")).click();
  //}

  public boolean isLoginLinkPresent() {
    return isElementPresent(By.cssSelector("[href='/login']"));
  }

  public boolean isAlertAppears() {
    Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
        .until(ExpectedConditions.alertIsPresent());
    if (alert == null) {
      return false;
    } else {
      return true;
    }

  }

  public void type(By locator, String text) {
    click(locator);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public void clickOnSignOutButton() {
    click(By.cssSelector("[href='/logout']"));
  }

  public void clickOnContinueButton() {
    click(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[2]/input[1]"));
  }

  public void clickOnConfirmPassword(String password) {
    type(By.name("ConfirmPassword"), password);
  }

  public void clickOnRegisterButton() {
    click(By.name("register-button"));
  }

  public void fillLoginRegisterForm(String email, String password) {
    type(By.name("Email"), email);
    //enter password
    type(By.name("Password"), password);
  }

  public void clickOnLoginLink() {
    click(By.cssSelector("[href='/login']"));
  }

  public void fillLastNameOnRegisterForm(String text) {
    type(By.name("LastName"), text);
  }

  public void fillFirstNameOnRegisterForm(String text) {
    type(By.name("FirstName"), text);
  }

  public void fillGenderOnRegisterForm() {
    click(By.cssSelector("#gender-male"));
  }

  public void clickOnRegisterLink() {
    click(
        By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/input[1]"));
  }

  public void clickOnLoginButton() {
    click(By.cssSelector(".buttons:nth-child(5)"));
  }

  public boolean isSingOutButtonPresent() {
    return isElementPresent(By.cssSelector("[href='/logout']"));
  }

  public void clickOnSelectProductParametr() {
    click(By.xpath("//input[@id='product_attribute_16_3_6_19']"));
  }

  public void clickOnProduct(String ProductName) {
    click(By.xpath(ProductName));
  }

  public void clickOnAddToCartButton2() {
    clickOnProduct("//input[@id='add-to-cart-button-16']");
  }

  public void clickOnAddToCartButton1() {
    clickOnProduct("//input[@id='add-to-cart-button-72']");
  }

  public void clickOnAddToCartButton() {
    clickOnProduct("//input[@id='add-to-cart-button-31']");
  }

  public void clickOnHomeLink() {
    clickOnProduct("//span[contains(text(),'Home')]");
  }

  public void clickOnShoppingCart() {
    clickOnProduct("//span[contains(text(),'Shopping cart')]");
  }
}
