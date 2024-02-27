package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ControlPage extends PageBase{
    public ControlPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[1]/div/div[2]/div/div[7]/span")
    WebElement buttonControl;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/div[1]/div/div[1]/div/button/span/i")
    WebElement buttonAddQuestion;

    @FindBy(xpath = "(//div[@class='v-input--selection-controls__ripple'])[2]")
    WebElement checkBoxAddQuestion;
    @FindBy(className = "v-btn__content")
    List<WebElement> checkBoxes;
    @FindBy(xpath = "//*[@id=\"app\"]/div[9]/div/div/div/div[2]/div/button/span")
    WebElement buttonSaveAddQuestion;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div/div/div/table/tbody/tr/td[4]/div/div/button[3]/span/i")
    WebElement buttonSendQuestion;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div/div/div/table/tbody/tr/td[4]/div/button[3]")
    WebElement buttonPower;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div/div/div/table/tbody/tr/td[4]/div/button[1]")
    WebElement buttonFinishPredict;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[77]") //the span?
    WebElement buttonConfirm;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[68]") //the span?
    WebElement buttonSetAns;
    @FindBy(xpath = "(//span[@class='v-input--selection-controls__ripple'])[1]") //the span?
    WebElement buttonChooseAnsA;
    @FindBy(className = "buttonSubmit")
    WebElement buttonConfirmAns;
    @FindBy(xpath = "(//span[@class='v-size--default'])[4]") //the span?
    WebElement buttonFinishMatch;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[75]") //the span?
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
    public void clickPoweBtn(){
        clickButton(buttonPower);
    }
    public void finishPredictAndSetAns() throws InterruptedException {
        clickButton(buttonFinishPredict);
        Thread.sleep(1000);
        clickButton(buttonConfirm);
        Thread.sleep(1000);
        clickButton(buttonSetAns);
        Thread.sleep(1000);
        clickButton(buttonChooseAnsA);
        clickButton(buttonConfirmAns);
    }
    public void finishMatch() throws InterruptedException {
        clickButton(buttonFinishMatch);
        Thread.sleep(1000);
        clickButton(buttonConfirmFinishMatch);
    }

}
