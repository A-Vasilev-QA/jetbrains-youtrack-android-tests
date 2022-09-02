package qa.avasilev.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SettingsPage extends AbstractPage {

    private final SelenideElement jetBrainsLink = $(AppiumBy.xpath("//*[@text=\"jetbrains.com/youtrack\"]"));

    public boolean isOpened() {
        jetBrainsLink.shouldBe(visible);
        return jetBrainsLink.is(visible);
    }

}
