package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[2]/div[1]/div[2]/div[2]/button/span/span")
    WebElement buttonAddEvent;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/form/div[3]/div/button")
    WebElement buttonSave;
//    @FindBy(xpath = "//td[text()='%s']/following-sibling::td//button[contains(@class, 'primary--text')]")
//    WebElement buttonSendLuckyNumber;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[5]/div/div/div[2]/div/button[1]")
    WebElement buttonConfirm;

    public void clickButtonSendLuckyNumber(String eventName) {
        String xpath = String.format("//td[text()='%s']/following-sibling::td//button[contains(@class, 'primary--text')]", eventName);
        WebElement buttonSendLuckyNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        buttonSendLuckyNumber.click();
    }
    public void createAndSendEvent (String eventName, String eventOnG, String streamerName) throws InterruptedException {
        clickButton(buttonAddNew);
        sendKeysText(inputName, eventName);
        sendKeysText(inputOnG, eventOnG);
        sendKeysText(inputStreamer, streamerName);
        clickButton(buttonChooseTemp);
        action = new Actions(driver);
        action.sendKeys(Keys.ARROW_UP, Keys.ENTER).perform();
        clickButton(buttonAddEvent);
        action.sendKeys(Keys.CONTROL, Keys.END).perform();
        clickButton(buttonSave);
        clickButtonSendLuckyNumber(eventName);
        Thread.sleep(1000);
        clickButton(buttonConfirm);

    }
}