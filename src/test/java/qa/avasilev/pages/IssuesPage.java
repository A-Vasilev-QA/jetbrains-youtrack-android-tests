package qa.avasilev.pages;


import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import java.util.HashSet;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class IssuesPage extends AbstractPage {

    private final SelenideElement searchField = $(AppiumBy.id("test:id/query-assist-input"));
    private final SelenideElement issuesCount = $(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"issuesCount\"]/*[1]")); //$(AppiumBy.accessibilityId("issuesCount"));
    private final SelenideElement sortBy = $(AppiumBy.id("test:id/issuesSortBy"));

    private final String issueRowSelector = "(//android.view.ViewGroup[@content-desc=\"issue-row\"])";
    private final HashSet<String> issueNumbers = new HashSet<>();


    public boolean isOpened() {
        searchField.shouldBe(visible);
        return (searchField.is(visible));
    }

    public Integer countRows() {

        String lastIssue = $$(AppiumBy.xpath(issueRowSelector + "/*/*[2]")).first().text();

        while (!lastIssue.equals($$(AppiumBy.xpath(issueRowSelector + "/*/*[2]")).last().text())) {
            lastIssue = $$(AppiumBy.xpath(issueRowSelector + "/*/*[2]")).last().text();

            for (SelenideElement i : $$(AppiumBy.xpath(issueRowSelector + "/*/*[2]"))) {
                if (!i.text().equals("")) {
                    issueNumbers.add(i.text());
                }
            }
            scrollForward();
        }

        return issueNumbers.size();
    }

    public String getIssueIdByNumber(Integer number) throws Exception {

        if (number >= $$(AppiumBy.xpath(issueRowSelector)).size()) { //currently, works only with tasks on the screen
            throw new Exception("Open task by number is not possible: " +
                    "Number is bigger than number of tasks on the screen");
        }

        return $$(AppiumBy.xpath(issueRowSelector + "/*/*[2]")).get(number).text();

    }

    public String checkIssuePageHeaderByNumber(Integer number) throws Exception {

        if (number >= $$(AppiumBy.xpath(issueRowSelector)).size()) { //currently, works only with tasks on the screen
            throw new Exception("Open task by number is not possible: " +
                    "Number is bigger than number of tasks on the screen");
        }
        //todo:update for whole screen
        $$(AppiumBy.xpath(issueRowSelector)).get(number).click();

        $(AppiumBy.xpath("//*[@resource-id=\"issue-id\"]")).shouldBe(visible);
        return $(AppiumBy.xpath("//*[@resource-id=\"issue-id\"]")).text();

    }

    public boolean countedIssuesAreCorrect() {
        return issuesCount.text().substring(0, issuesCount.text().indexOf(' '))
                .equals(countRows().toString());
    }

}
