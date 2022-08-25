package qa.avasilev.tests;


import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import qa.avasilev.config.Project;
import qa.avasilev.pages.IssuesPage;
import qa.avasilev.pages.LoginPage;
import qa.avasilev.pages.WelcomePage;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends TestBase{

    @Test
    void openTest() {
        $$(AppiumBy.xpath("//*")).shouldHave(sizeGreaterThan(0));
    }


    @Test
    void loginTest() {

        WelcomePage welcomePage = new WelcomePage();

        welcomePage.enterServerUrl(Project.config.serverUrl());
        //welcomePage.dealWithSync(Project.config.emailAddress());

        LoginPage loginPage = new LoginPage();

        loginPage.login(Project.config.emailAddress(), Project.config.password());

        IssuesPage issuesPage = new IssuesPage();

        assertTrue(issuesPage.isOpened());
        assertNotEquals(0, issuesPage.countRows());
        System.out.println(issuesPage.countRows());

    }
}
