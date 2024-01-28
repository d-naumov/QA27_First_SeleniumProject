package com.seleniumProject.fm;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {

  String browser;
  WebDriver driver;
  UserHelper user;
  addNewUserHelper cartHelper;
  HomePageHelper homepage;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if (browser.equalsIgnoreCase("chrome")) {
      driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase("firefox")) {
      driver = new FirefoxDriver();
    } else if (browser.equalsIgnoreCase("edge")) {
      driver = new EdgeDriver();
    }

    driver.get("https://demowebshop.tricentis.com/");

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    user = new UserHelper(driver);
    cartHelper = new addNewUserHelper(driver);
    homepage = new HomePageHelper(driver);
  }

  public UserHelper getUser() {
    return user;
  }

  public addNewUserHelper getContact() {
    return cartHelper;
  }

  public HomePageHelper getHomepage() {
    return homepage;
  }

  public void stop() {
    driver.quit();
  }

}
