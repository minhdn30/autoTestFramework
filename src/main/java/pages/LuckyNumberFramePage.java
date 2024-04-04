package pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LuckyNumberFramePage extends PageBase {
    public LuckyNumberFramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/iframe")
    WebElement luckyNumberFrame;
    @FindBy(className = "button-play")
    WebElement buttonPlayLuckyNumber;
    @FindBy(id = "door1")
    WebElement door1;
    @FindBy(id = "door2")
    WebElement door2;
    @FindBy(id = "door3")
    WebElement door3;
    @FindBy(id = "door4")
    WebElement door4;
    @FindBy(id = "door5")
    WebElement door5;
    @FindBy(id = "door6")
    WebElement door6;
    @FindBy(id = "door7")
    WebElement door7;
    @FindBy(id = "door8")
    WebElement door8;
    @FindBy(className = "icon-history")
    WebElement buttonHistory;
    @FindBy(xpath = "/html/body/div/div/div/div[4]/div/div/div[2]/div[3]/span")
    WebElement mostRecentHistory;
    @FindBy(className = "footer-your-result-number")
    WebElement totalNumberSpins;
    @FindBy(xpath = "(//span[@class='footer-your-result-number'])[2]")
    WebElement yourMaxResult;
    String instanceOutput ="";
    String firstOutput = "";
    String secondOutput = "";
    String thirdOutput = "";
    int max = 0;

    public void switchToLuckyNumberFrame() {
        driver.switchTo().frame(luckyNumberFrame);
    }

    public void playLuckyNumber() throws InterruptedException {
        clickButton(buttonPlayLuckyNumber);
        Thread.sleep(10000);
        String output = "";
        for (int i = 0; i < 8; i++) {
            int j = i + 1;
            WebElement outputDoor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("door" + j)));
            output += outputDoor.getText();
        }
        System.out.println(output);
        instanceOutput = output;
    }
    public void firstCheck() throws InterruptedException {
        firstOutput = instanceOutput;
        String totalNumberSpinsStr = totalNumberSpins.getText();
        Assert.assertEquals(totalNumberSpinsStr, "#1");
        String yourMaxResultStr = yourMaxResult.getText();
        Assert.assertEquals(yourMaxResultStr, firstOutput);
        clickButton(buttonHistory);
        Thread.sleep(1000);
        String mostRecentHistoryStr = mostRecentHistory.getText();
        System.out.println("mostRecentHistory: " + mostRecentHistoryStr);
        Assert.assertEquals(mostRecentHistoryStr,firstOutput);
    }
    public void secondCheck() throws InterruptedException {
        secondOutput = instanceOutput;
        String totalNumberSpinsStr = totalNumberSpins.getText();
        Assert.assertEquals(totalNumberSpinsStr, "#2");
        String yourMaxResultStr = yourMaxResult.getText();
        int firstNumber = Integer.parseInt(firstOutput);
        int secondNumber = Integer.parseInt(secondOutput);
        if(secondNumber > firstNumber){
            Assert.assertEquals(yourMaxResultStr, secondOutput);
        } else {
            Assert.assertEquals(yourMaxResultStr, firstOutput);
        }
        clickButton(buttonHistory);
        Thread.sleep(1000);
        String mostRecentHistoryStr = mostRecentHistory.getText();
        System.out.println("mostRecentHistory: " + mostRecentHistoryStr);
        Assert.assertEquals(mostRecentHistoryStr,secondOutput);
    }
    public void thirdCheck() throws InterruptedException {
        thirdOutput = instanceOutput;
        String totalNumberSpinsStr = totalNumberSpins.getText();
        Assert.assertEquals(totalNumberSpinsStr, "#3");
        String yourMaxResultStr = yourMaxResult.getText();
        int yourMaxResultNumber = Integer.parseInt(yourMaxResultStr);
        int firstNumber = Integer.parseInt(firstOutput);
        int secondNumber = Integer.parseInt(secondOutput);
        int thirdNumber = Integer.parseInt(thirdOutput);

        max = findMax(firstNumber,secondNumber,thirdNumber);
        Assert.assertEquals(max, yourMaxResultNumber);
        clickButton(buttonHistory);
        Thread.sleep(1000);
        String mostRecentHistoryStr = mostRecentHistory.getText();
        System.out.println("mostRecentHistory: " + mostRecentHistoryStr);
        Assert.assertEquals(mostRecentHistoryStr,thirdOutput);
    }
    public int findMax(int first, int second, int third) {
        max = Math.max(Math.max(first, second),third);
        System.out.println("max: " + max);
        return max;
    }
}
