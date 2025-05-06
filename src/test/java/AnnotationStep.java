import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AnnotationStep {

    @Step("Открываем профиль")
    public void openPage (){
        open("https://github.com/DefRoga");
    }

    @Step("Открываем таб с репозиториями")
    public void clickTabRepo() {
        $x("//a[@href = '/DefRoga?tab=repositories']").click();
    }

    @Step("Открываем репозиторий {repository}")
    public void clickRepo (String repository) {
        $x("//a[normalize-space(text())='"+ repository + "' and @href]").click();
    }

    @Step("Переходим в раздел Issue")
    public void openIssueTab () {
        $x("//a[@id = 'issues-tab']").click();
    }

    @Step("Проверяем наличие Issue с номером #{issueNumber}}")
    public void checkIssueNumber (int issueNumber) {
        $x("//li[contains(@aria-label, '#" + issueNumber + "')]").should(Condition.exist);
    }
}
