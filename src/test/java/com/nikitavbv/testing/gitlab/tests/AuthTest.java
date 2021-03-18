package com.nikitavbv.testing.gitlab.tests;

import static com.nikitavbv.testing.gitlab.Utils.TEST_USERNAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

public class AuthTest extends GitlabTest {

  @Test
  public void test_signup() {
    String firstName = RandomStringUtils.randomAlphabetic(10);
    String lastName = RandomStringUtils.randomAlphabetic(10);
    String username = RandomStringUtils.randomAlphabetic(10);
    String email = RandomStringUtils.randomAlphabetic(10) + "@example.com";
    String password = RandomStringUtils.randomAlphanumeric(10);

    var homePage = globalHomePage();

    var signUpPage = homePage.initiateAccountCreation();
    homePage = signUpPage.register(firstName, lastName, username, email, password);

    assertTrue(homePage.flashNoticeText().contains("You have signed up successfully. However, we could not sign you in because your account is awaiting approval from your GitLab administrator."));
  }

  @Test
  public void test_invalid_password() {
    var homePage = globalHomePage();
    homePage.login(TEST_USERNAME, "invalid_password");

    assertEquals("Invalid Login or password.", homePage.errorMessageText());
  }
}
