package qa.avasilev.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import qa.avasilev.config.Project;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", Project.config.browserstackUsername());
        mutableCapabilities.setCapability("browserstack.key", Project.config.browserstackAccessKey());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", "bs://d51675756582753eacb0195fd212d440aa56b8ef");

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", Project.config.device());
        mutableCapabilities.setCapability("os_version", Project.config.osVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "JetBrains Youtrack mobile automation project by Aleksei Vasilev");
        mutableCapabilities.setCapability("build", Project.config.build());
        mutableCapabilities.setCapability("name", "Youtrack Android test");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }
}
