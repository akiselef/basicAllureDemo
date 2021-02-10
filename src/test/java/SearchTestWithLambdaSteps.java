import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class SearchTestWithLambdaSteps {

    private static final String BASE_URL = "https://github.com/";
    private static final String REPO = "akiselef/basicAllureDemo";
    private static final String ISSUE_NUMBER = "#2";
    private static final String ISSUES = "Issues";


    @Test
    @Owner("akiselef")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("demo"), @Tag("web")})
    @Link(name = "Github Main Page", value = BASE_URL)
    @Feature("Issues check")
    @Story("ZG-1337")
    @DisplayName("Search for issue by it's number (/w lambdas)")
    void lambdasSearchForIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        parameter("Repo",REPO);
        parameter("Issue Number", ISSUE_NUMBER);

        step("Opening github main page", () -> {
            open(BASE_URL);
        });
        step("Searching for " + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPO);
            $(".header-search-input").submit();
        });
        step("Clicking on " + REPO + " link", () -> {
            $(By.linkText(REPO)).click();
        });
        step("Selecting " + ISSUES + " tab", () -> {
            $(withText("Issues")).click();
        });
        step("Checking that issue with issue number " + ISSUE_NUMBER + " exists", () -> {
            $(withText(ISSUE_NUMBER)).should(exist);
        });
    }

    @Test
    @Owner("akiselef")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("demo"), @Tag("web"), @Tag("Failed_on_purpose")})
    @Link(name = "Github Main Page", value = BASE_URL)
    @Feature("Issues check")
    @Story("ZG-1338")
    @DisplayName("Failed test (I did it for the science!)")
    void lambdasFailedTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        parameter("Repo",REPO);
        parameter("Issue Number", ISSUE_NUMBER);

        step("Opening github main page", () -> {
            open(BASE_URL);
        });
        step("Searching for " + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPO);
            $(".header-search-input").submit();
        });
        step("Clicking on " + REPO + " link", () -> {
            $(By.linkText(REPO)).click();
        });
        step("Selecting " + ISSUES + " tab", () -> {
            $(withText("Issues123")).click();
        });
        step("Checking that issue with issue number " + ISSUE_NUMBER + " exists", () -> {
            $(withText(ISSUE_NUMBER)).should(exist);
        });
    }

}