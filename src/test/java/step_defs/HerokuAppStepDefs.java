package step_defs;

import Utilities.ConfigUtils;
import Utilities.DriverUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HerokuAppStepDefs {

    WebDriver driver;
String headerText;
    @When("I navigate to homepage")
    public void i_navigate_to_homepage() {
        driver = DriverUtils.getDriver("chrome");
        String url = ConfigUtils.getConfigProp("url");
        driver.get(url);
    }
    @Then("I should see {int} links")
    public void i_should_see_links( int int1) {
        List<WebElement>linkElementList = driver.findElements(By.xpath("//li//a"));
        int linkCount = linkElementList.size();
        Assert.assertEquals(int1,linkCount);
    }
    @When("I navigate to Checkboxes page")
    public void i_navigate_to_checkboxes_page() {
        driver = DriverUtils.getDriver("chrome");
        String url10 = ConfigUtils.getConfigProp("url11");
       // driver.get(url10); OR
        driver.navigate().to(url10); //new method , they do the same thing
    }
    @Then("I validate the header of Checkbox header")
    public void i_validate_the_header_of_checkbox_header() {
        String CheckboxText = driver.findElement(By.tagName("h3")).getText();
        headerText = CheckboxText;
        Assert.assertEquals("Checkboxes",CheckboxText);

    }
    @Then("I print the header")
    public void i_print_the_header() {
        System.out.println(headerText);
    }
}
