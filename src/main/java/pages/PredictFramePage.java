package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PredictFramePage extends PageBase{
    public PredictFramePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/iframe")
    WebElement predictFrame;
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
   public void switchToPredictFrame(){
       driver.switchTo().frame(predictFrame);
   }

    public void checkOutputPredictFrame(String textQuestion, String textAnsA, String textAnsB) throws InterruptedException {
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
        //number of predicted = 100, btn sendPredict is disabled
        sendKeysText(inputNumberOfPredicted, numberOfPredicted);
        Assert.assertFalse(buttonSendPredict.isEnabled(), "buttonSendPredict is disabled 1");
        //clear number of predicted, choose Ans A, btn sendPredict is disabled
        //clearText(inputNumberOfPredicted); //error
        inputNumberOfPredicted.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        Thread.sleep(500);
        clickButton(outputAnsA);
        Assert.assertFalse(buttonSendPredict.isEnabled(), "buttonSendPredict is disabled 2");
        //number of predicted = 100, choose Ans A, btn sendPredict is enabled
        sendKeysText(inputNumberOfPredicted, numberOfPredicted);
        Assert.assertTrue(buttonSendPredict.isEnabled());
        clickButton(buttonSendPredict);
        //check output after send predict
        Thread.sleep(1000);
        String outputAnsAAfterStr = outputAnsAfter.getText();
        System.out.println(outputAnsAAfterStr +"2");
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
        driver.switchTo().frame(predictFrame);
        sendPredict(numberOfPredicted);
        clickButton(buttonHidden);

    }

}
