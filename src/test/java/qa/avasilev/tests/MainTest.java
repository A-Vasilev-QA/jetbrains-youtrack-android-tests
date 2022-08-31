package qa.avasilev.tests;

import org.junit.jupiter.api.Test;
import qa.avasilev.pages.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest extends TestBase {

    @Test
    void loginTest() {

        login();

        IssuesPage issuesPage = new IssuesPage();
        assertTrue(issuesPage.isOpened());
    }

    @Test
    void countRowsTest() {

        login();

        IssuesPage issuesPage = new IssuesPage();
        assertTrue(issuesPage.isOpened());
        assertTrue(issuesPage.countedIssuesAreCorrect());
    }

    @Test
    void checkScreensTest() {

        login();

        IssuesPage issuesPage = new IssuesPage();
        assertTrue(issuesPage.isOpened());
        issuesPage.openAgile();

        AgilePage agilePage = new AgilePage();
        assertTrue(agilePage.isOpened());
        agilePage.openNotifications();

        NotificationsPage notificationsPage = new NotificationsPage();
        assertTrue(notificationsPage.isOpened());
        notificationsPage.openKnowledgeBase();

        KnowledgeBasePage knowledgeBasePage = new KnowledgeBasePage();
        assertTrue(knowledgeBasePage.isOpened());
        knowledgeBasePage.openSettings();

        SettingsPage settingsPage = new SettingsPage();
        assertTrue(settingsPage.isOpened());
    }

    @Test
    void checkFirstIssueTest() throws Exception {
        login();
        IssuesPage issuesPage = new IssuesPage();
        assertTrue(issuesPage.isOpened());
        assertEquals(issuesPage.issueIdByNumber(0), issuesPage.checkIssuePageHeaderByNumber(0));
    }
}
