package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ControlPage extends PageBase{
    public ControlPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[1]/div/div[2]/div/div[7]/span")
    WebElement buttonControl;
    //predict question
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/div[1]/div/div[1]/div/button/span/i")
    WebElement buttonAddPredictQuestion;
    @FindBy(xpath = "(//div[@class='v-input--selection-controls__ripple'])[2]")
    WebElement checkBoxAddPredictQuestion;
    @FindBy(className = "v-btn__content")
    List<WebElement> checkBoxes;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-1]")
    WebElement buttonSaveAddPredictQuestion;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div/div/div/table/tbody/tr/td[4]/div/div/button[3]/span/i")
    WebElement buttonSendPredictQuestion;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div/div/div/table/tbody/tr/td[4]/div/button[3]")
    WebElement buttonPower;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div/div/div/table/tbody/tr/td[4]/div/button[1]")
    WebElement buttonFinishPredict;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-1]")
    WebElement buttonConfirmFinishPredict;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-6]")
    WebElement buttonSetAnsPredict;
    @FindBy(xpath = "(//div[@class='v-input--selection-controls__ripple'])[1]")
    WebElement buttonChooseAnsAPredict;
    @FindBy(className = "buttonSubmit")
    WebElement buttonConfirmAnsPredict;
    //question
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[4]/div/div/div[3]/div[2]/div/div[2]/div/div[1]/div/button/span/i")
    WebElement buttonAddQuestion;
    @FindBy(xpath = "(//div[@class='v-input--selection-controls__ripple'])[last()]")
    WebElement checkBoxAddQuestion;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-1]")
    WebElement buttonSaveAddQuestion;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[4]/div/div/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div/table/tbody/tr/td[4]/div/div/button[3]/span/i")
    WebElement buttonSendQuestion;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-2]") //the span, 74?
    WebElement buttonSetAnsMiniGame;
    @FindBy(xpath = "(//div[@class='v-input--selection-controls__ripple'])[last()-1]")
    WebElement buttonChooseAnsAMiniGame;
    @FindBy(className = "buttonSubmit")
    WebElement buttonConfirmAnsMiniGame;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-7]")
    WebElement buttonFinishPredictMatch;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-6]")
    WebElement buttonFinishMiniGameMatch;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-1]")
    WebElement buttonConfirmFinishMatch;
    public void sendPredictQuestion() throws InterruptedException {
        clickButton(buttonControl);
        Thread.sleep(1000);
        clickButton(buttonAddPredictQuestion);
        Thread.sleep(2000);
        clickButton(checkBoxAddPredictQuestion);
        Thread.sleep(1000);
        clickButton(buttonSaveAddPredictQuestion);
        Thread.sleep(500);
        clickButton(buttonSendPredictQuestion);
    }
    public void clickPoweBtn(){
        clickButton(buttonPower);
    }
    public void finishPredictAndSetAns() throws InterruptedException {
        clickButton(buttonFinishPredict);
        Thread.sleep(1000);
        clickButton(buttonConfirmFinishPredict);
        Thread.sleep(1000);
        clickButton(buttonSetAnsPredict);
        Thread.sleep(1000);
        clickButton(buttonChooseAnsAPredict);
        clickButton(buttonConfirmAnsPredict);
    }
    public void sendQuestion() throws InterruptedException {
        clickButton(buttonControl);
        Thread.sleep(1000);
        clickButton(buttonAddQuestion);
        Thread.sleep(2000);
        clickButton(checkBoxAddQuestion);
        clickButton(buttonSaveAddQuestion);
        Thread.sleep(500);
        clickButton(buttonSendQuestion);
    }
    public void finishMiniGameAndSetAns() throws InterruptedException {
        clickButton(buttonSetAnsMiniGame);
        Thread.sleep(1000);
        clickButton(buttonChooseAnsAMiniGame);
        clickButton(buttonConfirmAnsMiniGame);
    }
    public void finishPredictMatch() throws InterruptedException {
        clickButton(buttonFinishPredictMatch);
        Thread.sleep(1000);
        clickButton(buttonConfirmFinishMatch);
    }
    public void finishMiniGameMatch() throws InterruptedException {
        clickButton(buttonFinishMiniGameMatch);
        Thread.sleep(1000);
        clickButton(buttonConfirmFinishMatch);
    }


}
