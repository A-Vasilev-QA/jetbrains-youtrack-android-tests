package qa.avasilev.tests;


import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class MainTest extends TestBase{

    @Test
    void openTest() {
        $$(AppiumBy.xpath("//*")).shouldHave(sizeGreaterThan(0));
        sleep(100000);
    }
}
