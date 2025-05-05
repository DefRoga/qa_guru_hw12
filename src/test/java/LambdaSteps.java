import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaSteps extends TestBase {

    @Test
    public void lambdaStepTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем профиль", () -> {
            open("/DefRoga");
        });

        step("Открываем репозиторий PracticeForm", () -> {
            $x("//a[@href = '/DefRoga?tab=repositories']").click();
            $x("//a[normalize-space(text())='PracticeForm' and @href]").click();
        });

        step("Переходим в раздел Issue", () -> {
            $x("//a[@id = 'issues-tab']").click();
        });

        step("Проверяем наличие Issue с номером #4", () -> {
            $x("//li[contains(@aria-label, '#4')]").should(Condition.exist);
        });
    }
}