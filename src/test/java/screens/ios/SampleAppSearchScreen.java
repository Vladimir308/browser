package screens.ios;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class SampleAppSearchScreen {

    private final SelenideElement textButton = $(accessibilityId("Text Button"));
    private final SelenideElement textInput = $(accessibilityId("Text Input"));

    @Step("Perform search")
    public void searchFor(String query) {
        textButton.click();
        textInput.click();
        textInput.sendKeys(query);
        textInput.pressEnter();
    }
}