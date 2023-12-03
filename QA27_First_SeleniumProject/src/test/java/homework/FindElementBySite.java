package homework;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindElementBySite {

  WebDriver driver;

  @BeforeMethod
  public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://demowebshop.tricentis.com/");
    // maximize browser to window with
    driver.manage().window().maximize();
    // wait for all elements on the site to load before starting the test
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @Test
  public void findElementByCssSelector() {
    // by id -> # id
    driver.findElement(By.cssSelector("#dialog-notifications-success"));
    driver.findElement(By.cssSelector("#dialog-notifications-error"));
    driver.findElement(By.cssSelector("#bar-notification"));

    // by class -> .class
    driver.findElement(By.cssSelector(".master-wrapper-page"));
    driver.findElement(By.cssSelector(".master-wrapper-content"));
    driver.findElement(By.cssSelector(".search-box"));
    driver.findElement(By.cssSelector(".header-links-wrapper"));

    // [attr = 'value']
    driver.findElement(By.cssSelector("[name='description']"));
    driver.findElement(By.cssSelector("[name='keywords']"));
    driver.findElement(By.cssSelector("[name='generator']"));


  }

  @Test
  public void findElementByXpath() {
    // -> //*[@attr = 'value']
    driver.findElement(By.xpath("//*[@name='description']"));
    driver.findElement(By.xpath("//*[@name='keywords']"));
    driver.findElement(By.xpath("//*[@name='generator']"));

    // by id -> //*[@id='value']
    driver.findElement(By.xpath("//*[@id='bar-notification']"));
    driver.findElement(By.xpath("//*[@id='dialog-notifications-error']"));
    // by class -> .//div[@class='value']
    driver.findElement(By.xpath(".//div[@class='master-wrapper-page']"));
    driver.findElement(By.xpath(".//div[@class='header-links-wrapper']"));

    //xpath by text
    driver.findElement(By.xpath("//label[contains(.,'Good')]"));
    driver.findElement(By.xpath("//label[text()='Excellent']"));
    driver.findElement(By.xpath("//label[text()='Poor']"));

  }

  @AfterMethod(enabled = true)
  public void tearDown() {
    driver.quit();

  }


}
