
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.sikuli.script.*;

public class TestScript {
    ChromeDriver chromeDriver;

    @BeforeMethod
    public void Setup() {
        //mo OBS set up va phat luong
        //test moi truong dev : connect VPN
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
    }
    @Test
    public void autoTestDevMiniGame() {
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
        Actions actions = new Actions(chromeDriver);

        chromeDriver.get("https://dev-interactive.onplay.live/operation-onlive-tournament");
        String window1Handle = chromeDriver.getWindowHandle();

        WebElement textUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/div/main/div/div/div/div/div/div/form/div/div[1]/form/div[2]/div/div/div/div/input")));
        textUsername.sendKeys("minhdn");

        WebElement textPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/div/main/div/div/div/div/div/div/form/div/div[1]/form/div[3]/div/div/div/div/input")));
        textPassword.sendKeys("vtvlive@123");

        WebElement buttonLoginSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-login")));
        buttonLoginSubmit.submit();

        WebElement buttonVanHanhOnlive = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[3]/nav/div[1]/section/div[1]/div/div[5]/div")));
        buttonVanHanhOnlive.click();

        actions.moveToElement(buttonVanHanhOnlive);
        chromeDriver.manage().window().maximize();
        chromeDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        sleep(500);
        WebElement buttonMucQuanLyGiaiDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/nav/div[1]/section/div[1]/div/div[5]/div[2]/a[6]/div[2]")));
        buttonMucQuanLyGiaiDau.click();
        chromeDriver.manage().window().maximize();
        sleep(500);
        WebElement buttonThemMoiGiaiDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div/main/div/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/button")));
        buttonThemMoiGiaiDau.click();
        WebElement inputTextTenGiaiDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/div[4]/div/div/div/form/div[1]/div[1]/div/div/div[1]/div/input")));
        inputTextTenGiaiDau.sendKeys("Minh Test 1");
        WebElement buttonLuuGiaiDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/div[4]/div/div/div/form/div[2]/div/button")));
        buttonLuuGiaiDau.click();
        WebElement buttonAnGiaiDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[3]/main/div/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/div/table/tbody/tr[1]/td[5]/div/button[3]/span")));
        buttonAnGiaiDau.click();
        WebElement buttonXemChiTietGiaiDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[3]/main/div/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/div/table/tbody/tr[1]/td[5]/div/button[1]/span/i")));
        buttonXemChiTietGiaiDau.click();
        sleep(1000);
        WebElement buttonSuaChiTietGiaiDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[4]/div/div/div/div[1]/button/span")));
        buttonSuaChiTietGiaiDau.click();
        sleep(1000);
        WebElement inputNhapTenStreamer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/div[4]/div/div/div/form/div[2]/div[1]/div[2]/div/div/div/div[1]/input")));
        inputNhapTenStreamer.sendKeys("minhdn211002");
        WebElement buttonThemStreamer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/div[4]/div/div/div/form/div[2]/div[1]/div[3]/button/span/span")));
        buttonThemStreamer.click();
        WebElement buttonLuuChiTietGiaiDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/div[4]/div/div/div/form/div[3]/div/button/span")));
        buttonLuuChiTietGiaiDau.click();

        WebElement buttonQuanLyTranDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[3]/main/div/div/div/div[2]/div/div[1]/div/div[2]/div/div[4]")));
        buttonQuanLyTranDau.click();
        WebElement buttonThemTranDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[1]/button/span/span")));
        buttonThemTranDau.click();
        sleep(1000);
        WebElement inputTextTenTranDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tournament-match_form-name")));
        inputTextTenTranDau.sendKeys("Tran Dau 1");
        WebElement inputTextOnGTranDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tournament-match_form-ong")));
        inputTextOnGTranDau.sendKeys("0");
        WebElement inputTextDiemTranDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tournament-match_form-score")));
        inputTextDiemTranDau.sendKeys("10");
        WebElement inputTextTenDoi1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tournament-match_form-team1")));
        inputTextTenDoi1.sendKeys("Doi 1");
        WebElement inputTextTenDoi2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tournament-match_form-team2")));
        inputTextTenDoi2.sendKeys("Doi 2");
        WebElement buttonThoiGian = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tournament-match_form-time")));
        buttonThoiGian.click();
        sleep(500);
//        WebElement buttonNextMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[7]/div/div/div[1]/div/div[2]/div/div/div/div[2]/div/div[1]/button[2]")));
//        buttonNextMonth.click();
//        sleep(500);
        WebElement buttonChooseDay15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-btn__content' and text()='15']")));
        buttonChooseDay15.click();
        WebElement buttonOKThoiGian = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='v-btn__content' and text()='OK']")));
        buttonOKThoiGian.click();
        WebElement buttonLogoDoi1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-file-input__text")));
        buttonLogoDoi1.click();
        sleep(2000);
        //dung sukuliX de thao tac voi hop thoai Open
        Screen screen = new Screen();
        screen.type("\"C:\\Users\\admin\\Desktop\\imageSup\\1.jpg\"");
        screen.type(Key.ENTER);
        sleep(1000);
        WebElement buttonLogoDoi2 = chromeDriver.findElements(By.className("v-file-input__text")).get(1);
        buttonLogoDoi2.click();
        sleep(2000);
        screen.type("\"C:\\Users\\admin\\Desktop\\imageSup\\3.jpg\"");
        screen.type(Key.ENTER);
        sleep(1000);
        WebElement buttonLuuTranDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tournament-match_form-submit_btn")));
        buttonLuuTranDau.click();




        WebElement buttonQuanLyCauHoi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[1]/div/div[2]/div/div[3]")));
        buttonQuanLyCauHoi.click();
        WebElement buttonChooseTemplate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/form/div/div[1]/div/div/div/div/div[1]/div[1]/div[2]/div/i")));
        buttonChooseTemplate.click();
        WebElement buttonChooseOnlivePercentV2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='OnlivePercentV2']")));
        buttonChooseOnlivePercentV2.click();

        WebElement textInputQuestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/form/div/div[5]/div/div[2]/div/div/div[1]/div/textarea")));
        String textInputQuestionStr = "Cau hoi dau tien";
        textInputQuestion.sendKeys(textInputQuestionStr);
        WebElement textInputAnsA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/form/div/div[5]/div/div[3]/div[1]/div/div/div[1]/div/input")));
        String textInputAnsAStr = "Dap An A...";
        textInputAnsA.sendKeys(textInputAnsAStr);
        WebElement textInputAnsB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/form/div/div[5]/div/div[3]/div[2]/div/div/div[1]/div/input")));
        String textInputAnsBStr = "Dap An B...";
        textInputAnsB.sendKeys(textInputAnsBStr);
        WebElement textInputAnsC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/form/div/div[5]/div/div[3]/div[3]/div/div/div[1]/div/input")));
        String textInputAnsCStr = "Dap An C...";
        textInputAnsC.sendKeys(textInputAnsCStr);
        WebElement textInputTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/form/div/div[6]/div/div[2]/div/div[1]/div/input")));
        textInputTime.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);
        textInputTime.sendKeys("120");
        WebElement buttonSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/form/div/div[7]/button/span")));
        buttonSave.click();
        WebElement buttonDieuKhieu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[1]/div/div[2]/div/div[7]/span")));
        buttonDieuKhieu.click();
        sleep(1000);
        WebElement buttonThemCauHoi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[4]/div/div/div[3]/div[2]/div/div[2]/div/div[1]/div/button/span/i")));
        buttonThemCauHoi.click();
        sleep(2000);
        WebElement checkBoxThemCauHoi = chromeDriver.findElements(By.className("v-input--selection-controls__ripple")).get(5);
        checkBoxThemCauHoi.click();
        WebElement buttonLuuThemCauHoi = chromeDriver.findElements(By.className("v-btn__content")).get(74);
        buttonLuuThemCauHoi.click();
        WebElement buttonBanCauHoi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[4]/div/div/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div/table/tbody/tr/td[4]/div/div/button[3]/span/i")));
        buttonBanCauHoi.click();
        chromeDriver.switchTo().newWindow(WindowType.WINDOW);
        ((ChromeDriver) chromeDriver).executeScript("window.open('https://play.onlive.vn/minhdn211002/86876');");

        Set<String> handles = chromeDriver.getWindowHandles();
        for (String handle : handles) {
            chromeDriver.switchTo().window(handle);

            if (chromeDriver.getTitle().equals("minhdn211002 | ON Live")) {
                String window2Handle = chromeDriver.getWindowHandle();
                sleep(1000);
                WebElement buttonLoginAcc2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-login")));
                buttonLoginAcc2.click();

                WebElement textUsername2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
                textUsername2.sendKeys("aftv_onlive032");

                WebElement textPassword2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
                textPassword2.sendKeys("Onlive#2023");

                WebElement buttonLoginSubmit2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-danger")));
                buttonLoginSubmit2.submit();

                WebElement buttonPlay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/div[11]/dl/dd[2]")));
                buttonPlay.click();

                WebElement buttonHere = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div[28]/div/span/a/span")));
                buttonHere.click();
                sleep(10000);
                WebElement frameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("live-interactive-iframe")));
                chromeDriver.switchTo().frame(frameElement);

                WebElement textQuestionDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("question-text")));
                String getTextQuestionDisplay = textQuestionDisplay.getText();
                System.out.println(getTextQuestionDisplay);
                Assert.assertEquals(getTextQuestionDisplay, textInputQuestionStr);

                getTextAns("0-answer1",textInputAnsAStr);
                getTextAns("1-answer2",textInputAnsBStr);
                getTextAns("2-answer3",textInputAnsCStr);

                WebElement buttonSentAnsA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("0-answer1")));
                buttonSentAnsA.click();
                sleep(5000);
                getPercent("0-answer1","100%");
                getPercent("1-answer2","0%");
                getPercent("2-answer3","0%");
                chromeDriver.switchTo().defaultContent();
                WebElement buttonLoginMore = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/button")));
                buttonLoginMore.click();

                WebElement buttonLogout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logout")));
                buttonLogout.click();

                WebElement buttonLogoutSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div/div/div/div/div/div/button[2]")));
                buttonLogoutSubmit.click();

                WebElement buttonLoginAcc3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-login")));
                buttonLoginAcc3.click();


                WebElement textUsername3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
                textUsername3.sendKeys("aftv_onlive037");

                WebElement textPassword3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
                textPassword3.sendKeys("Onlive#2023");

                WebElement buttonLoginSubmit3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-danger")));
                buttonLoginSubmit3.submit();

                WebElement buttonPlay2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/div[11]/dl/dd[2]")));
                buttonPlay2.click();

                WebElement frameElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("live-interactive-iframe")));
                chromeDriver.switchTo().frame(frameElement2);
                sleep(5000);
                WebElement buttonSentAnsB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("1-answer2")));
                buttonSentAnsB.click();

                sleep(5000);
                getPercent("0-answer1","50%");
                getPercent("1-answer2","50%");
                getPercent("2-answer3", "0%");
                //ket thuc tran dau, xoa giai dau, dong trinh duyet
                chromeDriver.switchTo().window(window1Handle);
                chromeDriver.switchTo().activeElement();
                WebElement buttonSetAns = chromeDriver.findElements(By.className("v-btn__content")).get(73);
                buttonSetAns.click();
                sleep(1000);
                WebElement buttonChooseAnsA = chromeDriver.findElements(By.className("v-input--selection-controls__ripple")).get(4);
                buttonChooseAnsA.click();
                WebElement buttonConfirmAns = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("buttonSubmit")));
                buttonConfirmAns.click();
                sleep(1000);
                WebElement buttonFinishMatch = chromeDriver.findElements(By.className("v-size--default")).get(5);
                buttonFinishMatch.click();
                sleep(1000);
                WebElement buttonConfirmFinishMatch = chromeDriver.findElements(By.className("v-btn__content")).get(76);
                buttonConfirmFinishMatch.click();
                sleep(1000);
                WebElement buttonQuanLyGiaiDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[3]/main/div/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]")));
                buttonQuanLyGiaiDau.click();
                sleep(1000);
                WebElement buttonDeleteTour = chromeDriver.findElements(By.className("v-btn--outlined")).get(2);
                buttonDeleteTour.click();
                sleep(1000);
                WebElement buttonConfirmDeleteTour = chromeDriver.findElements(By.className("v-btn--text")).get(1);
                buttonConfirmDeleteTour.click();
                sleep(3000);
                chromeDriver.quit();
            }
        }
    }
    public void getTextAns(String id, String textAnsExpected){
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        WebElement ansActual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        String textAnsActual = ansActual.getText().split("\n")[1];
        System.out.println(textAnsActual);
        Assert.assertEquals(textAnsActual, textAnsExpected);
    }
    public void getPercent(String id, String percentExpected){
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        WebElement percentActual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        String textPercentActual = percentActual.getText().split("\n")[0];
        Assert.assertEquals(textPercentActual, percentExpected);
    }
    private void sleep(int time){
        try{
            Thread.sleep(time);
        } catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
    }
    @AfterMethod
    public void CleanUp() {
    }
}