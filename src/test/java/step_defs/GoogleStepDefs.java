package step_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleStepDefs {
    WebDriver driver;


    @Given("I on google home page")
    public void i_on_google_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //navigate to google page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://google.com");

    }

    @When("I search for Codefish")
    public void i_search_for_codefish() {
        WebElement searchField = driver.findElement(By.name("q")); //xpath //textarea[@name=' q']"
        searchField.sendKeys("Codefish" + Keys.ENTER);
        //locator //div[@id='result-stats'] or #result-stats
        WebElement results = driver.findElement(By.cssSelector("#result-stats"));
        String resultTest = results.getText();
        System.out.println(resultTest);

    }

    @Then("i should get results")
    public void i_should_get_results() {

    }


}
