package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JSPractice2ClickScrollScreenshot {
    @Test
    public void ClickScrollScreenshot1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://codingbat.com/prob/p161642");
        WebElement clickElement = driver.findElement(By.xpath("//button[@class='gray']"));
       //click element with JavaScript
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click()", clickElement);
        //scroll down page with JavaScript
        WebElement codeBadge = driver.findElement(By.xpath("//a [@href='/doc/practice/code-badges.html']"));
        JavascriptExecutor js11 = (JavascriptExecutor) driver;
        js11.executeScript("arguments[0].scrollIntoView(true)",codeBadge);
        //take a screenshot
        BrowserUtils.takeScreenshot(driver);
    }
    @Test
    public void ClickScrollScreenshot2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/");
        //click element
        WebElement dynamicContent = driver.findElement(By.xpath("//a [@href='/dynamic_content'] "));
        BrowserUtils.clickElement(driver,dynamicContent);
        //scroll element
        WebElement seleniumElemental = driver.findElement(By.xpath("//a[@target='_blank']"));
        BrowserUtils.scrolltoElement(driver,seleniumElemental);
        //screenshot
        BrowserUtils.takeScreenshot(driver);
    }
@Test
    public void ClickScrollScreenshot3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.lambdatest.com/");
        WebElement enterprise = driver.findElement(By.xpath("//a[@href='https://accounts.lambdatest.com/login']"));
        BrowserUtils.clickElement(driver,enterprise);
        WebElement contactUs = driver.findElement(By.xpath("//a[@href='https://www.lambdatest.com/contact-us']"));
        BrowserUtils.takeScreenshot(driver);
}
@Test
    public void ClickScrollScreenshot4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.academia.edu/16606633/CJava_Introducing_Concurrent_Objects_in_Java");
        WebElement academia = driver.findElement(By.linkText("A structured approach for developing concurrent programs in Java"));
        BrowserUtils.clickElement(driver,academia);
        WebElement moreDocuments = driver.findElement(By.xpath("//p[@class='ds-body-sm-regular js-wsj-grid-card-title js-related-work-grid-card-title']"));
        BrowserUtils.scrolltoElement(driver,moreDocuments);
        BrowserUtils.takeScreenshot(driver);
}
}
