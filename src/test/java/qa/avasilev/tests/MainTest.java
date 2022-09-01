package qa.avasilev.tests;

import org.junit.jupiter.api.Test;
import qa.avasilev.pages.*;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends TestBase {

    @Test
    void loginTest() {
        login();
        IssuesPage issuesPage = new IssuesPage();

        step("Verify that issue page is opened", () -> {
            assertTrue(issuesPage.isOpened());
        });
    }

    @Test
    void countRowsTest() {
        login();
        IssuesPage issuesPage = new IssuesPage();

        step("Verify that issue page is opened", () -> {
            assertTrue(issuesPage.isOpened());
        });

        step("Verify that issues number in header and actual number of issues are correct", () -> {
            assertTrue(issuesPage.countedIssuesAreCorrect());
        });
    }

    @Test
    void checkScreensTest() {
        login();
        IssuesPage issuesPage = new IssuesPage();

        step("Verify that issue page is opened", () -> {
            assertTrue(issuesPage.isOpened());
        });

        step("Open Agile Page", issuesPage::openAgile);

        AgilePage agilePage = new AgilePage();

        step("Verify that Agile page is opened", () -> {
            assertTrue(agilePage.isOpened());
        });

        step("Open Agile Page", agilePage::openNotifications);

        NotificationsPage notificationsPage = new NotificationsPage();

        step("Verify that notification page is opened", () -> {
            assertTrue(notificationsPage.isOpened());
        });

        step("Open Knowledge Base Page", notificationsPage::openKnowledgeBase);

        KnowledgeBasePage knowledgeBasePage = new KnowledgeBasePage();

        step("Verify that Knowledge Base page is opened", () -> {
            assertTrue(knowledgeBasePage.isOpened());
        });

        step("Open Knowledge Base Page", knowledgeBasePage::openSettings);

        SettingsPage settingsPage = new SettingsPage();

        step("Verify that Settings page is opened", () -> {
            assertTrue(settingsPage.isOpened());
        });
    }

    @Test
    void checkFirstIssueTest() {

        login();
        IssuesPage issuesPage = new IssuesPage();

        step("Verify that issue page is opened", () -> {
            assertTrue(issuesPage.isOpened());
        });

        step("Compare agile issue ID and header of issue page - verify they're equal", () -> {
            assertEquals(issuesPage.getIssueIdByNumber(0), issuesPage.checkIssuePageHeaderByNumber(0));
        });
    }

    @Test
    void checkFirstAgileCardTest() {
        login();
        IssuesPage issuesPage = new IssuesPage();

        step("Verify that issue page is opened", () -> {
            assertTrue(issuesPage.isOpened());
        });

        step("Open Agile Page", issuesPage::openAgile);

        AgilePage agilePage = new AgilePage();

        step("Verify that issue page is opened", () -> {
            assertTrue(agilePage.isOpened());
        });

        step("Compare agile card header and header of issue page - verify they're equal", () -> {
            assertEquals(agilePage.getFirstCardId(), agilePage.checkFirstIssuePageHeader());
        });
    }
}
