package com.nikitavbv.testing.gitlab;

public class Utils {

  public static final String GITLAB_HOST = "gitlab.nikitavbv.com";
  public static final String TEST_USERNAME = "test";
  public static final String TEST_PASSWORD = "";
  public static final String TEST_PROJECT = "test_project";

  public static String path(String path) {
    return String.format("https://%s%s", GITLAB_HOST, path);
  }

  public static String testUsername() {
    return TEST_USERNAME;
  }

  public static String testPassword() {
    return TEST_PASSWORD;
  }
}
