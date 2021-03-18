package com.nikitavbv.testing.gitlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorPage {

  private final WebDriver driver;

  private final static By addTableBtnBy = By.xpath("//*[@id=\"content-body\"]/div[2]/form/div[1]/div[1]/div[3]/div/button[9]");
  private final static By commitChangesBtnBy = By.id("commit-changes");

  public EditorPage(WebDriver driver) {
    this.driver = driver;
  }

  public void addTable() {
    driver.findElement(addTableBtnBy).click();
  }

  public ProjectFilePage commitChanges() {
    driver.findElement(commitChangesBtnBy).click();
    return new ProjectFilePage(driver);
  }
}
