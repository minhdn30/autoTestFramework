package testcase;
import base.TestBase;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
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
        loginCMSPage.loginCMS(inp.getProperty("username_cms"), inp.getProperty("password_cms"));
        Thread.sleep(2000);
        String window1Handle = driver.getWindowHandle();
        homePage = new HomePage(driver);
        homePage.openTournamentManager();
        Thread.sleep(1000);

        tournamentManagePage = new TournamentManagePage(driver);
        tournamentManagePage.createTournament(inp.getProperty("tournament_name"), inp.getProperty("streamer_name"));
        Thread.sleep(2000);

        matchManagePage = new MatchManagePage(driver);
        matchManagePage.createMatch(inp.getProperty("match_name"), inp.getProperty("match_ong"), inp.getProperty("match_score"),
                inp.getProperty("matchteam1_name"), inp.getProperty("matchteam2_name"), inp.getProperty("linklogoteam1"), inp.getProperty("linklogoteam2"));
        Thread.sleep(1000);

        predictQuestionManagePage = new PredictQuestionManagePage(driver);
        predictQuestionManagePage.createPredictQuestion(inp.getProperty("predict_question"), inp.getProperty("predict_ansa"),
                inp.getProperty("predict_ansb"), inp.getProperty("predict_ong"));
        Thread.sleep(1000);

        controlPage = new ControlPage(driver);
        controlPage.sendQuestion();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("testurl2"));
        String window2Handle = driver.getWindowHandle();
        streamPage = new StreamPage(driver);
        streamPage.openAndLoginStreamPage(inp.getProperty("username_onlive"), inp.getProperty("password_onlive"));
        Thread.sleep(10000);
        streamPage.openPredictFrame();
        predictFramePage = new PredictFramePage(driver);
        predictFramePage.checkOutputPredictFrame(inp.getProperty("predict_question"), inp.getProperty("predict_ansa"),
                inp.getProperty("predict_ansb"));

        predictFramePage.checkPredict1(inp.getProperty("number_predicted"), inp.getProperty("predict_ansa"));
        //sau khi click button choi lai, check output lan 2
        predictFramePage.checkOutputPredictFrame(inp.getProperty("predict_question"), inp.getProperty("predict_ansa"),
                inp.getProperty("predict_ansb"));
        predictFramePage.sendPredict(inp.getProperty("number_predicted"));
        //kiem tra sau khi cho 7 giay, frame dau tri da an di hay chua
        streamPage.checkFramePredictDisplay();

        streamPage.openPredictFrame();
        predictFramePage.checkHiddenButton(inp.getProperty("number_predicted"));
        streamPage.checkFramePredictDisplay();
        //kiem tra trang thai btn dau tri la normal, click btn power tren cms, quay lai kiem tra trang thai btn dau tri la power.
        streamPage.checkStatusPredictBtnBefore();
        switchWindow(window1Handle);
        controlPage.clickPoweBtn();
        switchWindow(window2Handle);
        streamPage.checkStatusPredictBtnAfter();
        //ket thuc du doan, set dap an
        switchWindow(window1Handle);
        controlPage.finishPredictAndSetAns();
        //kiem tra xem btn dau tri da an di hay chua
        switchWindow(window2Handle);
        streamPage.checkBtnPredictDisplay();
        switchWindow(window1Handle);
        controlPage.finishMatch();
        tournamentManagePage.deleteTournament();
        driver.quit();

    }
    public void switchWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
        driver.switchTo().activeElement();
    }
}
