package testsExamples;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PureSelenideSearchTest {

    private static final String BASE_URL = "https://github.com/";
    private static final String REPO = "akiselef/basicAllureDemo";
    private static final String ISSUE_NUMBER = "#2";

    @Test
    @Owner("akiselef")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("demo"), @Tag("web")})
    @Link(name = "Github Main Page", value = BASE_URL)
    @Feature("Issues check")
    @Story("ZG-1337")
    @DisplayName("Search for issue by it's number (pure Selenide)")
    void searchForIssueTest() {
        open(BASE_URL);

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPO);
        $(".header-search-input").submit();
        $(byLinkText(REPO)).click();
        $(withText("Issues")).click();
        $(withText(ISSUE_NUMBER)).should(exist);

    }
}
