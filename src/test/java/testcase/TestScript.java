package testcase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.sikuli.script.*;

public class TestScript {
    ChromeDriver chromeDriver;

    @BeforeMethod
    public void Setup() {
        //mo OBS set up va phat luong
        //test moi truong dev : connect VPN
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
    }
    @Test
    public void autoTestLuckyNumber() {
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
        Actions actions = new Actions(chromeDriver);

        chromeDriver.get("https://dev-interactive.onplay.live/operation-onlive-lucky-number");
        String window1Handle = chromeDriver.getWindowHandle();

        WebElement textUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/div/main/div/div/div/div/div/div/form/div/div[1]/form/div[2]/div/div/div/div/input")));
        textUsername.sendKeys("minhdn");

        WebElement textPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/div/main/div/div/div/div/div/div/form/div/div[1]/form/div[3]/div/div/div/div/input")));
        textPassword.sendKeys("vtvlive@123");

        WebElement buttonLoginSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-login")));
        buttonLoginSubmit.submit();
        WebElement buttonVanHanhOnlive = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[3]/nav/div[1]/section/div[1]/div/div[5]/div")));
        buttonVanHanhOnlive.click();

        actions.moveToElement(buttonVanHanhOnlive);
        chromeDriver.manage().window().maximize();
        chromeDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        sleep(500);
        WebElement buttonMucLuckyNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[. = 'Lucky number']/..")));
        buttonMucLuckyNumber.click();
        chromeDriver.manage().window().maximize();
        WebElement buttonAddNew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("action-table")));
        buttonAddNew.click();
        WebElement inputName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[1]/div/div/div[1]/div/input")));
        inputName.sendKeys("Minh Test");
        WebElement inputOnG = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[6]/div/div/div[1]/div/input")));
        inputOnG.sendKeys("0");
        WebElement inputStreamer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[2]/div[1]/div[2]/div[1]/div/div/div/div[1]/input")));
        inputStreamer.sendKeys("minhdn211002");
        WebElement buttonChooseTemp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[2]/div/div/div/div/div[1]/div[1]/div[2]")));
        buttonChooseTemp.click();
        actions.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
        WebElement buttonAddEvent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[2]/div[1]/div[2]/div[2]/button/span/span")));
        buttonAddEvent.click();
        actions.sendKeys(Keys.CONTROL, Keys.END).perform();
        WebElement buttonSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[3]/div/button")));
        buttonSave.click();
        WebElement buttonOpenLuckyNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Minh Test']/following-sibling::td//button[contains(@class, 'primary--text')]")));
        buttonOpenLuckyNumber.click();
        sleep(1000);
        WebElement buttonConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[5]/div/div/div[2]/div/button[1]")));
        buttonConfirm.click();
        chromeDriver.switchTo().newWindow(WindowType.WINDOW);
        ((ChromeDriver) chromeDriver).executeScript("window.open('https://play.onlive.vn/minhdn211002/86876');");

        Set<String> handles = chromeDriver.getWindowHandles();
        for (String handle : handles) {
            chromeDriver.switchTo().window(handle);

            if (chromeDriver.getTitle().equals("minhdn211002 | ON Live")) {
                String window2Handle = chromeDriver.getWindowHandle();
                sleep(1000);
                WebElement buttonLoginAcc2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-login")));
                buttonLoginAcc2.click();

                WebElement textUsername2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
                textUsername2.sendKeys("aftv_onlive062");

                WebElement textPassword2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
                textPassword2.sendKeys("Onlive#2023");

                WebElement buttonLoginSubmit2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-danger")));
                buttonLoginSubmit2.submit();

                WebElement buttonPlay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/div[11]/dl/dd[2]")));
                buttonPlay.click();

                WebElement buttonHere = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div[28]/div/span/a/span")));
                buttonHere.click();
                WebElement buttonLuckyNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"afreecatv_player\"]/div[25]/div")));
                buttonLuckyNumber.click();
                WebElement frameLuckyNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/iframe")));
                chromeDriver.switchTo().frame(frameLuckyNumber);
                WebElement buttonPlayLuckyNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("button-play")));
                buttonPlayLuckyNumber.click();
                sleep(10000);
                WebElement outputDoor1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("door1")));
                String door1Str = outputDoor1.getText();
                WebElement outputDoor2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("door2")));
                String door2Str = outputDoor2.getText();
                WebElement outputDoor3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("door3")));
                String door3Str = outputDoor3.getText();
                WebElement outputDoor4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("door4")));
                String door4Str = outputDoor4.getText();
                WebElement outputDoor5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("door5")));
                String door5Str = outputDoor5.getText();
                WebElement outputDoor6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("door6")));
                String door6Str = outputDoor6.getText();
                WebElement outputDoor7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("door7")));
                String door7Str = outputDoor7.getText();
                WebElement outputDoor8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("door8")));
                String door8Str = outputDoor8.getText();
                String output = door1Str + door2Str + door3Str + door4Str + door5Str + door6Str + door7Str + door8Str;
                System.out.println(output);
                WebElement buttonHistory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("icon-history")));
                buttonHistory.click();
                sleep(1000);
                WebElement mostRecentHistory = chromeDriver.findElements(By.className("text-table-his")).get(2);
                String mostRecentHistoryStr = mostRecentHistory.getText();
                System.out.println(mostRecentHistoryStr);
                Assert.assertEquals(output, mostRecentHistoryStr);

            }
        }
    }
    private void sleep(int time){
        try{
            Thread.sleep(time);
        } catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
    }
    @AfterMethod
    public void CleanUp() {
    }
}