package step_defs;

import Utilities.ConfigUtils;
import Utilities.DriverUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.FacebookLoginPage;

public class FacebookSteps {
    private WebDriver driver;
    private FacebookLoginPage flp; //in order not to type the same object again and again

    @Given("I am on Facebook login page")
    public void i_am_on_facebook_login_page() {
        driver = DriverUtils.getDriver("chrome");
        String url = ConfigUtils.getConfigProp("urlFacebook");
        driver.get(url);
    }
    @When("I enter invalid Facebook {string}")
    public void i_enter_invalid_facebook(String email) {
        flp = new FacebookLoginPage(driver);
        flp.emailFacebook.sendKeys(email);
    }
    @When("I login with invalid Facebook {string}")
    public void i_login_with_invalid_facebook(String password) {
        FacebookLoginPage flp = new FacebookLoginPage(driver);//OR shortcut flp = new FacebookLoginPage(driver);
        flp.passwordFacebook.sendKeys(password);
        flp.logInButton.click();
    }
    @Then("I should get error message:{string}")
    public void i_should_get_error_message(String expectedError) {
        FacebookLoginPage flp = new FacebookLoginPage(driver);
        String actualError = flp.error.getText();
       // Assert.assertEquals(expectedError,actualError); this one will Fail because it has only part of the text not the whole announcement

        Assert.assertTrue(actualError.contains(expectedError));
    }


}
