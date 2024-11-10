package screens.ios;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class SampleAppSearchResultsScreen {

    private final SelenideElement textOutput = $(accessibilityId("Text Output"));

    @Step("Verify result")
    public String getResult() {
        return textOutput.getText();
    }
}