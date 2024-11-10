package tests.emulator;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.GetStartedScreen;
import screens.WikipediaSearchScreen;
import tests.TestBase;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("emulator")
@Epic("Тестирование Wikipedia")
@Feature("Онбординг нового пользователя в Wikipedia")
@Story("Прохождение и пропуск онбординга")
public class GetStartedTests extends TestBase {

    private final GetStartedScreen getStartedScreen = new GetStartedScreen();
    private final WikipediaSearchScreen searchScreen = new WikipediaSearchScreen();

    @Test
    @DisplayName("Пропуск онбординга с помощью кнопки Skip")
    void successfullySkipOnboarding() {
        step("Закрыть экран онбординга Get Started с помощью кнопки Skip", getStartedScreen::clickSkipButton);
        step("Убедиться, что отображается строка поиска", () ->
                assertThat(searchScreen.getSearchCard().isDisplayed()));
    }

    @Test
    @DisplayName("Прохождение онбординга с переходом по экранам")
    void successfullyGoThroughOnboarding() {
        step("Перейти на следующий экран туториала, нажав Сontinue", getStartedScreen::clickContinueButton);
        step("Проверить, что отображается корректное название экрана", () ->
                getStartedScreen.checkPageTitleIsDisplayed(getStartedScreen.getExpectedTitleForSecondScreen()));
        step("Перейти на следующий экран туториала, нажав Сontinue", getStartedScreen::clickContinueButton);
        step("Проверить, что отображается корректное название экрана", () ->
                getStartedScreen.checkPageTitleIsDisplayed(getStartedScreen.getExpectedTitleForThirdScreen()));
        step("Перейти на следующий экран туториала, нажав Сontinue", getStartedScreen::clickContinueButton);
        step("Проверить, что отображается корректное название экрана", () ->
                getStartedScreen.checkPageTitleIsDisplayed(getStartedScreen.getExpectedTitleForFourthScreen()));
        step("Перейти на главный экран, нажав Get Started", getStartedScreen::clickGetStartedButton);
        step("Убедиться, что отображается строка поиска", () ->
                assertThat(searchScreen.getSearchCard().isDisplayed()));
    }
}