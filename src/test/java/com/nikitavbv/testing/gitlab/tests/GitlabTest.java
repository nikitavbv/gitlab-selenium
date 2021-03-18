package com.nikitavbv.testing.gitlab.tests;

import static com.nikitavbv.testing.gitlab.Utils.TEST_PROJECT;
import static com.nikitavbv.testing.gitlab.Utils.TEST_USERNAME;
import static com.nikitavbv.testing.gitlab.Utils.testPassword;
import static com.nikitavbv.testing.gitlab.Utils.testUsername;

import com.nikitavbv.testing.gitlab.pages.HomePage;
import com.nikitavbv.testing.gitlab.pages.ProjectPage;
import com.nikitavbv.testing.gitlab.pages.UserHomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GitlabTest {

  protected WebDriver driver;

  @BeforeEach
  public void setup() {
    driver = new ChromeDriver();
  }

  @AfterEach
  public void close() {
    driver.quit();
  }

  protected HomePage globalHomePage() {
    return new HomePage(driver).navigate();
  }

  protected UserHomePage authorized() {
    var homePage = globalHomePage();
    return homePage.login(testUsername(), testPassword());
  }

  protected ProjectPage testProject() {
    var home = authorized();
    var projectPage = new ProjectPage(driver);
    projectPage.navigate(TEST_USERNAME, TEST_PROJECT);
    return projectPage;
  }
}
