package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.testng.AllureTestNg;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@Listeners({AllureTestNg.class}) // 👈 Обязательный слушатель для TestNG
public class SampleTest {

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void openSauceDemo() {
        openSauceDemoPage();
        verifyLoginButtonVisible();
    }

    @Step("Open the page")
    public void openSauceDemoPage() {
        open("https://www.saucedemo.com");
    }

    @Step("Verify the Login Page")
    public void verifyLoginButtonVisible() {
        $("#login-button").shouldBe(visible);
    }
}
