package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserStackDriver;
import drivers.LocalDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    public static final String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    static void beforeAll() {

        if (deviceHost.equals("browserstack")) {
            Configuration.browser = BrowserStackDriver.class.getName();
        } else {
            Configuration.browser = LocalDriver.class.getName();
        }

        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        open();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();

        if (deviceHost.equals("emulator")) {
            Attach.screenshotAs("Last screenshot");
        }

        Attach.pageSource();

        closeWebDriver();

        if (deviceHost.equals("browserstack")) {
            Attach.addVideo(sessionId);
        }
    }
}