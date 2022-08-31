package qa.avasilev.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement usernameField = $(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]"));
    private SelenideElement passwordField = $(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]"));
    private SelenideElement rememberMeCheckbox = $(AppiumBy.className("android.widget.CheckBox"));
    private SelenideElement enterButton = $(AppiumBy.className("android.widget.Button"));


    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        rememberMeCheckbox.click();
        enterButton.click();
    }


}
