package screens.android;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class WikipediaSearchResultsScreen {

    private static final ElementsCollection foundItems = $$(id("org.wikipedia.alpha:id/page_list_item_title"));
    private static final SelenideElement errorText = $(id("org.wikipedia.alpha:id/view_wiki_error_text"));
    private static final SelenideElement loginText = $(id("org.wikipedia.alpha:id/login_button"));

    @Step("Verify result")
    public static int getResultsCount() {

        return foundItems.size();
    }

    @Step("Verify result")
    public static void ResultError() {
        errorText.shouldBe(visible);
    }

    @Step("Verify result")
    public static void ResultLogin() {
        loginText.shouldHave(text("Log in"));
    }
}