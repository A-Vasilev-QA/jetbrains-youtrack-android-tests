package qa.avasilev.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.InvalidSelectorException;

import static com.codeborne.selenide.Selenide.$;

public abstract class AbstractPage {

    private final SelenideElement issuesMenuItem = $(AppiumBy.id("test:id/menuIssues"));
    private final SelenideElement agileMenuItem = $(AppiumBy.id("test:id/menuAgile"));
    private final SelenideElement notificationsMenuItem = $(AppiumBy.id("test:id/menuNotifications"));
    private final SelenideElement knowledgeBaseMenuItem = $(AppiumBy.xpath("//*[@resource-id=\"menuKnowledgeBase\"]"));
    private final SelenideElement settingsMenuItem = $(AppiumBy.id("test:id/menuSettings"));

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
        knowledgeBaseMenuItem.click();
    }

    public void openSettings() {
        settingsMenuItem.click();
    }

    public void scrollForward() {
        try {
            WebDriverRunner.getWebDriver().findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
        } catch (InvalidSelectorException e) {
            // ignore
        }
    }
}
