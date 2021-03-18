package com.nikitavbv.testing.gitlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectFilePage {

  private final WebDriver driver;

  private final By editBtnBy = By.cssSelector(".js-edit-blob");
  private final By fileSizeBy = By.cssSelector(".mr-1");

  public ProjectFilePage(WebDriver driver) {
    this.driver = driver;
  }

  public EditorPage editFile() {
    driver.findElement(editBtnBy).click();
    return new EditorPage(driver);
  }

  public String fileSize() {
    return driver.findElement(fileSizeBy).getText();
  }
}
