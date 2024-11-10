package screens.android;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

@Getter
public class WikipediaSearchScreen {

    public final SelenideElement
            continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            searchCard = $(accessibilityId("Search Wikipedia")),
            searchBar = $(id("org.wikipedia.alpha:id/search_src_text")),
            menuButton = $(id("org.wikipedia.alpha:id/menu_overflow_button")),
            nameAccount = $(id("org.wikipedia.alpha:id/explore_overflow_account_name"));

    @Step("Perform search")
    public void searchFor(String query) {
        searchCard.click();
        searchBar.sendKeys(query);
    }

    @Step("Perform search")
    public void searchForUnsuccessful(String query) {
        searchCard.click();
        searchBar.sendKeys(query);
        $$(id("org.wikipedia.alpha:id/page_list_item_container")).first().click();
    }

    @Step("Perform search")
    public void loginButton() {
        menuButton.click();
        nameAccount.shouldHave(text("Log in to Wikipedia"));
        nameAccount.click();
    }
}