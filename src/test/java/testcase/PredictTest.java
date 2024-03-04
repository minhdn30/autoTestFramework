package testcase;
import base.TestBase;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import pages.*;

public class PredictTest extends TestBase {
    LoginCMSPage loginCMSPage;
    HomePage homePage;
    TournamentManagePage tournamentManagePage;
    MatchManagePage matchManagePage;
    PredictQuestionManagePage predictQuestionManagePage;
    ControlPage controlPage;
    StreamPage streamPage;
    PredictFramePage predictFramePage;
    @Test
    public void PredictTestCase() throws InterruptedException {
        loginCMSPage = new LoginCMSPage(driver);
        //open and login dev cms
        loginCMSPage.loginCMS(inp.getProperty("username_cms"), inp.getProperty("password_cms"));
        Thread.sleep(2000);
        String window1Handle = driver.getWindowHandle();
        homePage = new HomePage(driver);
        homePage.openTournamentManager();
        Thread.sleep(1000);
        //create and add tournament
        tournamentManagePage = new TournamentManagePage(driver);
        tournamentManagePage.createTournament(inp.getProperty("tournament_name"), inp.getProperty("streamer_name"));
        Thread.sleep(2000);
        //create and add match
        matchManagePage = new MatchManagePage(driver);
        matchManagePage.createMatch(inp.getProperty("match_name"), inp.getProperty("match_ong"), inp.getProperty("match_score"),
                inp.getProperty("matchteam1_name"), inp.getProperty("matchteam2_name"), inp.getProperty("linklogoteam1"),
                inp.getProperty("linklogoteam2"));
        Thread.sleep(1000);
        //create and add predict question
        predictQuestionManagePage = new PredictQuestionManagePage(driver);
        predictQuestionManagePage.createPredictQuestion(inp.getProperty("predict_question"), inp.getProperty("predict_ansa"),
                inp.getProperty("predict_ansb"), inp.getProperty("predict_ong"));
        Thread.sleep(1000);
        //send question to stream page
        controlPage = new ControlPage(driver);
        controlPage.sendPredictQuestion();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("testurl2"));
        String window2Handle = driver.getWindowHandle();
        //login onlive
        streamPage = new StreamPage(driver);
        streamPage.openAndLoginStreamPage(inp.getProperty("username_onlive"), inp.getProperty("password_onlive"));
        Thread.sleep(10000);
        //open predict frame
        streamPage.openPredictFrame();
        predictFramePage = new PredictFramePage(driver);
        predictFramePage.switchToPredictFrame();
        //check output
        predictFramePage.checkOutputPredictFrame(inp.getProperty("predict_question"), inp.getProperty("predict_ansa"),
                inp.getProperty("predict_ansb"));

        predictFramePage.checkPredict1(inp.getProperty("number_predicted"), inp.getProperty("predict_ansa"));
        //after click btn PlayAgain, check output again
        predictFramePage.checkOutputPredictFrame(inp.getProperty("predict_question"), inp.getProperty("predict_ansa"),
                inp.getProperty("predict_ansb"));
        predictFramePage.sendPredict(inp.getProperty("number_predicted"));
        //check after 7s, predict frame hidden or not
        streamPage.checkFramePredictDisplay();

        streamPage.openPredictFrame();
        predictFramePage.checkHiddenButton(inp.getProperty("number_predicted"));
        streamPage.checkFramePredictDisplay();
        //check status btn predict = normal
        // click btn power (cms) check status btn predict again
        //---> status = power
        streamPage.checkStatusPredictBtnBefore();
        switchWindow(window1Handle);
        controlPage.clickPoweBtn();
        switchWindow(window2Handle);
        Thread.sleep(1000);
        streamPage.checkStatusPredictBtnAfter();
        //finish predict question, set answer
        switchWindow(window1Handle);
        controlPage.finishPredictAndSetAns();
        //check btn predict hidden or not
        switchWindow(window2Handle);
        streamPage.checkBtnPredictDisplay();
        switchWindow(window1Handle);
        controlPage.finishPredictMatch();
        tournamentManagePage.deletePredictTournament();
        //driver.quit();

    }
    public void switchWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
        driver.switchTo().activeElement();
    }
}
