package com.seleniumProject.fm;

import com.seleniumProject.models.NewUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addNewUserHelper extends BaseHelper {

  public addNewUserHelper(WebDriver driver) {

    super(driver);
  }

  public void fillLoginRegisterForm1(NewUser user) {
    click(By.cssSelector("#gender-male"));
    type(By.name("FirstName"), user.getName());
    type(By.name("LastName"), user.getLastname());
    type(By.name("Email"), user.getMail());
    type(By.name("Password"), user.getPassword());
    type(By.name("ConfirmPassword"), user.getPassword());
  }
}