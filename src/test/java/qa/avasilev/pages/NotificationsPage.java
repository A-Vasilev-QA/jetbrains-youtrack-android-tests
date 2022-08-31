package qa.avasilev.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NotificationsPage extends AbstractPage {

    private SelenideElement noNotificationsMessage = $(AppiumBy.xpath("//*[@resource-id=\"no-notifications\"]"));

    public boolean isOpened() {
        noNotificationsMessage.shouldBe(visible);
        return noNotificationsMessage.is(visible);
    }
}
