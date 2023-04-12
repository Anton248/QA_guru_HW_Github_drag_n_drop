package github_enterprise;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubEnterpriseTests extends TestBaseGithub {
    @Test
    void hoverAndOpen() {
        //Configuration.holdBrowserOpen = true;

        open("/");

// На главной странице GitHub выбрать меню Solutions -> Enterprise с помощью команды hover для Solutions.
        $("div.header-menu-wrapper").$(byText("Solutions")).hover();
        $("a[href='/enterprise']").shouldHave(text("Enterprise")).click();

// Грузится страница Enterprise с заголовком "Build like the best"
        $(withTagAndText("h1", "Build like the best")).shouldBe(visible);
    }
}
