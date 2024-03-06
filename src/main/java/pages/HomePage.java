package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.Properties;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[3]/nav/div[1]/section/div[1]/div/div[5]/div")
    public WebElement buttonOperateOnlive;
    @FindBy(xpath = "//*[@id=\"app\"]/div/nav/div[1]/section/div[1]/div/div[5]/div[2]/a[6]")
    public WebElement buttonOpenMatchManage;
    @FindBy(xpath = "//p[. = 'Lucky number']/..")
    public WebElement buttonOpenLuckyNumber;
    public void openTournamentManager() throws InterruptedException {
        System.out.println(driver.getTitle());
        clickButton(buttonOperateOnlive);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        clickButton(buttonOpenMatchManage);
    }
    public void openLuckyNumber() throws InterruptedException {
        System.out.println(driver.getTitle());
        clickButton(buttonOperateOnlive);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        clickButton(buttonOpenLuckyNumber);
    }
}
