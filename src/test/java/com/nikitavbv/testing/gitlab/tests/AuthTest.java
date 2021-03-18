package com.nikitavbv.testing.gitlab.tests;

import static com.nikitavbv.testing.gitlab.Utils.path;

import org.junit.jupiter.api.Test;

public class AuthTest extends GitlabTest {

  @Test
  public void test_signup() throws InterruptedException {
    driver.get(path("/"));
    Thread.sleep(10000);
  }
}
