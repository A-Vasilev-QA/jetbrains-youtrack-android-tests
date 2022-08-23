package qa.avasilev.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class WelcomePage extends AbstractPage{

    private SelenideElement serverUrlField = $(AppiumBy.id("test:id/server-url"));
    private SelenideElement nextButton = $(AppiumBy.id("test:id/next"));

    public void enterServerUrl(String serverUrl) {
        serverUrlField.shouldBe(visible).sendKeys(serverUrl);
        nextButton.shouldBe(enabled).click();
    }

}
