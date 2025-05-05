
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;


public class SelenideTest extends TestBase {

    @Test
    public void repoPageContainIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

            open("/DefRoga");
            $x("//a[@href = '/DefRoga?tab=repositories']").click();
            $x("//a[normalize-space(text())='PracticeForm' and @href]").click();
            $x("//a[@id='issues-tab']").click();
            $x("//li[contains(@aria-label, '#4')]").should(Condition.exist);

    }
}
