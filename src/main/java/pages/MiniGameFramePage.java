package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;

public class MiniGameFramePage extends PageBase{
    public MiniGameFramePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "live-interactive-iframe")
    WebElement miniGameFrame;
    @FindBy(className = "question-text")
    WebElement textQuestionDisplay;
    @FindBy(id = "0-answer1")
    WebElement buttonAnsA;
    @FindBy(id = "1-answer2")
    WebElement buttonAnsB;
    @FindBy(id = "2-answer3")
    WebElement buttonAnsC;

    public void switchToMiniGameFrame(){
        wait.until(ExpectedConditions.visibilityOf(miniGameFrame));
            driver.switchTo().frame(miniGameFrame);
    }

    public void checkOutputDisplay(String textQuestionExpected, String textInputAnsA, String textInputAnsB, String textInputAnsC){
        String getTextQuestionDisplay = textQuestionDisplay.getText();
        System.out.println(getTextQuestionDisplay);
        Assert.assertEquals(getTextQuestionDisplay, textQuestionExpected);
        getTextAns(buttonAnsA, textInputAnsA);
        getTextAns(buttonAnsB, textInputAnsB);
        getTextAns(buttonAnsC, textInputAnsC);
    }
    public void checkPercentByAcc1() throws InterruptedException {
        clickButton(buttonAnsA);
        Thread.sleep(5000);
        getPercent(buttonAnsA,"100%");
        getPercent(buttonAnsB,"0%");
        getPercent(buttonAnsC,"0%");
    }
    public void checkPercentByAcc2() throws InterruptedException {
        clickButton(buttonAnsB);
        Thread.sleep(5000);
        getPercent(buttonAnsA,"50%");
        getPercent(buttonAnsB,"50%");
        getPercent(buttonAnsC,"0%");
    }

    public void getTextAns(WebElement element, String textAnsExpected){
        String textAnsActual = element.getText().split("\n")[1];
        System.out.println(textAnsActual);
        Assert.assertEquals(textAnsActual, textAnsExpected);
    }
    public void getPercent(WebElement element, String percentExpected){
        String textPercentActual = element.getText().split("\n")[0];
        Assert.assertEquals(textPercentActual, percentExpected);
    }
}
