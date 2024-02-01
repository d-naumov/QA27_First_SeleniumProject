package com.seleniumProject.models;

public class NewUser {

  private String name;
  private String lastname;
  private String mail;
  private String password;


  public NewUser setName(String name) {
    this.name = name;
    return this;
  }

  public NewUser setLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public NewUser setMail(String mail) {
    this.mail = mail;
    return this;
  }


  public NewUser setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname;
  }

  public String getMail() {
    return mail;
  }

  public String getPassword() {
    return password;
  }
}
