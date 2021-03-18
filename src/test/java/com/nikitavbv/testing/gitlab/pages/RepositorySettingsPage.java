package com.nikitavbv.testing.gitlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RepositorySettingsPage {

  private final WebDriver driver;

  private final By branchSubMenuExpandBtnBy = By.xpath("//*[@id=\"default-branch-settings\"]/div[1]/button");
  private final By branchNameChosenBy = By.id("select2-chosen-1");

  public RepositorySettingsPage(WebDriver driver) {
    this.driver = driver;
  }

  public String checkDefaultBranchName() {
    driver.findElement(branchSubMenuExpandBtnBy).click();
    return driver.findElement(branchNameChosenBy).getText();
  }
}
