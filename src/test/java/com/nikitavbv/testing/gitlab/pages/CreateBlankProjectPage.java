package com.nikitavbv.testing.gitlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateBlankProjectPage {

  private final WebDriver driver;

  private final static By projectNameBy = By.name("project[name]");
  private final static By projectSlugBy = By.name("project[path]");
  private final static By createProjectButtonBy = By.name("commit");

  public CreateBlankProjectPage(WebDriver driver) {
    this.driver = driver;
  }

  public void fillProjectName(String projectName) {
    driver.findElement(projectNameBy).sendKeys(projectName);
  }

  public ProjectPage createProject() {
    driver.findElement(createProjectButtonBy).click();
    return new ProjectPage(driver);
  }

  public String getProjectSlug() {
    return driver.findElement(projectSlugBy).getAttribute("value");
  }
}
