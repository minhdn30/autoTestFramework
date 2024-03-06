package testcase;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginCMSPage;
import pages.LuckyNumberPage;
import pages.StreamPage;

public class LuckyNumberTest extends TestBase {
    LoginCMSPage loginCMSPage;
    HomePage homePage;
    LuckyNumberPage luckyNumberPage;
    StreamPage streamPage;
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
        luckyNumberPage.createAndSendEvent(inp.getProperty("event_name"), inp.getProperty("event_ong"), inp.getProperty("streamer_name"));
    }
}
