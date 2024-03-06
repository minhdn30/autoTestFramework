package testcase;

import base.TestBase;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import pages.*;

public class MiniGameTest extends TestBase {
    LoginCMSPage loginCMSPage;
    HomePage homePage;
    TournamentManagePage tournamentManagePage;
    MatchManagePage matchManagePage;
    QuestionManagePage questionManagePage;
    ControlPage controlPage;
    StreamPage streamPage;
    MiniGameFramePage miniGameFramePage;
    @Test
    public void MiniGameTestCase() throws InterruptedException {
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
        //create and add mini game question
        questionManagePage = new QuestionManagePage(driver);
        questionManagePage.createMiniGameQuestion(inp.getProperty("minigame_question"), inp.getProperty("minigame_ansa"),
                inp.getProperty("minigame_ansb"), inp.getProperty("minigame_ansc"), inp.getProperty("minigame_time"));
        Thread.sleep(1000);
        //send question to stream page
        controlPage = new ControlPage(driver);
        controlPage.sendQuestion();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("testurl2"));
        String window2Handle = driver.getWindowHandle();
        //login onlive
        streamPage = new StreamPage(driver);
        streamPage.openAndLoginStreamPage(inp.getProperty("username_onlive"), inp.getProperty("password_onlive"));
        Thread.sleep(18000);
        miniGameFramePage = new MiniGameFramePage(driver);
        miniGameFramePage.switchToMiniGameFrame();
        miniGameFramePage.checkOutputDisplay(inp.getProperty("minigame_question"), inp.getProperty("minigame_ansa"),
                inp.getProperty("minigame_ansb"), inp.getProperty("minigame_ansc"));
        miniGameFramePage.checkPercentByAcc1();
        driver.switchTo().defaultContent();
        streamPage.loginAnotherAccount(inp.getProperty("username2_onlive"), inp.getProperty("password2_onlive"));
        Thread.sleep(5000);
        miniGameFramePage.switchToMiniGameFrame();
        miniGameFramePage.checkPercentByAcc2();
        //set answer, finish match, delete tournament
        switchWindow(window1Handle);
        controlPage.finishMiniGameAndSetAns();
        controlPage.finishMatch();
        tournamentManagePage.deleteMiniGameTournament(inp.getProperty("tournament_name"));
        //driver.quit();
    }
    public void switchWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
        driver.switchTo().activeElement();
    }
}
