package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LuckyNumberPage extends PageBase {
    public LuckyNumberPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "action-table")
    WebElement buttonAddNew;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[1]/div/div/div[1]/div/input")
    WebElement inputName;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[6]/div/div/div[1]/div/input")
    WebElement inputOnG;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[2]/div[1]/div[2]/div[1]/div/div/div/div[1]/input")
    WebElement inputStreamer;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[2]/div/div/div/div/div[1]/div[1]/div[2]")
    WebElement buttonChooseTemp;
    @FindBy(xpath = "//*[text()='Template Lucky Number']")
    WebElement chooseTempLuckyNumber;
    @FindBy(xpath = "//input[@min='1' and @max='8']")
    WebElement cellNumber;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[8]/div/div/div/div/div/div[1]/div/input")
    WebElement setLuckyNumber;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[8]/div/div/button/span")
    WebElement addLuckyNumber;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[2]/div[1]/div[2]/div[2]/button/span/span")
    WebElement buttonAddEvent;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[3]/div/button")
    WebElement buttonSave;
//    @FindBy(xpath = "//td[text()='%s']/following-sibling::td//button[contains(@class, 'primary--text')]")
//    WebElement buttonSendLuckyNumber;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[5]/div/div/div[2]/div/button[1]")
    WebElement buttonConfirm;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div[1]/div[1]/button[2]/span/span")
    WebElement buttonHappenning;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-1]")
    WebElement buttonConfirmFinish;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[3]/main/div/div/div/div[2]/div[1]/div[1]/button[3]/span/span")
    WebElement buttonFinished;
    @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-1]")
    WebElement buttonConfirmDeleteLuckyNumber;

    public void clickButtonSendLuckyNumber(String eventName) {
        String xpath = String.format("//td[text()='%s']/following-sibling::td//button[contains(@class, 'primary--text')]", eventName);
        WebElement buttonSendLuckyNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        buttonSendLuckyNumber.click();
    }
    public void createAndSendEvent (String eventName, String eventOnG, String eventCellNumber, String luckyNumber, String streamerName) throws InterruptedException {
        clickButton(buttonAddNew);
        sendKeysText(inputName, eventName);
        sendKeysText(inputOnG, eventOnG);
        cellNumber.sendKeys(Keys.BACK_SPACE);
        sendKeysText(cellNumber, eventCellNumber);
        sendKeysText(setLuckyNumber, luckyNumber);
        clickButton(addLuckyNumber);
        sendKeysText(inputStreamer, streamerName);
        clickButton(buttonChooseTemp);
//        action.sendKeys(Keys.ARROW_UP, Keys.ENTER).perform();
        clickButton(chooseTempLuckyNumber);
        clickButton(buttonAddEvent);
        action = new Actions(driver);
        action.sendKeys(Keys.CONTROL, Keys.END).perform();
        clickButton(buttonSave);
        clickButtonSendLuckyNumber(eventName);
        Thread.sleep(1000);
        clickButton(buttonConfirm);
    }
    public void finishLuckyNumber(String eventName) throws InterruptedException {
        clickButton(buttonHappenning);
        Thread.sleep(1000);
        String xpath = String.format("//td[text()='%s']/following-sibling::td//span[contains(@class, 'v-btn__content')]", eventName);
        Thread.sleep(1000);
        List<WebElement> elementsHappenning = driver.findElements(By.xpath(xpath));
        WebElement finishLuckyNumber = elementsHappenning.get(2);
        clickButton(finishLuckyNumber);
        Thread.sleep(500);
        clickButton(buttonConfirmFinish);
        Thread.sleep(500);
        clickButton(buttonFinished);
        Thread.sleep(1000);
        WebElement deleteEventLuckyNumber = driver.findElement(By.xpath(xpath));
        clickButton(deleteEventLuckyNumber);
        Thread.sleep(500);
        clickButton(buttonConfirmDeleteLuckyNumber);
    }
}