package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PredictQuestionManagePage extends PageBase{
    public PredictQuestionManagePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[1]/div/div[2]/div/div[8]")
    WebElement buttonPredictQuestionManage;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/form/div/div[1]/div/div/div/div/div[1]/div[1]/div[2]/div/i")
    WebElement buttonChooseTemplate;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/form/div/div[2]/div/div[2]/div/div/div[1]/div/textarea")
    WebElement inputTextQuestion;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/form/div/div[2]/div/div[3]/div[1]/div/div/div[1]/div/input")
    WebElement inputTextAnsA;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/form/div/div[2]/div/div[3]/div[2]/div/div/div[1]/div/input")
    WebElement inputTextAnsB;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/form/div/div[3]/div/div[2]/div/div[1]/div/input")
    WebElement inputTextOnG;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/form/div/div[5]/button/span")
    WebElement buttonSave;
    public void createPredictQuestion(String textQuestion, String textAnsA, String textAnsB, String textOnG)
            throws InterruptedException {
        Thread.sleep(1000);
        clickButton(buttonPredictQuestionManage);
        clickButton(buttonChooseTemplate);
        action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        sendKeysText(inputTextQuestion, textQuestion);
        sendKeysText(inputTextAnsA, textAnsA);
        sendKeysText(inputTextAnsB, textAnsB);
        sendKeysText(inputTextOnG, textOnG);
        Thread.sleep(500);
        clickButton(buttonSave);
    }
}
