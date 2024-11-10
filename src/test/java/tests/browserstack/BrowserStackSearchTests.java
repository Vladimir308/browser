package tests.browserstack;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.WikipediaSearchResultsScreen;
import screens.WikipediaSearchScreen;
import tests.TestBase;
import java.util.concurrent.atomic.AtomicReference;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("browserstack")
@Epic("Тестирование Wikipedia")
@Feature("Поиск в Wikipedia")
public class BrowserStackSearchTests extends TestBase {

    private final WikipediaSearchScreen searchScreen = new WikipediaSearchScreen();
    private final WikipediaSearchResultsScreen searchResultsScreen = new WikipediaSearchResultsScreen();

    @Test
    @DisplayName("Успешный поиск")
    void successfulSearchTest() {
        String query = "Appium";

        step("Perform search", () -> searchScreen.searchFor(query));
        step("Verify result", () -> {
            assertThat(searchResultsScreen.getResultsCount()).isGreaterThan(0);
        });
    }

    @Test
    @DisplayName("Неуспешный поиск и открытие первой найденной статьи")
    void unsuccessfulSearchAndOpenFirstResultTest() {
        String query = "Italy";
        AtomicReference<String> result = new AtomicReference<>();
        int articleNumber = 0;

        step("Perform search", () -> searchScreen.searchFor(query));
        step("Open page", () -> result.set(searchResultsScreen.tryToOpenFoundArticle(articleNumber)));
        step("Verify result", () -> {
            assertThat(result.get()).isEqualTo("An error occurred");
        });
    }
}