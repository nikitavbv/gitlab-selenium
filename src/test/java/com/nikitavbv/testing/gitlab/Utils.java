package com.nikitavbv.testing.gitlab;

public class Utils {

  public static final String GITLAB_HOST = "gitlab.nikitavbv.com";

  public static String path(String path) {
    return String.format("https://%s%s", GITLAB_HOST, path);
  }
}
