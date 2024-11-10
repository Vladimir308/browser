package screens;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

@Getter
public class WikipediaSearchScreen {

    private final SelenideElement searchCard = $(accessibilityId("Search Wikipedia"));
    private final SelenideElement searchBar = $(id("org.wikipedia.alpha:id/search_src_text"));

    private final WikipediaSearchResultsScreen searchResultsScreen = new WikipediaSearchResultsScreen();

    public void searchFor(String query) {
        searchCard.click();
        searchBar.sendKeys(query);
        searchResultsScreen.getFoundItems().first().shouldBe(visible);
    }
}