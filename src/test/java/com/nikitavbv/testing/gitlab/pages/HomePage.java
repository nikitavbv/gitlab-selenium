package com.nikitavbv.testing.gitlab.pages;

import static com.nikitavbv.testing.gitlab.Utils.path;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

  private final WebDriver driver;

  private static final By registerNowBy = By.xpath("//*[@id=\"signin-container\"]/p/a");
  private static final By flashNoticeBy = By.className("flash-notice");
  private static final By usernameBy = By.id("user_login");
  private static final By passwordBy = By.id("user_password");
  private static final By signInButtonBy = By.name("commit");
  private static final By errorMessageBy = By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/span");

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public HomePage navigate() {
    driver.get(path("/"));
    return this;
  }

  public SignUpPage initiateAccountCreation() {
    driver.findElement(registerNowBy).click();
    return new SignUpPage(driver);
  }

  public UserHomePage login(String username, String password) {
    driver.findElement(usernameBy).sendKeys(username);
    driver.findElement(passwordBy).sendKeys(password);
    driver.findElement(signInButtonBy).click();
    return new UserHomePage(driver);
  }

  public String flashNoticeText() {
    return driver.findElement(flashNoticeBy).getText();
  }

  public String errorMessageText() {
    return driver.findElement(errorMessageBy).getText();
  }
}
