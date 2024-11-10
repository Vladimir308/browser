package screens;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Getter
public class GetStartedScreen {
    private final SelenideElement skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")),
            continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            getStartedButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")),
            onboardingTabTitle = $(id("org.wikipedia.alpha:id/primaryTextView"));

    public String clickContinueButton() {
        continueButton.click();

        return onboardingTabTitle.getText();
    }

    public void clickGetStartedButton() {
        getStartedButton.click();
    }

    public void clickSkipButton() {
        skipButton.click();
    }
    public void checkPageTitleIsDisplayed(String expectedTitle) {
        assertThat(onboardingTabTitle.getText()).isEqualTo(expectedTitle);
    }

    private final String expectedTitleForSecondScreen = "New ways to explore";
    private final String expectedTitleForThirdScreen = "Reading lists with sync";
    private final String expectedTitleForFourthScreen = "Data & Privacy";
}
