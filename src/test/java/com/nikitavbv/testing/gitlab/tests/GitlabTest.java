package com.nikitavbv.testing.gitlab.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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
}
