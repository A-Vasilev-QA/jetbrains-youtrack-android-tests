package qa.avasilev.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class KnowledgeBasePage extends AbstractPage {

    private final SelenideElement searchField = $(AppiumBy.id("test:id/knowledge-base-search-panel"));

    public boolean isOpened() {
        searchField.shouldBe(visible);
        return searchField.is(visible);
    }
}
