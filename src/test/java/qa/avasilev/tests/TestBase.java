package qa.avasilev.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import qa.avasilev.config.Project;
import qa.avasilev.drivers.BrowserstackMobileDriver;
import qa.avasilev.drivers.LocalMobileDriver;
import qa.avasilev.helpers.Attach;
import qa.avasilev.pages.LoginPage;
import qa.avasilev.pages.WelcomePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;
import static qa.avasilev.helpers.Attach.sessionId;


public class TestBase {

    private static boolean videoEnabled;

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = null;
        Configuration.timeout = 10000;

        switch (Project.config.deviceHost()) {
            case "emulate":
            case "real":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            default:
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                videoEnabled = true;
                break;
        }
    }

    public void login() {

        step("Enter server URL on the welcome page", () -> {
            WelcomePage welcomePage = new WelcomePage();
            welcomePage.enterServerUrl(Project.config.serverUrl());
        });

        step("Enter credentials on Login page", () -> {
            LoginPage loginPage = new LoginPage();
            loginPage.login(Project.config.emailAddress(), Project.config.password());
        });

        if (Project.config.deviceHost().equals("browserstack")) {
            step("Close popup", () -> {
                $(AppiumBy.xpath("//*[@resource-id=\"android:id/button1\"]")).click();
            });
        }
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void tearDown() {
        String sessionId = sessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        step("Close driver", Selenide::closeWebDriver);
        if (videoEnabled) {
            Attach.video(sessionId);
        }
    }
}
