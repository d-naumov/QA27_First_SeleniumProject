package com.testqa.tests;

import com.testqa.pages.AlertsPage;
import com.testqa.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

  @BeforeMethod
  public void precondition() {
    new HomePage(driver).getJavaScriptAlerts();

  }

  @Test
  public void acceptAlertTest() {
    new AlertsPage(driver).acceptAlert();

  }

}
