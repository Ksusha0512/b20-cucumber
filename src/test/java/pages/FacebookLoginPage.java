package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {
    public FacebookLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='email']") //OR id='email"
    public WebElement emailFacebook;

    @FindBy(xpath = "//input[@type='password']") //OR id="pass"
    public WebElement passwordFacebook;

    @FindBy(xpath = "//button[@name='login']") //OR id="login"
    public WebElement logInButton;

    @FindBy(xpath = "//*[text()='The email you entered isn’t connected to an account. ']")
    public WebElement error;
}
