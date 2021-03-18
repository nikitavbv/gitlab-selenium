package com.nikitavbv.testing.gitlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHomePage {

  private final WebDriver driver;

  private static final By plusSignBy = By.id("js-onboarding-new-project-link");
  private static final By newProjectBy = By.className("qa-global-new-project-link");

  public UserHomePage(WebDriver driver) {
    this.driver = driver;
  }

  public NewProjectPage createRepository() {
    driver.findElement(plusSignBy).click();
    driver.findElement(newProjectBy).click();
    return new NewProjectPage(driver);
  }
}
