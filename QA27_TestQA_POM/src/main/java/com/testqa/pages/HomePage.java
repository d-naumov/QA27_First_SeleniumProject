package com.testqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


  public HomePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//a[contains(text(),'JavaScript Alerts')]")
  WebElement javaScriptAlert;

  public AlertsPage getJavaScriptAlerts() {
    click(javaScriptAlert);
    return new AlertsPage(driver);
  }
}
//a.='JavaScript Alerts')
//a[contains(text(),'JavaScript Alerts')]