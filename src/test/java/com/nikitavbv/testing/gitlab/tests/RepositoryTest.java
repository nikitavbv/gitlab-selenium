package com.nikitavbv.testing.gitlab.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RepositoryTest extends GitlabTest {

  @Test
  public void test_create_repository() {
    String projectName = RandomStringUtils.randomAlphabetic(10);

    var userHome = authorized();
    var createRepositoryPage = userHome.createRepository();

    var createBlankProjectPage = createRepositoryPage.createBlankProject();
    createBlankProjectPage.fillProjectName(projectName);

    assertEquals(projectName.toLowerCase(), createBlankProjectPage.getProjectSlug());

    var projectPage = createBlankProjectPage.createProject();

    assertEquals(projectName, projectPage.projectName());
  }

  @Test
  public void test_default_branch() {
    var project = testProject();
    var settingsPage = project.openSettings();

    assertEquals("main", settingsPage.checkDefaultBranchName());
  }

  @Test
  public void test_edit_file() throws InterruptedException {
    var project = testProject();

    var filePage = project.openReadmeFile();
    String fileSize = filePage.fileSize();

    var editorPage = filePage.editFile();

    editorPage.addTable();
    filePage = editorPage.commitChanges();

    assertNotEquals(fileSize, filePage.fileSize());
  }
}
