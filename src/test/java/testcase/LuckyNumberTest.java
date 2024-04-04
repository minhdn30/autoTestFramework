package testcase;

import base.TestBase;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import pages.*;

public class LuckyNumberTest extends TestBase {
    LoginCMSPage loginCMSPage;
    HomePage homePage;
    LuckyNumberPage luckyNumberPage;
    StreamPage streamPage;
    LuckyNumberFramePage luckyNumberFramePage;
    @Test
    public void LuckyNumberTestCase() throws InterruptedException {
        loginCMSPage = new LoginCMSPage(driver);
        //open and login dev cms
        loginCMSPage.loginCMS(inp.getProperty("username_cms"), inp.getProperty("password_cms"));
        Thread.sleep(2000);
        String window1Handle = driver.getWindowHandle();
        homePage = new HomePage(driver);
        homePage.openLuckyNumber();
        Thread.sleep(1000);
        luckyNumberPage = new LuckyNumberPage(driver);
        luckyNumberPage.createAndSendEvent(inp.getProperty("event_name"), inp.getProperty("event_ong"),
                inp.getProperty("event_cellnumber"), inp.getProperty("event_luckynumber"), inp.getProperty("streamer_name"));
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("testurl2"));
        String window2Handle = driver.getWindowHandle();
        //login onlive
        streamPage = new StreamPage(driver);
        streamPage.openAndLoginStreamPage(inp.getProperty("username_onlive"), inp.getProperty("password_onlive"));
        Thread.sleep(10000);
        streamPage.openLuckyNumberFrame();
        luckyNumberFramePage = new LuckyNumberFramePage(driver);
        luckyNumberFramePage.switchToLuckyNumberFrame();
        luckyNumberFramePage.playLuckyNumber();
        luckyNumberFramePage.firstCheck();
        luckyNumberFramePage.playLuckyNumber();
        luckyNumberFramePage.secondCheck();
        luckyNumberFramePage.playLuckyNumber();
        luckyNumberFramePage.thirdCheck();
        switchWindow(window1Handle);
        luckyNumberPage.finishLuckyNumber(inp.getProperty("event_name"));

    }
    public void switchWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
        driver.switchTo().activeElement();
    }
}
