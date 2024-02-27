package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

public class MatchManagePage extends PageBase{
    public MatchManagePage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[1]/div/div[2]/div/div[4]")
    WebElement buttonMatchManage;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[1]/button/span/span")
    WebElement buttonAddMatch;
    @FindBy(id = "tournament-match_form-name")
    WebElement inputTextMatchName;
    @FindBy(id = "tournament-match_form-ong")
    WebElement inputTextMatchOnG;
    @FindBy(id = "tournament-match_form-score")
    WebElement inputTextMatchScore;
    @FindBy(id = "tournament-match_form-team1")
    WebElement inputTextTeam1Name;
    @FindBy(id = "tournament-match_form-team2")
    WebElement inputTextTeam2Name;
    @FindBy(id = "tournament-match_form-time")
    WebElement buttonMatchTime;
    @FindBy(xpath = "//div[@class='v-btn__content' and text()='15']")
    WebElement buttonChooseDay15;
    @FindBy(xpath = "//span[@class='v-btn__content' and text()='OK']")
    WebElement buttonOKTime;
    @FindBy(className = "v-file-input__text")
    WebElement buttonLogoTeam1;
    @FindBy(xpath = "(//*[@class='v-file-input__text'])[last()]")
    WebElement buttonLogoTeam2;
    @FindBy(id = "tournament-match_form-submit_btn")
    WebElement buttonSaveMatch;
    public void createMatch(String matchName, String matchOnG, String matchScore, String matchTeam1Name,
                            String matchTeam2Name, String linkLogoTeam1, String linkLogoTeam2) throws InterruptedException {
        Thread.sleep(1000);
        clickButton(buttonMatchManage);
        Thread.sleep(500);
        clickButton(buttonAddMatch);
        Thread.sleep(500);
        sendKeysText(inputTextMatchName, matchName);
        sendKeysText(inputTextMatchOnG, matchOnG);
        sendKeysText(inputTextMatchScore, matchScore);
        sendKeysText(inputTextTeam1Name, matchTeam1Name);
        sendKeysText(inputTextTeam2Name, matchTeam2Name);
        clickButton(buttonMatchTime);
        Thread.sleep(500);
        clickButton(buttonChooseDay15);
        clickButton(buttonOKTime);
        Thread.sleep(500);
        clickButton(buttonLogoTeam1);
        Screen screen = new Screen();
        screen.type(linkLogoTeam1);
        screen.type(Key.ENTER);
        Thread.sleep(2000);
        clickButton(buttonLogoTeam2);
        Thread.sleep(2000);
        screen.type(linkLogoTeam2);
        screen.type(Key.ENTER);
        Thread.sleep(1000);
        clickButton(buttonSaveMatch);
    }
}
