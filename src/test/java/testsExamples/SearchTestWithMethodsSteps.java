package testsExamples;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import testSteps.BaseSteps;

import static io.qameta.allure.Allure.parameter;

public class SearchTestWithMethodsSteps {
    private static final String BASE_URL = "https://github.com/";
    private static final String REPO = "akiselef/basicAllureDemo";
    private static final String ISSUE_NUMBER = "#2";

    public BaseSteps baseSteps = new BaseSteps();


    @Test
    @Owner("akiselef")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("demo"), @Tag("web"), @Tag("methods")})
    @Link(name = "Github Main Page", value = BASE_URL)
    @Feature("Issues check")
    @Story("ZG-1339")
    @DisplayName("Search for issue by it's number (/w steps in methods)")
    void methodsSearchForIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        parameter("Repo",REPO);
        parameter("Issue Number", ISSUE_NUMBER);

        baseSteps.openMainPage();
        baseSteps.searchForRepo(REPO);
        baseSteps.goToRepoFromSearch(REPO);
        baseSteps.clickOnIssuesTab();
        baseSteps.issueExistenceCheck(ISSUE_NUMBER);
    }
}
