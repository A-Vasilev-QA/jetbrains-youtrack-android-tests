package qa.avasilev.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class WelcomePage {

    private SelenideElement serverUrlField = $(AppiumBy.id("test:id/server-url"));
    private SelenideElement nextButton = $(AppiumBy.id("test:id/next"));
    private SelenideElement noThanksButton = $(AppiumBy.id("com.android.chrome:id/negative_button"));
    private SelenideElement emailAddress = $(AppiumBy.id("com.android.chrome:id/account_text_secondary"));



    public void enterServerUrl(String serverUrl) {
        serverUrlField.shouldBe(visible).sendKeys(serverUrl);
        nextButton.shouldBe(enabled).click();
    }

    public void dealWithSync(String email) {
        emailAddress.shouldHave(text(email));
        noThanksButton.click();
    }


}