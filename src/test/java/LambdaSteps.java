import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaSteps extends TestBase {
    private static final int issueNumber = 4;
    private static final String repository = "PracticeForm";

    @Test
    public void lambdaStepTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем профиль", () -> {
            open("/DefRoga");
        });

        step("Открываем репозиторий " + repository, () -> {
            $x("//a[@href = '/DefRoga?tab=repositories']").click();
            $x("//a[normalize-space(text())='"+ repository + "' and @href]").click();
        });

        step("Переходим в раздел Issue", () -> {
            $x("//a[@id = 'issues-tab']").click();
        });

        step("Проверяем наличие Issue с номером #" + issueNumber, () -> {
            $x("//li[contains(@aria-label, '#" + issueNumber + "')]").should(Condition.exist);
        });

    }

    @Test
    public void annotationStepsTest () {
        SelenideLogger.addListener("allure", new AllureSelenide());
        AnnotationStep steps = new AnnotationStep();

        steps.openPage();
        steps.clickTabRepo();
        steps.clickRepo(repository);
        steps.openIssueTab();
        steps.checkIssueNumber(issueNumber);
    }
}