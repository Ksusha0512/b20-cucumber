package step_defs;

import Utilities.ConfigUtils;
import Utilities.DriverUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.LambdaTestHomePage;
import pages.LambdaTestInputFormPage;
import pages.LambdaTestValidationPage;

import java.util.Map;

public class LabdaTestSteps {
    private WebDriver driver;
    //private LambdaTestHomePage lthp;
    private LambdaTestInputFormPage lthp;

    @Given("I am on LambdaTest site")
    public void i_am_on_lambda_test_site() {
    driver = DriverUtils.getDriver("chrome");
    String url = ConfigUtils.getConfigProp("urlLambdaTest");
    driver.get(url);
    }
    @When("I click on Input Form link")
    public void i_click_on_input_form_link() {
        LambdaTestHomePage lthp = new LambdaTestHomePage(driver);
        lthp.inputFormSubmit.click();
    }
    @Then("I fill in Input Form")
    public void i_fill_in_input_form() {
        LambdaTestInputFormPage ifp = new LambdaTestInputFormPage((driver));
        ifp.name.sendKeys("Codefish");
        ifp.email.sendKeys("labner89567@gmail.com");
        ifp.password.sendKeys("Codefish123");
        ifp.company.sendKeys("Codefish");
        ifp.website.sendKeys("www.codefish.com");
        ifp.chooseCountry.click();
        Select selectCountry = new Select(ifp.chooseCountry);
        selectCountry.selectByVisibleText("United States");
        ifp.city.sendKeys("Arlington Heights");
        ifp.address.sendKeys("2200 Range Road");
        ifp.address2.sendKeys("N/A");
        ifp.state.sendKeys("IL");
        ifp.zipCode.sendKeys("60018");

    }
    @Then("Click submit")
    public void click_submit() {
        LambdaTestInputFormPage ifp = new LambdaTestInputFormPage(driver);
        ifp.submitButton.click();

    }
    @Then("validate submit message")
    public void validate_submit_message() {
        LambdaTestValidationPage vp = new LambdaTestValidationPage(driver);
        String expectedText = vp.contactUs.getText();
        String actualText = "Thanks for contacting us, we will get back to you shortly.";
        Assert.assertEquals(actualText,expectedText);
    }
    @Then("I enter all required data in form")
    public void i_enter_all_required_data_in_form(io.cucumber.datatable.DataTable dataTable) {
        Map<String,String> dataMap = dataTable.asMap();

        lthp = new LambdaTestInputFormPage(driver);
// retreiving  values from Data Table by keys
        String name = dataMap.get("name");
        System.out.println(name);
        lthp.name.sendKeys(name);

        String email = dataMap.get("email");
        System.out.println(email);
        lthp.email.sendKeys(email);

        String pWord = dataMap.get("password");
        System.out.println(pWord);
        lthp.password.sendKeys(pWord);

        String company = dataMap.get("company");
        System.out.println(company);
        lthp.company.sendKeys(company);

        String website = dataMap.get("website");
        System.out.println(website);
        lthp.website.sendKeys(website);

        String country = dataMap.get("country"); //dropdown
        System.out.println(country);
        Select countryDropDown = new Select(lthp.chooseCountry);
        countryDropDown.selectByVisibleText(country);

        String city = dataMap.get("city");
        System.out.println(city);
        lthp.city.sendKeys(city);

        String address1 = dataMap.get("address1");
        System.out.println(address1);
        lthp.address.sendKeys(address1);

        String address2 = dataMap.get("address2");
        System.out.println(address2);
        lthp.address2.sendKeys(address2);

        String state = dataMap.get("state");
        System.out.println(state);
        lthp.state.sendKeys(state);

        String zipCode = dataMap.get("zipCode");
        System.out.println(zipCode);
        lthp.zipCode.sendKeys(zipCode);

    }

}
