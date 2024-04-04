package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LambdaTestInputFormPage {
    public LambdaTestInputFormPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "name")
    public WebElement name;
    @FindBy(id = "inputEmail4")
    public WebElement email;
    @FindBy(id = "inputPassword4")
    public WebElement password;
    @FindBy(id = "company")
    public WebElement company;
    @FindBy(id = "websitename")
    public WebElement website;
    @FindBy(xpath = "//select[@name='country']") //OR name = "country"
    public WebElement chooseCountry;
    @FindBy(id = "inputCity")
    public WebElement city;
    @FindBy(id = "inputAddress1")
    public WebElement address;
    @FindBy(id = "inputAddress2")
    public WebElement address2;
    @FindBy(id = "inputState")
    public WebElement state;
    @FindBy(id = "inputZip")
    public WebElement zipCode;
    @FindBy(xpath = "//*[text() ='Submit']") //OR xpath = //button[text() = 'Submit']
    public WebElement submitButton;

}
