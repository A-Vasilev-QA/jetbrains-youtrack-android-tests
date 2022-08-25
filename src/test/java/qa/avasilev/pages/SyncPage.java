package qa.avasilev.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SyncPage {

    private SelenideElement noThanksButton = $(AppiumBy.id("com.android.chrome:id/negative_button"));
    private SelenideElement emailAddress = $(AppiumBy.id("com.android.chrome:id/account_text_secondary"));

    public void dealWithSync(String email) {
        emailAddress.shouldHave(text(email));
        noThanksButton.click();
    }
}
