package qa.avasilev.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.interactions.touch.TouchActions;

import static com.codeborne.selenide.Selenide.$;

public abstract class AbstractPage {
    TouchActions touchAction = new TouchActions(WebDriverRunner.getWebDriver());

    private SelenideElement issuesMenuItem = $(AppiumBy.id("test:id/menuIssues"));
    private SelenideElement agileMenuItem = $(AppiumBy.id("test:id/menuAgile"));
    private SelenideElement notificationsMenuItem = $(AppiumBy.id("test:id/menuAgile"));
    private SelenideElement knowledgeBaseMenuItem = $(AppiumBy.id("test:id/menuAgile"));
    private SelenideElement settingsMenuItem = $(AppiumBy.id("test:id/menuAgile"));

    public void openIssuesScreen() {
        issuesMenuItem.click();
    }

    public void openAgile() {
        agileMenuItem.click();
    }

    public void openNotifications() {
        notificationsMenuItem.click();
    }

    public void openKnowledgeBase() {

    }

    public void openSettings() {

    }
}
