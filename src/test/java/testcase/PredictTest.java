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
    String usernameCMS = "minhdn";
    String passwordCMS ="vtvlive@123";
    String nameOfTournament = "Minh Test 1";
    String nameOfStreamer = "minhdn211002";
    String matchName = "Tran Dau 1";
    String matchOnG = "0";
    String matchScore = "10";
    String matchTeam1Name = "Doi 1";
    String matchTeam2Name = "Doi 2";
    String linkLogoTeam1 = "\"C:\\Users\\admin\\Desktop\\imageSup\\1.jpg\"";
    String linkLogoTeam2 = "\"C:\\Users\\admin\\Desktop\\imageSup\\3.jpg\"";
    String textQuestion = "Cau hoi dau tri";
    String textAnsA = "Dap an A...";
    String textAnsB = "Dap an B...";
    String textOnG = "0";
    String usernameStream = "aftv_onlive062";
    String passwordStream = "Onlive#2023";
    String numberOfPredicted = "100";
    @Test
    public void PredictTestCase() throws InterruptedException {
        loginCMSPage = new LoginCMSPage(driver);
        loginCMSPage.loginCMS(usernameCMS, passwordCMS);
        Thread.sleep(2000);
        String window1Handle = driver.getWindowHandle();
        homePage = new HomePage(driver);
        homePage.openTournamentManager();
        Thread.sleep(1000);

        tournamentManagePage = new TournamentManagePage(driver);
        tournamentManagePage.createTournament(nameOfTournament, nameOfStreamer);
        Thread.sleep(2000);

        matchManagePage = new MatchManagePage(driver);
        matchManagePage.createMatch(matchName, matchOnG, matchScore, matchTeam1Name, matchTeam2Name, linkLogoTeam1, linkLogoTeam2);
        Thread.sleep(1000);

        predictQuestionManagePage = new PredictQuestionManagePage(driver);
        predictQuestionManagePage.createPredictQuestion(textQuestion, textAnsA, textAnsB, textOnG);
        Thread.sleep(1000);

        controlPage = new ControlPage(driver);
        controlPage.sendQuestion();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("testurl2"));
        String window2Handle = driver.getWindowHandle();
        streamPage = new StreamPage(driver);
        streamPage.openAndLoginStreamPage(usernameStream, passwordStream);
        Thread.sleep(10000);
        streamPage.openPredictFrame();
        predictFramePage = new PredictFramePage(driver);
        predictFramePage.checkOutputPredictFrame(textQuestion,textAnsA,textAnsB);

        predictFramePage.checkPredict1(numberOfPredicted, textAnsA);
        //sau khi click button choi lai, check output lan 2
        predictFramePage.checkOutputPredictFrame(textQuestion,textAnsA,textAnsB);
        predictFramePage.sendPredict(numberOfPredicted);
        //kiem tra sau khi cho 7 giay, frame dau tri da an di hay chua
        streamPage.checkFramePredictDisplay();

        streamPage.openPredictFrame();
        predictFramePage.checkHiddenButton(numberOfPredicted);
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
