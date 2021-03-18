package com.nikitavbv.testing.gitlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewProjectPage {

  private final WebDriver driver;

  private final static By createBlankProjectBtnBy = By.xpath("//*[@id=\"content-body\"]/div[2]/div[2]/div[2]/a[1]/div[2]/h3");

  public NewProjectPage(WebDriver driver) {
    this.driver = driver;
  }

  public CreateBlankProjectPage createBlankProject() {
    driver.findElement(createBlankProjectBtnBy).click();
    return new CreateBlankProjectPage(driver);
  }
}
