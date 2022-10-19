package loginPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;


public class LoginPageUITest {
    protected static WebDriver driver;
    public static final String NO_ACCOUNT_FOUND_MESSAGE = "No account found with that username.";
    public static final String PLEASE_ENTER_USERNAME_MESSAGE = "Please enter username.";
    public static final String LOGIN_HEADLINE_TEXT = "AQA internship Login";
    public static final String USERNAME = "testUser";
    public static final String PASSWORD = "12345ff";

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\katew\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.pecodesoftware.com/qa-portal/registerlogin/registerlogin.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")));
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test(priority = 1, description = "Verify that all of the elements of the Login Page form are displayed")
    public void loginPageComponentsTest() {
        new LoginPage(driver)
                .verifyFormLogoIsDisplayed()
                .verifyFormHeadlineIsDisplayed()
                .verifyUserNameFieldIsDisplayed()
                .verifyPasswordFieldIsDisplayed()
                .verifyLoginButtonIsDisplayed();
    }


    @Test(priority = 2, description = "Verify that the text of the Login form headline equals to 'AQA internship Login'")
    public void loginFormHeadlineTextTest() {
        new LoginPage(driver)
                .verifyHeadlineText(LOGIN_HEADLINE_TEXT);
    }

    @Test(priority = 3, description = "Verify that Login Button is enabled; " +
            "Verify that by clicking on the Login Button and if the Password or UserName fields are empty, " +
            "the Help blocks messages are displayed")
    public void loginButtonHelpBlocksTest() {
        new LoginPage(driver)
                .verifyLoginButtonIsEnabled()
                //case 1
                .clickOnLoginButton()
                .verifyPasswordHelpBlockIsDisplayed()
                .verifyUsernameHelpBlockIsDisplayed(PLEASE_ENTER_USERNAME_MESSAGE)
                //case 2
                .fillPasswordField(PASSWORD)
                .clickOnLoginButton()
                .verifyPasswordHelpBlockIsNotDisplayed()
                .verifyUsernameHelpBlockIsDisplayed(PLEASE_ENTER_USERNAME_MESSAGE)
                .clearPasswordField()
                //case 3
                .fillUsernameField(USERNAME)
                .clickOnLoginButton()
                .verifyPasswordHelpBlockIsDisplayed()
                //case 4
                .fillPasswordField(PASSWORD)
                .fillUsernameField(USERNAME)
                .clickOnLoginButton()
                .verifyUsernameHelpBlockIsDisplayed(NO_ACCOUNT_FOUND_MESSAGE)
                //clear fields after test
                .clearUsernameField()
                .clearPasswordField();
    }

    @Test(priority = 4, description = "Verify that after page refresh the Password and UserName fields are empty")
    public void loginPageRefreshTest() {
        new LoginPage(driver)
                .fillPasswordField(PASSWORD)
                .fillUsernameField(USERNAME)
                .refreshPage()
                .verifyPasswordFieldIsClear()
                .verifyUserNameFieldIsClear();
    }
}