package testSteps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class BaseSteps {

    private static final String BASE_URL = "https://github.com/";

    @Step("Opening github main page")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Searching for {repo}")
    public void searchForRepo(final String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Clicking on {repo}")
    public void goToRepoFromSearch(final String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Selecting issues tab")
    public void clickOnIssuesTab() {
        $(withText("Issues")).click();
    }

    @Step("Checking that issue with issue number {number} exists")
    public void issueExistenceCheck(final String number) {
        $(withText(number)).should(exist);
    }
}
