package github_enterprise;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

// Preparing browser for all tests
public class TestBaseGithub {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";  //site to test
        Configuration.browserSize = "1920x1080";
    }
}
