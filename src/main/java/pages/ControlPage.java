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
    //question
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-2]")
    WebElement buttonAddQuestion;
    @FindBy(xpath = "(//div[@class='v-input--selection-controls__ripple'])[last()]")
    WebElement checkBoxAddQuestion;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-1]")
    WebElement buttonSaveAddQuestion;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[4]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div/div/div/table/tbody/tr/td[4]/div/div/button[3]/span/i")
    WebElement buttonSendQuestion;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-2]") //the span, 74?
    WebElement buttonSetAnsMiniGame;
    @FindBy(xpath = "(//div[@class='v-input--selection-controls__ripple'])[last()-1]")
    WebElement buttonChooseAnsAMiniGame;
    @FindBy(className = "buttonSubmit")
    WebElement buttonConfirmAnsMiniGame;
    @FindBy(xpath = "//div[contains(@class, 'justify-start')]//button//span[contains(@class, 'v-btn__content')]")
    WebElement buttonFinishMatch;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-1]")
    WebElement buttonConfirmFinishMatch;
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
    public void finishMatch() throws InterruptedException {
        clickButton(buttonFinishMatch);
        Thread.sleep(1000);
        clickButton(buttonConfirmFinishMatch);
    }



}
