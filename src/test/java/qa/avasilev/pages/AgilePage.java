package qa.avasilev.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AgilePage extends AbstractPage {

    private SelenideElement searchField = $(AppiumBy.id("test:id/query-assist-input"));

    private String agileRowHeaderSelector = "(//*[@content-desc=\"agile-row-header\"])";

    public boolean isOpened() {
        $$(AppiumBy.xpath(agileRowHeaderSelector)).first().shouldBe(visible);
        return searchField.is(visible);
    }
}
