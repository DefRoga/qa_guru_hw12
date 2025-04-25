
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class SelenideIssueTest extends TestBase {

@Test
    public void repoPageContainIssue() {
    open("/DefRoga");
    $x("//a[@href = '/DefRoga?tab=repositories']").click();
    $x("//a[normalize-space(text())='PracticeForm' and @href]").click();
    $x("//a[@id='issues-tab']").click();
    $x("//*[contains(text(), '#3')]").should(Condition.exist);
    }
}
