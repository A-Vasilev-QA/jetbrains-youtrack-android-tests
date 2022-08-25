package qa.avasilev.pages;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import io.appium.java_client.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class IssuesPage extends AbstractPage {

    private SelenideElement searchField = $(AppiumBy.id("test:id/query-assist-input"));
    private SelenideElement issuesCount =
            $(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"issuesCount\"]/*[1]")); //$(AppiumBy.accessibilityId("issuesCount"));
    private SelenideElement sortBy = $(AppiumBy.id("test:id/issuesSortBy"));

    private String issueRowSelector = "(//android.view.ViewGroup[@content-desc=\"issue-row\"])";
    private ArrayList<String> taskNames = new ArrayList<>();


    public boolean isOpened() {
        sleep(3000);
        return (searchField.is(visible));
    }

    public Integer countRows() {

        actions().clickAndHold($(AppiumBy.xpath(issueRowSelector + "[6]")))
                .moveToElement($(AppiumBy.xpath(issueRowSelector + "[1]")))
                .release()
                .perform();
        for (int i = 1; i <= $$(AppiumBy.xpath(issueRowSelector)).size(); i++) {
            System.out.println($(AppiumBy.xpath(format(issueRowSelector + "[%d]/*/*[2]", i))).text());
            taskNames.add($(AppiumBy.xpath(format(issueRowSelector + "[%d]/*/*[2]", i))).text());
        }
        System.out.println(taskNames.size());
        return $$(AppiumBy.xpath(issueRowSelector)).size();
    }

    public boolean countedIssuesAreCorrect() {
        return countRows().toString().equals(issuesCount.text().substring(0, issuesCount.text().indexOf(' ')));
    }

}
