package tests.emulator;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.android.WikipediaSearchResultsScreen;
import screens.android.WikipediaSearchScreen;
import tests.TestBase;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("emulator")
@Epic("Тестирование Wikipedia")
@Feature("Поиск в Wikipedia")
@Story("Успешный и не успешный поиск статей")
public class SearchTests extends TestBase {

    private final WikipediaSearchScreen searchScreen = new WikipediaSearchScreen();
    private final WikipediaSearchResultsScreen searchResultsScreen = new WikipediaSearchResultsScreen();

    @Test
    @DisplayName("Успешный поиск")
    void successfulSearchTest() {

        String query = "Appium";

        step("Skip onboarding", Selenide::back);
        step("Perform search", () -> searchScreen.searchFor(query));
        step("Verify result", () -> {
            assertThat(searchResultsScreen.getResultsCount()).isGreaterThan(0);
        });
    }
}