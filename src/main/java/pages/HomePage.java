package pages;

import org.openqa.selenium.*;
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
    @FindBy(xpath = "//a[@href='/operation-tournament']")
    public WebElement buttonOpenMatchManage;
    @FindBy(xpath = "//p[. = 'Lucky number']/..")
    public WebElement buttonOpenLuckyNumber;
    @FindBy(xpath = "//a[@href='/operation-onlive-predict']")
    public WebElement buttonOpenPredict;

    public void openTournamentManager() throws InterruptedException {
        System.out.println(driver.getTitle());
        clickButton(buttonOperateOnlive);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        Thread.sleep(1000);
        clickButton(buttonOpenMatchManage);
    }
    public void openLuckyNumber() throws InterruptedException {
        System.out.println(driver.getTitle());
        clickButton(buttonOperateOnlive);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        Thread.sleep(1000);
        clickButton(buttonOpenLuckyNumber);
    }
    public void openPredict() throws InterruptedException {
        System.out.println(driver.getTitle());
        clickButton(buttonOperateOnlive);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        Thread.sleep(1000);
        clickButton(buttonOpenPredict);
    }
//    public void getToado(){;
//        Point location = buttonOpenPredict.getLocation();
//        int xCoordinate = location.getX();
//        int yCoordinate = location.getY();
//        System.out.println("Tọa độ của phần tử:");
//        System.out.println("X: " + xCoordinate);
//        System.out.println("Y: " + yCoordinate);
//    }
}
