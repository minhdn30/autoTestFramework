package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PredictFramePage extends PageBase{
    public PredictFramePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/iframe")
    WebElement framePredict;
    //@FindBy(className = "main_content-question")
    @FindBy(xpath = "//*[@id=\"interac-box\"]/div/div/div[2]/div/div/div[1]")
    WebElement outputQuestion;
    @FindBy(id = "ans-0")
    WebElement outputAnsA;
    @FindBy(id = "ans-1")
    WebElement outputAnsB;
    @FindBy(id = "countAnswerInput")
    WebElement inputNumberOfPredicted;

    @FindBy(className = "btn-submit")
    WebElement buttonSendPredict;
    @FindBy(xpath = "/html/body/div/div/div/div/div[2]/div/div/div[1]/div[2]/span[1]")
    WebElement outputAnsAfter;
    @FindBy(xpath = "/html/body/div/div/div/div/div[2]/div/div/div[1]/div[2]/span[3]")
    WebElement outputNumberOfPredictedAfter;

    @FindBy(xpath = "/html/body/div/div/div/div/div[2]/div/div/div[2]/button/span")
    WebElement buttonPlayAgain;
    @FindBy(className = "img-hide")
    WebElement buttonHidden;


    public void checkOutputPredictFrame(String textQuestion, String textAnsA, String textAnsB) throws InterruptedException {
        driver.switchTo().frame(framePredict);
        Thread.sleep(1000);
        String outputTextQuestion = outputQuestion.getText();
        System.out.println(outputTextQuestion);
        Assert.assertEquals(outputTextQuestion, "1. " + textQuestion.toUpperCase());
        String outputTextAnsA = outputAnsA.getText();
        System.out.println(outputTextAnsA);
        Assert.assertEquals(outputTextAnsA, textAnsA.toUpperCase());
        String outputTextAnsB = outputAnsB.getText();
        System.out.println(outputTextAnsB);
        Assert.assertEquals(outputTextAnsB, textAnsB.toUpperCase());
    }
    public void checkPredict1(String numberOfPredicted, String textAnsA) throws InterruptedException {
        //gui so nguoi du doan la 100, nut gui du doan la disabled
        sendKeysText(inputNumberOfPredicted, numberOfPredicted);
        Assert.assertEquals(buttonSendPredict.isEnabled(),false, "buttonSendPredict is disabled 1");
        //xoa so nguoi du doan va chon dap an A, nut gui du doan van la disabled
        clearText(inputNumberOfPredicted);
        Thread.sleep(4000);
        clickButton(outputAnsA);
        //sai
        Assert.assertEquals(buttonSendPredict.isEnabled(),false, "buttonSendPredict is disabled 2");
        //gui so nguoi du doan va chon dap an A, nut gui du doan la enabled, co the click
        sendKeysText(inputNumberOfPredicted, numberOfPredicted);
        Assert.assertEquals(buttonSendPredict.isEnabled(),true);
        clickButton(buttonSendPredict);
        //check output hien ra sau khi gui dap an
        String outputAnsAAfterStr = outputAnsAfter.getText();
        System.out.println(outputAnsAAfterStr);
        Assert.assertEquals(outputAnsAAfterStr, textAnsA);
        String outputNumberOfPredictedAfterStr = outputNumberOfPredictedAfter.getText();
        System.out.println(outputNumberOfPredictedAfterStr);
        Assert.assertEquals(outputNumberOfPredictedAfterStr, numberOfPredicted);
        Thread.sleep(1000);
        clickButton(buttonPlayAgain);
    }
    public void sendPredict(String numberOfPredicted){
        clickButton(outputAnsB);
        sendKeysText(inputNumberOfPredicted, numberOfPredicted);
        clickButton(buttonSendPredict);
    }
    public void checkHiddenButton(String numberOfPredicted){
        driver.switchTo().frame(framePredict);
        sendPredict(numberOfPredicted);
        clickButton(buttonHidden);

    }

}
