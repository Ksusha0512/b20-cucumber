package step_defs;

import Utilities.ConfigUtils;
import Utilities.DriverUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import pages.SauceLoginPage;
import pages.SauceProductsPage;

import java.util.List;

public class SaucedStep {
    WebDriver driver;

    @When("I navigate to Saucedemo")
    public void i_navigate_to_saucedemo() {
        driver = DriverUtils.getDriver("chrome");
        String url = ConfigUtils.getConfigProp("urlSa");
        driver.get(url);
    }

    ////Given, when,then, and
    @Then("I login using username")
    public void i_login_using_username() {
        WebElement login = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        String loginField = ConfigUtils.getConfigProp("sauce_username");
        login.sendKeys(loginField);
    }

    @Then("I apply password and click enter")
    public void i_apply_password_and_click_enter() {
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passwordField = ConfigUtils.getConfigProp("sauce_password");
        password.sendKeys(passwordField);

        WebElement EnterSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
        EnterSubmit.click();
    }

    @Then("I print out all item names from page")
    public void i_print_out_all_item_names_from_page() {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        //OR By.cssSelector".inventory_item_description" if its class
        for (int i = 0; i < elements.size(); i++) {
            WebElement allProducts = elements.get(i);
            String productsListText = allProducts.getText();
            System.out.println("Product list: " + productsListText);
            //OR <WebElement> items = driver.findElements(By.cssSelector(".inventory_item_description"));
            //        for (WebElement item : items) {
            //            System.out.println(item.getText());

        }
    }

    @When("I login with locked username and password")
    public void i_login_with_locked_username_and_password() {
        SauceLoginPage slp = new SauceLoginPage(driver);
        String username = ConfigUtils.getConfigProp("sauce_locked_username");
        String password = ConfigUtils.getConfigProp("sauce_password");
        slp.login(username, password);
        //OR slp.login("locked_out_user","secret_sauce");
    }

    @Then("I should get error message")
    public void i_should_get_error_message() {
        SauceLoginPage slp = new SauceLoginPage(driver);
        String error = slp.getErrorMessage();
        System.out.println(error);

//I already navigated to site by using the same command
    }

    @Then("I login with visual_user")
    public void i_login_with_visual_user() {
        WebElement login = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        String loginField = ConfigUtils.getConfigProp("visual_username");
        login.sendKeys(loginField);

        //I already used Password by using the same command in Saucemodo.feature and clicked
    }

    @Then("I select product name and print price")
    public void i_select_and_print_price(String string) {
        WebElement onsises = driver.findElement(By.linkText("Sauce Labs Onesie"));
        String onsiseName = onsises.getText();
        System.out.println(onsiseName);
        WebElement priceOnsies = driver.findElement(By.linkText("7.99"));
        String pricePerItem = priceOnsies.getText();
        System.out.println(pricePerItem);

    }

    @Then("I add Onesie to Cart")
    public void i_add_onesie_to_cart() {
        WebElement clickAddToCart = driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-onesie']"));
        String click = clickAddToCart.getText();
        System.out.println(click);
        clickAddToCart.click();
    }

    @Then("I open Cart")
    public void i_open_cart() {
        WebElement clickCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        clickCart.click();
    }

    @Then("I validate Onesie in the cart")
    public void i_validate_onesie_in_the_cart() {
        WebElement ItemInCart = driver.findElement(By.cssSelector("#item_2_title_link"));
    }


    //NEW HOME WORK
    @Then("I click on item and print the item name and price")
    public void i_click_on_item_and_print_the_item_name_and_price() {
        WebElement onesiesItem = driver.findElement(By.linkText("Sauce Labs Onesie"));
        String printItemName = onesiesItem.getTagName();
        System.out.println(printItemName);
        onesiesItem.click();

    }

    @Then("I click on Onesie to add it to Cart")
    public void i_click_on_onesie_to_add_it_to_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I click on Cart sign")
    public void i_click_on_cart_sign() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I validate the Item in the Cart")
    public void i_validate_the_item_in_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //CLASS WORK scenario: Login with visual user Backpack
    //        When I navigate to Saucedemo
    //        Given I login with visual_user
    //        Then I apply password and click enter

    @Then("I should see {string} item")
    public void i_should_see_item(String string) {
        SauceProductsPage spp = new SauceProductsPage(driver);
        if (string.equalsIgnoreCase("backpack")) {
            boolean isBackpackDisplayed = spp.backpack.isDisplayed();
            Assert.assertTrue(isBackpackDisplayed);
        } else if (string.equalsIgnoreCase("onesie")) {
            boolean isOnesieDisplayed = spp.onesie.isDisplayed();
            Assert.assertTrue(isOnesieDisplayed);
        } else {
            Assert.fail("Provided item does not support");
        }
    }
    @Then("price should be {double}")
    public void price_should_be(double price) {
        SauceProductsPage spp = new SauceProductsPage(driver);
        String priceText = spp.onesiePrice.getText();
        System.out.println(priceText.substring(1));

}}
