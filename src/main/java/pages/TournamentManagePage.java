package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TournamentManagePage extends PageBase {

    public TournamentManagePage(WebDriver driver) {
        super(driver);
    }

        @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/main/div/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]")
        WebElement buttonOpenTournamentManagePredict;
        @FindBy(xpath = "/html/body/div/div/div/div[1]/div[3]/main/div/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]")
        WebElement buttonOpenTournamentManageMiniGame;
        @FindBy(xpath = "/html/body/div/div/div/div[1]/div/main/div/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/button")
        WebElement buttonAddTournament;
        @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[1]/div/div/div[1]/div/input")
        WebElement inputTextTournamentName;
        @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[4]/div/div/div/form/div[2]/div/button")
        WebElement buttonSaveTournament;
        @FindBy(className ="mdi-list-box-outline")
        WebElement buttonViewDetailTournament;
        @FindBy(xpath = "/html/body/div/div/div/div[1]/div[4]/div/div/div/div[1]/button/span")
        WebElement buttonEditTournament;
        @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[4]/div/div/div/form/div[2]/div[1]/div[2]/div/div/div/div[1]/input")
        WebElement inputTextStreamerName;
        @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[4]/div/div/div/form/div[2]/div[1]/div[3]/button/span/span")
        WebElement buttonAddStreamer;
        @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[4]/div/div/div/form/div[3]/div/button/span")
        WebElement buttonSaveDetailTournament;
//        @FindBy(xpath = "//td[text()='Minh Test 1']/following-sibling::td[@class='text-center']//span[@class='v-btn__content']/i[@class='v-icon notranslate material-icons theme--light' and text()='delete']")
//        WebElement buttonDeleteTour;

        @FindBy(xpath = "(//span[@class='v-btn__content'])[last()-1]")
        WebElement buttonConfirmDeleteTour;
        public void clickButtonDeteleTour(String tournamentName) {
            String xpath = String.format("//td[text()='%s']/following-sibling::td[@class='text-center']//span[@class='v-btn__content']/i[@class='v-icon notranslate material-icons theme--light' and text()='delete']", tournamentName);
            WebElement buttonSendLuckyNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            buttonSendLuckyNumber.click();
        }
        public void createTournament(String nameOfTournament, String nameOfStreamer) throws InterruptedException {
            Thread.sleep(500);
            clickButton(buttonAddTournament);
            Thread.sleep(500);
            sendKeysText(inputTextTournamentName, nameOfTournament);
            clickButton(buttonSaveTournament);
            Thread.sleep(1000);
            clickButton(buttonViewDetailTournament);
            Thread.sleep(500);
            clickButton(buttonEditTournament);
            Thread.sleep(500);
            sendKeysText(inputTextStreamerName, nameOfStreamer);
            clickButton(buttonAddStreamer);
            Thread.sleep(500);
            clickButton(buttonSaveDetailTournament);
        }
        public void deletePredictTournament(String tournamentName) throws InterruptedException {
            clickButton(buttonOpenTournamentManagePredict);
            Thread.sleep(1000);
            clickButtonDeteleTour(tournamentName);
            Thread.sleep(1000);
            clickButton(buttonConfirmDeleteTour);
            //
            Thread.sleep(3000);
        }
    public void deleteMiniGameTournament(String tournamentName) throws InterruptedException {
        clickButton(buttonOpenTournamentManageMiniGame);
        Thread.sleep(1000);
        clickButtonDeteleTour(tournamentName);
        Thread.sleep(1000);
        clickButton(buttonConfirmDeleteTour);
        //
        Thread.sleep(3000);
    }
}
