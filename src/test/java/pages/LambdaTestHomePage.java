package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LambdaTestHomePage {
    public LambdaTestHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[text() = 'Input Form Submit']") // OR linkText = "Input Form Submit"
    public WebElement inputFormSubmit;
}
