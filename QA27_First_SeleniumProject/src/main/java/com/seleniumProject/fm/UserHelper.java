package com.seleniumProject.fm;

import com.seleniumProject.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

  public UserHelper(WebDriver driver) {
    super(driver);
  }

  public boolean isLoginLinkPresent() {
    return isElementPresent(By.cssSelector("[href='/login']"));
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

  public void fillLoginRegisterForm(User user) {
    type(By.name("Email"), user.getMail());
    //enter password
    type(By.name("Password"), user.getPassword());
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

  public boolean isLogoutLinkPresent() {
    return isElementPresent(By.cssSelector("[href='/logout']"));
  }

}
