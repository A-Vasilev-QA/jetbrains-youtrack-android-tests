package qa.avasilev.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NotificationsPage extends AbstractPage {

    private SelenideElement noNotificationsMessage = $(AppiumBy.xpath("//*[@resource-id=\"no-notifications\"]"));
    private SelenideElement loadingScreen = $(AppiumBy.id("refresh-control"));

    public boolean isOpened() {
        noNotificationsMessage.shouldBe(visible); //double check lets us prevent sleep usage
        return noNotificationsMessage.is(visible);
    }
}
