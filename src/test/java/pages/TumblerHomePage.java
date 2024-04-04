package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TumblerHomePage {

    //constructor
    public TumblerHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@aria-label='Log in']") //or "//span[text()='Log in']parent::button
    //it has child class <span class="EvhBA" tabindex="-1">Log in</span>
    public WebElement loginButton;

    @FindBy(xpath = "//button[@aria-label='Continue with email']")
    public WebElement continueWithEmailButton;

    @FindBy(xpath = "//input[@aria-label='email']")
    public WebElement emailInputField;

    @FindBy(xpath = "//input [@name='password']")
    public WebElement passwordInputField;

    //    @FindBy(xpath = "//input [@name='password']")
//    public WebElement passwordInputField;
    @FindBy(xpath = "//*[text()='Your email or password were incorrect.']")
    public WebElement error;

}
