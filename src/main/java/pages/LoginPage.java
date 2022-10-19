package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;


public class LoginPage extends BasePage<LoginPage> {

    @FindBy(xpath = "//img[@id = 'logomini']")
    WebElement formLogo;

    @FindBy(xpath = "//div[@class = 'wrapper']/center/h1")
    WebElement formHeadline;

    @FindBy(xpath = "//input[@type = 'text' and @placeholder = 'Username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@type = 'password' and @placeholder = 'Password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@type = 'submit' and @value = 'Login']")
    WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder='Username']//following-sibling::span[@class = 'help-block']")
    WebElement usernameHelpBlock;

    @FindBy(xpath = "//input[@placeholder='Password']//following-sibling::span[@class = 'help-block']")
    WebElement passwordHelpBlock;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /* The number of the similar methods can (and should be) reduced to smth like this:

    public LoginPage verifyElementsAreDisplayed(String... fieldNames) {
        stream(fieldNames).forEach(field -> assertTrue(field.isDisplayed());
        return this;
    }

    but it requires more time for implementation
    */

    public LoginPage verifyFormLogoIsDisplayed() {
        assertTrue(formLogo.isDisplayed());
        return this;
    }

    public LoginPage verifyFormHeadlineIsDisplayed() {
        assertTrue(formHeadline.isDisplayed());
        return this;
    }

    public LoginPage verifyUserNameFieldIsDisplayed() {
        assertTrue(usernameField.isDisplayed());
        return this;
    }

    public LoginPage verifyPasswordFieldIsDisplayed() {
        assertTrue(passwordField.isDisplayed());
        return this;
    }

    public LoginPage verifyLoginButtonIsDisplayed() {
        assertTrue(loginButton.isDisplayed());
        return this;
    }

    public LoginPage verifyUsernameHelpBlockIsDisplayed(String text) {
        assertTrue(usernameHelpBlock.isDisplayed() && usernameHelpBlock.getText().contains(text));
        return this;
    }

    public LoginPage verifyPasswordHelpBlockIsDisplayed() {
        assertTrue(passwordHelpBlock.isDisplayed());
        return this;
    }

    public LoginPage verifyUsernameHelpBlockIsNotDisplayed() {
        assertFalse(usernameHelpBlock.isDisplayed());
        return this;
    }

    public LoginPage verifyPasswordHelpBlockIsNotDisplayed() {
        assertFalse(passwordHelpBlock.isDisplayed());
        return this;
    }

    public LoginPage verifyLoginButtonIsEnabled() {
        assertTrue(passwordField.isEnabled());
        return this;
    }

    public LoginPage clickOnLoginButton() {
        verifyLoginButtonIsDisplayed();
        loginButton.click();
        return this;
    }

    public LoginPage fillPasswordField(String value) {
        clearPasswordField();
        passwordField.sendKeys(value);
        return this;
    }

    public LoginPage fillUsernameField(String value) {
        clearUsernameField();
        usernameField.sendKeys(value);
        return this;
    }

    public LoginPage clearPasswordField() {
        passwordField.clear();
        return this;
    }

    public LoginPage clearUsernameField() {
        usernameField.clear();
        return this;
    }

    public LoginPage verifyPasswordFieldIsClear() {
        assertTrue("Password field is not empty", passwordField.getText().isEmpty());
        return this;
    }

    public LoginPage verifyUserNameFieldIsClear() {
        assertTrue("Username field is not empty", usernameField.getText().isEmpty());
        return this;
    }

    public LoginPage verifyHeadlineText(String text) {
        assertEquals(formHeadline.getText(), text);
        return this;
    }
}