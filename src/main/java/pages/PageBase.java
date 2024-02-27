package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class PageBase {
    protected static WebDriver driver;
    public JavascriptExecutor jse;
    public Select select;
    public Actions action;
    public static WebDriverWait wait;
    //create constructor
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }
    protected static void clickButton(WebElement button)
    {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(button)).click();
    }
    protected static void sendKeysText(WebElement textElement,String value)
    {
        wait.until(ExpectedConditions.visibilityOf(textElement)).sendKeys(value);
    }
    public void scrollToBottom()
    {
        jse.executeScript("scrollBy(0,2500)");
    }
    public void clearText(WebElement element)
    {
        element.clear();
    }
}