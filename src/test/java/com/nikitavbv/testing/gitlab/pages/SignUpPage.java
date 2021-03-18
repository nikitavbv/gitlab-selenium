package com.nikitavbv.testing.gitlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

  private final WebDriver driver;

  private static final By firstNameBy = By.name("new_user[first_name]");
  private static final By lastNameBy = By.name("new_user[last_name]");
  private static final By usernameBy = By.name("new_user[username]");
  private static final By emailBy = By.name("new_user[email]");
  private static final By passwordBy = By.name("new_user[password]");
  private static final By registerButtonBy = By.xpath("//*[@id=\"new_new_user\"]/div[7]/input");

  public SignUpPage(WebDriver driver) {
    this.driver = driver;
  }

  public HomePage register(String firstName, String lastName, String username, String email, String password) {
    driver.findElement(firstNameBy).sendKeys(firstName);
    driver.findElement(lastNameBy).sendKeys(lastName);
    driver.findElement(usernameBy).sendKeys(username);
    driver.findElement(emailBy).sendKeys(email);
    driver.findElement(passwordBy).sendKeys(password);
    driver.findElement(registerButtonBy).click();
    return new HomePage(driver);
  }
}