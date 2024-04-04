package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class BrowserUtils {

    //click element with JavascriptExecutor
    public static void clickElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver; // casting Java to dropdown executor
        js.executeScript("arguments[0].click()", element);

    }

    //scrolling to element
    public static void scrolltoElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void takeScreenshot(WebDriver driver) {
        //taking screenshot
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //take a screenshot

        //saving screenshot
        String location = System.getProperty("user.dir") + "/src/test/screenshots/";
        File directory = new File(location);
        if (!directory.exists()) {               //if the directory does not exist
            directory.mkdir();                   //create it
        }
        try {
            FileUtils.copyFile(file, new File(location + System.currentTimeMillis() + ".png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
