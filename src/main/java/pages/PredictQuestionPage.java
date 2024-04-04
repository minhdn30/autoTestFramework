package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.Key;

import java.util.List;

public class PredictQuestionPage extends PageBase{
    public PredictQuestionPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[2]/div/div/div/div/div[1]/div[1]/div[2]/div/i")
    WebElement buttonChooseTemplate;
    @FindBy(xpath= "//div[text()='TemplatePredictValorant']")
    WebElement chooseTemplatePredictValorant;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[1]/div/div/div[1]/div/input")
    WebElement inputNameEvent;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[3]/div/div/div[1]/div/textarea")
    WebElement inputTextQuestion;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[4]/div/div/div[1]/div/input")
    WebElement inputTextAnsA;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[5]/div/div/div[1]/div/input")
    WebElement inputTextAnsB;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[6]/div/div/div[1]/div/input")
    WebElement inputTextOnG;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[2]/div[1]/div[2]/div[1]/div/div/div/div[1]/input")
    WebElement inputStreamerName;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[2]/div[1]/div[2]/div[2]/button/span/span")
    WebElement buttonAddStreamer;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[3]/div/button/span")
    WebElement buttonSave;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[5]/div/div/div[2]/div/button[1]/span")
    WebElement buttonConfirm;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[1]/div[1]/button[2]/span/span")
    WebElement buttonHappenning;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-1]")
    WebElement buttonConfirmFinishPredict;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[3]/main/div/div/div/div[2]/div/div[1]/div[1]/button[3]/span/span")
    WebElement buttonFinished;
   @FindBy(xpath = "(//div[@class='v-input--selection-controls__ripple'])")
   WebElement buttonChooseAnsA;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-1]")
    WebElement buttonConfirmSetAns;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-1]")
    WebElement buttonConfirmDeletePredict;
    public void clickButtonSendPredictQuestion(String eventName) {
        String xpath = String.format("//td[text()='%s']/following-sibling::td//button[contains(@class, 'primary--text')]", eventName);
        WebElement buttonSendLuckyNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        buttonSendLuckyNumber.click();
    }
    public void createAndSendPredictQuestion(String nameEvent, String textQuestion, String textAnsA, String textAnsB, String textOnG, String streamerName)
            throws InterruptedException {
        Thread.sleep(1000);
        sendKeysText(inputNameEvent, nameEvent);
        clickButton(buttonChooseTemplate);
        clickButton(chooseTemplatePredictValorant);
        sendKeysText(inputTextQuestion, textQuestion);
        sendKeysText(inputTextAnsA, textAnsA);
        sendKeysText(inputTextAnsB, textAnsB);
        Thread.sleep(500);
        action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        Thread.sleep(500);
        sendKeysText(inputStreamerName,streamerName);
        clickButton(buttonAddStreamer);
        sendKeysText(inputTextOnG, textOnG);
        clickButton(buttonSave);
        Thread.sleep(500);
        clickButtonSendPredictQuestion(nameEvent);
        Thread.sleep(500);
        clickButton(buttonConfirm);
    }
    public void clickPowerBtn(String eventName) throws InterruptedException {
        clickButton(buttonHappenning);
        String xpath = String.format("//td[text()='%s']/following-sibling::td//span[contains(@class, 'v-btn__content')]", eventName);
        Thread.sleep(1000);
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        WebElement buttonSendLuckyNumber = elements.get(1);
        clickButton(buttonSendLuckyNumber);
    }
    public void finishPredictAndSetAns(String eventName) throws InterruptedException {
        String xpath = String.format("//td[text()='%s']/following-sibling::td//span[contains(@class, 'v-btn__content')]", eventName);
        Thread.sleep(1000);
        List<WebElement> elementsHappenning = driver.findElements(By.xpath(xpath));
        WebElement finishPredict = elementsHappenning.get(2);
        clickButton(finishPredict);
        Thread.sleep(500);
        clickButton(buttonConfirmFinishPredict);
        Thread.sleep(500);
        clickButton(buttonFinished);
        Thread.sleep(1000);
        List<WebElement> elementsFinished = driver.findElements(By.xpath(xpath));
        WebElement setAnsPredict = elementsFinished.get(1);
        clickButton(setAnsPredict);
        Thread.sleep(500);
        clickButton(buttonChooseAnsA);
        clickButton(buttonConfirmSetAns);
        action = new Actions(driver);
        action.moveByOffset(0, 581).click().perform();
        Thread.sleep(500);
        clickButton(buttonFinished);
        List<WebElement> elementsFinished2 = driver.findElements(By.xpath(xpath));
        WebElement deletePredict = elementsFinished2.get(0);
        clickButton(deletePredict);
        Thread.sleep(500);
        clickButton(buttonConfirmDeletePredict);
    }
}
