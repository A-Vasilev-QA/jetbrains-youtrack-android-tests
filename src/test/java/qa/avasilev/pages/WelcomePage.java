package qa.avasilev.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WelcomePage {

    private final SelenideElement serverUrlField = $(AppiumBy.id("test:id/server-url"));
    private final SelenideElement nextButton = $(AppiumBy.id("test:id/next"));

    public void enterServerUrl(String serverUrl) {
        serverUrlField.shouldBe(visible).sendKeys(serverUrl);
        nextButton.shouldBe(enabled).click();
    }


}
