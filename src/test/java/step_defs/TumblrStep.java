package step_defs;

import Utilities.ConfigUtils;
import Utilities.DriverUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.TumblerHomePage;

public class TumblrStep {
    WebDriver driver;

    @When("I navigate to https:\\/\\/www.tumblr.com\\/")
    public void i_navigate_to_https_www_tumblr_com() {
        driver = DriverUtils.getDriver("chrome");
        String url = ConfigUtils.getConfigProp("urlTumblr");
        driver.get(url);
    }
    @Then("I click Log In")
    public void i_click_log_in() {
       // WebElement LogInBottomPage = driver.findElement(By.xpath("//button[@aria-label='Log in']"));
        //LogInBottomPage.click();
        TumblerHomePage thp = new TumblerHomePage(driver);
        thp.loginButton.click();

    }
    @Then("I click Continue with email")
    public void i_click_continue_with_email() {
       WebElement clickEmail = driver.findElement(By.xpath("//button[@aria-label='Continue with email']"));
       clickEmail.click();
    }
    @Then("I enter email : \\(test@test.com)")
    public void i_enter_email_test_test_com() {
        WebElement emailType = driver.findElement(By.xpath("//input[@aria-label='email']"));
        String emailField = ConfigUtils.getConfigProp("emailInsert");
        emailType.sendKeys(emailField+ Keys.ENTER);
    }

    @Then("I enter invalid password\\(abcabc)")
    public void i_enter_invalid_password_abcabc() {
       WebElement PasswordField = driver.findElement(By.xpath("//input [@name='password']"));
       String passwordInvalid = ConfigUtils.getConfigProp("passwordInvalid");
       PasswordField.sendKeys(passwordInvalid+Keys.ENTER);
    }

    @Then("I Validate error message")
    public void i_validate_error_message(String expectedError) {
       TumblerHomePage thp = new TumblerHomePage(driver);
       String actualError = thp.error.getText();
        Assert.assertEquals(expectedError,actualError);
    }
    // new Scenario

    @Given("I'm on Tumblr home page")
    public void i_m_on_tumblr_home_page() {
        driver = DriverUtils.getDriver("chrome");
        String url = ConfigUtils.getConfigProp("urlTumblr");
        driver.get(url);
    }
    @When("I click login button")
    public void i_click_login_button() {
        TumblerHomePage thp = new TumblerHomePage(driver);
        thp.loginButton.click();

    }
    @When("I click continue with email button")
    public void i_click_continue_with_email_button() {
        TumblerHomePage thp = new TumblerHomePage(driver);
        thp.continueWithEmailButton.click();
    }
    @When("I enter {string} email")
    public void i_enter_email(String email) {
        TumblerHomePage thp = new TumblerHomePage(driver);
        thp.emailInputField.sendKeys(email+Keys.ENTER);
    }

    @When("I enter {string} password")
    public void i_enter_password(String password) {
        TumblerHomePage thp = new TumblerHomePage(driver);
        thp.passwordInputField.sendKeys(password+Keys.ENTER);
    }
    @Then("I should get {string} error")
    public void i_should_get_error(String expectedError1) {
        TumblerHomePage thp = new TumblerHomePage(driver);
        String actualError1 = thp.error.getText();
        Assert.assertEquals(expectedError1,actualError1);

    }



}
