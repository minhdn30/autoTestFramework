package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuestionManagePage extends PageBase{
    public QuestionManagePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[1]/div/div[2]/div/div[3]")
    WebElement buttonQuestionManage;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/form/div/div[1]/div/div/div/div/div[1]/div[1]/div[2]/div/i")
    WebElement buttonChooseTemplate;
    @FindBy(xpath = "//div[text()='OnlivePercentV2']")
    WebElement buttonChooseOnlivePercentV2;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/form/div/div[5]/div/div[2]/div/div/div[1]/div/textarea")
    WebElement inputTextQuestion;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/form/div/div[5]/div/div[3]/div[1]/div/div/div[1]/div/input")
    WebElement inputTextAnsA;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/form/div/div[5]/div/div[3]/div[2]/div/div/div[1]/div/input")
    WebElement inputTextAnsB;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/form/div/div[5]/div/div[3]/div[3]/div/div/div[1]/div/input")
    WebElement inputTextAnsC;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/form/div/div[6]/div/div[2]/div/div[1]/div/input")
    WebElement inputTextTime;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/form/div/div[7]/button/span")
    WebElement buttonSave;
    public void createMiniGameQuestion(String textQuestion, String textAnsA, String textAnsB,
                                       String textAnsC, String textTime) throws InterruptedException {
        clickButton(buttonQuestionManage);
        clickButton(buttonChooseTemplate);
        clickButton(buttonChooseOnlivePercentV2);
        sendKeysText(inputTextQuestion, textQuestion);
        sendKeysText(inputTextAnsA, textAnsA);
        sendKeysText(inputTextAnsB, textAnsB);
        sendKeysText(inputTextAnsC, textAnsC);
        inputTextTime.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);
        sendKeysText(inputTextTime, textTime);
        clickButton(buttonSave);
        Thread.sleep(500);
    }
}
