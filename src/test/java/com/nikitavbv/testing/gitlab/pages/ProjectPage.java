package com.nikitavbv.testing.gitlab.pages;

import static com.nikitavbv.testing.gitlab.Utils.path;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ProjectPage {

  private final WebDriver driver;

  private final By projectNameBy = By.className("home-panel-title");
  private final By settingsBy = By.linkText("Settings");
  private final By repositorySettingsBy = By.xpath("/html/body/div[3]/aside/div/ul/li[12]/ul/li[7]/a");
  private final By readmeFileBy = By.xpath("//*[@id=\"tree-holder\"]/div[4]/div/div/table/tbody/tr/td[1]/a/span[2]");

  public ProjectPage(WebDriver driver) {
    this.driver = driver;
  }

  public void navigate(String group, String projectId) {
    driver.get(path(String.format("/%s/%s", group, projectId)));
  }

  public RepositorySettingsPage openSettings() {
    var actions = new Actions(driver);
    actions.moveToElement(driver.findElement(settingsBy)).perform();
    driver.findElement(repositorySettingsBy).click();
    return new RepositorySettingsPage(driver);
  }

  public ProjectFilePage openReadmeFile() {
    driver.findElement(readmeFileBy).click();
    return new ProjectFilePage(driver);
  }

  public String projectName() {
    return driver.findElement(projectNameBy).getText();
  }
}
