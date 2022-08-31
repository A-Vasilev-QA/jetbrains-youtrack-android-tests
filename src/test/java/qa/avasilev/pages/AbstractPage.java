package qa.avasilev.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public abstract class AbstractPage {

    private SelenideElement issuesMenuItem = $(AppiumBy.id("test:id/menuIssues"));
    private SelenideElement agileMenuItem = $(AppiumBy.id("test:id/menuAgile"));
    private SelenideElement notificationsMenuItem = $(AppiumBy.id("test:id/menuNotifications"));
    private SelenideElement knowledgeBaseMenuItem = $(AppiumBy.xpath("//*[@resource-id=\"menuKnowledgeBase\"]"));
    private SelenideElement settingsMenuItem = $(AppiumBy.id("test:id/menuSettings"));

    private void skipLoadingScreen() {
        $(AppiumBy.xpath("//*[@clickable=\"false\"]")).click();
    }

    public void openIssuesScreen() {
        issuesMenuItem.click();
        skipLoadingScreen();
    }

    public void openAgile() {
        agileMenuItem.click();
    }

    public void openNotifications() {
        notificationsMenuItem.click();
        skipLoadingScreen();
    }

    public void openKnowledgeBase() {
        knowledgeBaseMenuItem.click();
        skipLoadingScreen();
    }

    public void openSettings() {
        settingsMenuItem.click();
        skipLoadingScreen();
    }
}
