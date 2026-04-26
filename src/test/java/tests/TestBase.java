package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import tests.testdata.TestData;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    TestData testData = new TestData();

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterEach
    void afterEach(){
        closeWebDriver();
    }
}