package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[3]/nav/div[1]/section/div[1]/div/div[5]/div")
    public WebElement buttonOperateOnlive;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/nav/div[1]/section/div[1]/div/div[5]/div[2]/a[6]")
    public WebElement buttonOpenMatchManage;
    public void openTournamentManager() throws InterruptedException {
        System.out.println(driver.getTitle());
        clickButton(buttonOperateOnlive);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        clickButton(buttonOpenMatchManage);
    }
}
