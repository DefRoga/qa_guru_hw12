import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "normal";
        Configuration.baseUrl = "https://github.com/";
        Configuration.holdBrowserOpen = true;
    }

}
