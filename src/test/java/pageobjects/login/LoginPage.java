package pageobjects.login;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import pages.BasePage;
import pages.projectsPage.ProjectsPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

@Log4j2
public class LoginPage extends BasePage {

    private static final By EMAIL_INPUT_ID = id("inputEmail");
    private static final By PASSWORD_INPUT_ID = id("inputPassword");
    private static final By REMEMBER_ME_CHECKBOX = cssSelector(".custom-control-input");
    private static final By LOGIN_BUTTON_ID = id("btnLogin");

    private final String HOME_URL = propertyReader.getPropertyValueByKey("base_url") + "login";


    @Step("Verifying is Login Page opened")
    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(LOGIN_BUTTON_ID).shouldBe(Condition.visible, Duration.ofSeconds(4));
        return element.isDisplayed();
    }

    @Step("Opening Login Page")
    public LoginPage openLoginPage() {
        log.info("Opening LoginPage.");
        open(HOME_URL);
        return this;
    }

    @Step("Entering user email: {userEmail}")
    public LoginPage enterUserEmail(String userEmail) {
        log.info("Entering user email: {}.", userEmail);
        $(EMAIL_INPUT_ID).sendKeys(userEmail);
        return this;
    }

    @Step("Entering user password: {userPassword}")
    public LoginPage enterUserPassword(String userPassword) {
        log.info("Entering user password: {}.", userPassword);
        $(PASSWORD_INPUT_ID).sendKeys(userPassword);
        return this;
    }

    @Step("Click on Login button")
    public ProjectsPage clickLoginButton() {
        log.info("Pressing Login button on LoginPage.");
        $(LOGIN_BUTTON_ID).click();
        return new ProjectsPage();
    }
}
