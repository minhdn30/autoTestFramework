package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;


public class TestScript {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
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
        WebElement buttonQuanLyCauHoiDuDoan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[1]/div/div[2]/div/div[8]")));
        buttonQuanLyCauHoiDuDoan.click();
        //chon dung giai dau neu can
//        WebElement findGiaiDauQLCH = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[1]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]")));
//        findGiaiDauQLCH.click();
//        WebElement chooseGiaiDauQLCH = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-list-item__title' and text()='Minh Test 1']")));
//        chooseGiaiDauQLCH.click();
        //test cau hoi du doan dau tri, TemplatePredictValorant
        WebElement buttonChooseTemplate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/form/div/div[1]/div/div/div/div/div[1]/div[1]/div[2]/div/i")));
        buttonChooseTemplate.click();
        sleep(500);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        WebElement inputTextQuestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/form/div/div[2]/div/div[2]/div/div/div[1]/div/textarea")));
        String inputTextQuestionStr = "Cau hoi dau tri";
        inputTextQuestion.sendKeys(inputTextQuestionStr);
        WebElement inputTextAnsA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/form/div/div[2]/div/div[3]/div[1]/div/div/div[1]/div/input")));
        String inputTextAnsAStr = "Dap An A...";
        inputTextAnsA.sendKeys(inputTextAnsAStr);

        WebElement inputTextAnsB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/form/div/div[2]/div/div[3]/div[2]/div/div/div[1]/div/input")));
        String inputTextAnsBStr = "Dap An B...";
        inputTextAnsB.sendKeys(inputTextAnsBStr);
        WebElement inputTextOnG = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/form/div/div[3]/div/div[2]/div/div[1]/div/input")));
        inputTextOnG.sendKeys("0");
        WebElement buttonLuu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/form/div/div[5]/button/span")));
        buttonLuu.click();
        WebElement buttonDieuKhieu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[1]/div/div[2]/div/div[7]/span")));
        buttonDieuKhieu.click();
//        WebElement findTranDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[1]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div[1]")));
//        findTranDau.click();
//        sleep(500);
//        actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).perform();
        sleep(1000);
        WebElement buttonThemCauHoi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/div[1]/div/div[1]/div/button/span/i")));
        buttonThemCauHoi.click();
        sleep(2000);
        WebElement checkBoxThemCauHoi = chromeDriver.findElements(By.className("v-input--selection-controls__ripple")).get(2);
        checkBoxThemCauHoi.click();
        WebElement buttonLuuThemCauHoi = chromeDriver.findElements(By.className("v-btn__content")).get(74);
        buttonLuuThemCauHoi.click();
        WebElement buttonBanCauHoi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div/div/div/table/tbody/tr/td[4]/div/div/button[3]/span/i")));
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
                textUsername2.sendKeys("aftv_onlive062");

                WebElement textPassword2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
                textPassword2.sendKeys("Onlive#2023");

                WebElement buttonLoginSubmit2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-danger")));
                buttonLoginSubmit2.submit();

                WebElement buttonPlay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/div[11]/dl/dd[2]")));
                buttonPlay.click();

                WebElement buttonHere = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div[28]/div/span/a/span")));
                buttonHere.click();
                sleep(10000);
                WebElement buttonOpenDauTri = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/div[24]/div")));
                buttonOpenDauTri.click();
                sleep(2000);
                WebElement frameDauTri = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/iframe")));

//                String inputTextQuestionStr = "Cau hoi dau tri";
//                String inputTextAnsAStr = "Dap An A...";
//                String inputTextAnsBStr = "Dap An B...";
                //check output lan 1
                chromeDriver.switchTo().frame(frameDauTri);
                WebElement outputQuestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main_content-question")));
                String outputTextQuestion = outputQuestion.getText();
                System.out.println(outputTextQuestion);
                Assert.assertEquals(outputTextQuestion, "1. " + inputTextQuestionStr.toUpperCase());

                WebElement outputAnsA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ans-0")));
                String outputTextAnsA = outputAnsA.getText();
                System.out.println(outputTextAnsA);
                Assert.assertEquals(outputTextAnsA, inputTextAnsAStr.toUpperCase());

                WebElement outputAnsB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ans-1")));
                String outputTextAnsB = outputAnsB.getText();
                System.out.println(outputTextAnsB);
                Assert.assertEquals(outputTextAnsB, inputTextAnsBStr.toUpperCase());

                //gui so nguoi du doan la 100, nut gui du doan la disabled
                WebElement inputTextSoNguoiDuDoan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("countAnswerInput")));
                String inputSoNguoiDuDoan = "100";
                inputTextSoNguoiDuDoan.sendKeys(inputSoNguoiDuDoan);
                WebElement buttonGuiDuDoan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-submit")));
                Assert.assertEquals(buttonGuiDuDoan.isEnabled(), false, "ButtonGuiDuDoan is disabled.");
                //xoa so nguoi du doan va chon dap an A, nut gui du doan van la disabled
                inputTextSoNguoiDuDoan.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
                outputAnsA.click();
                Assert.assertEquals(buttonGuiDuDoan.isEnabled(), false, "ButtonGuiDuDoan is disabled.");

                //gui so nguoi du doan va chon dap an A, nut gui du doan la enabled, co the click
                inputTextSoNguoiDuDoan.sendKeys(inputSoNguoiDuDoan);
                buttonGuiDuDoan.click();
                //check output hien ra sau khi gui dap an.
                WebElement outputTextAnsAfter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div[1]/div[2]/span[1]")));
                String outputTextAnsAfterStr = outputTextAnsAfter.getText();
                System.out.println(outputTextAnsAfterStr);
                Assert.assertEquals(outputTextAnsAfterStr, inputTextAnsAStr);

                WebElement outputTextSoNguoiDuDoanAfter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div[1]/div[2]/span[3]")));
                String outputTextSoNguoiDuDoanAfterStr = outputTextSoNguoiDuDoanAfter.getText();
                System.out.println(outputTextSoNguoiDuDoanAfterStr);
                Assert.assertEquals(outputTextSoNguoiDuDoanAfterStr, "100");
                WebElement buttonChoiLai = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div[2]/button/span")));
                buttonChoiLai.click();
                //sau khi click button choi lai, check output lan 2
                WebElement outputQuestion2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main_content-question")));
                String outputTextQuestion2 = outputQuestion2.getText();
                System.out.println(outputTextQuestion2);
                Assert.assertEquals(outputTextQuestion2, "1. " + inputTextQuestionStr.toUpperCase());

                WebElement outputAnsA2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ans-0")));
                String outputTextAnsA2 = outputAnsA2.getText();
                System.out.println(outputTextAnsA2);
                Assert.assertEquals(outputTextAnsA2, inputTextAnsAStr.toUpperCase());

                WebElement outputAnsB2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ans-1")));
                String outputTextAnsB2 = outputAnsB2.getText();
                System.out.println(outputTextAnsB2);
                Assert.assertEquals(outputTextAnsB2, inputTextAnsBStr.toUpperCase());
                //chon dap an B va gui so nguoi du doan la 100, gui du doan
                WebElement outputAnsB3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ans-1")));
                outputAnsB3.click();

                WebElement inputTextSoNguoiDuDoan2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("countAnswerInput")));
                inputTextSoNguoiDuDoan2.sendKeys("100");
                WebElement buttonGuiDuDoan2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-submit")));
                buttonGuiDuDoan2.click();
                //sau khi cho 7 giay, kiem tra xem man hinh dau tri da an di chua
                chromeDriver.switchTo().defaultContent();
                sleep(7000);
                WebElement buttonOpenDauTri2 = chromeDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/div[24]/div"));
                if (buttonOpenDauTri2.isDisplayed()) {
                    System.out.println("Frame Dau Tri da an");
                    Assert.assertTrue(true);
                } else {
                    System.out.println("Frame Dau Tri chua an");
                    Assert.assertFalse(true);
                }
                buttonOpenDauTri.click();
                sleep(2000);
                WebElement frameDauTri2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/iframe")));
                chromeDriver.switchTo().frame(frameDauTri2);
                WebElement outputAnsA3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ans-0")));
                outputAnsA3.click();
                WebElement inputTextSoNguoiDuDoan3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("countAnswerInput")));
                inputTextSoNguoiDuDoan3.sendKeys("100");
                WebElement buttonGuiDuDoan3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-submit")));
                buttonGuiDuDoan3.click();
                WebElement buttonAnCuaSo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("img-hide")));
                buttonAnCuaSo.click();
                chromeDriver.switchTo().defaultContent();
                sleep(2000);
                WebElement buttonOpenDauTri3 = chromeDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/div[24]/div"));
                if (buttonOpenDauTri3.isDisplayed()) {
                    System.out.println("Frame Dau Tri da an");
                    Assert.assertTrue(true);
                } else {
                    System.out.println("Frame Dau Tri chua an");
                    Assert.assertFalse(true);
                }
                //kiem tra nut power
                try {
                    WebElement normalElementBefore = chromeDriver.findElement(By.className("normal"));
                    JavascriptExecutor jsExecutor = (JavascriptExecutor) chromeDriver;
                    String scriptBefore = "return arguments[0].classList;";
                    Object classListBefore = jsExecutor.executeScript(scriptBefore, normalElementBefore);
                    String classListBeforeStr = classListBefore.toString();
                    System.out.println("DOMTokenList:" + classListBefore);
                    Assert.assertEquals(classListBeforeStr, "[normal]");
                    chromeDriver.switchTo().window(window1Handle);
                    chromeDriver.switchTo().activeElement();
                    WebElement buttonPower = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div/div/div/table/tbody/tr/td[4]/div/button[3]")));
                    buttonPower.click();
                    chromeDriver.switchTo().window(window2Handle);
                    chromeDriver.switchTo().activeElement();
                    sleep(1000);
                    WebElement normalElementAfter = chromeDriver.findElement(By.className("normal"));
                    String scriptAfter = "return arguments[0].classList;";
                    Object classListAfter = jsExecutor.executeScript(scriptAfter, normalElementAfter);
                    String classListAfterStr = classListAfter.toString();
                    System.out.println("DOMTokenList:" + classListAfter);
                    Assert.assertEquals(classListAfterStr, "[normal, power]");
                    WebElement powerElementAfter = chromeDriver.findElement(By.className("power"));
                    if (powerElementAfter.getAttribute("class").contains("power")) {
                        System.out.println("power");
                    } else {
                        System.out.println("no power");
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("not found");
                }
                //ket thuc du doan, set dap an
                chromeDriver.switchTo().window(window1Handle);
                chromeDriver.switchTo().activeElement();
                WebElement buttonKetThucDuDoan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div/div/div/table/tbody/tr/td[4]/div/button[1]")));
                buttonKetThucDuDoan.click();
                sleep(1000);
                WebElement buttonConfirm = chromeDriver.findElements(By.className("v-btn__content")).get(77);
                buttonConfirm.click();
                sleep(1000);
                WebElement buttonSetAns = chromeDriver.findElements(By.className("v-btn__content")).get(68);
                buttonSetAns.click();
                sleep(1000);
                WebElement buttonChooseAnsA = chromeDriver.findElements(By.className("v-input--selection-controls__ripple")).get(1);
                buttonChooseAnsA.click();
                WebElement buttonConfirmAns = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("buttonSubmit")));
                buttonConfirmAns.click();
                sleep(1000);
                //kiem tra xem button Dau Tri da an di hay chua
                chromeDriver.switchTo().window(window2Handle);
                chromeDriver.switchTo().activeElement();
                List<WebElement> elements =  chromeDriver.findElements(By.className("box-lucky"));
                if (!elements.isEmpty()) {
                    WebElement element = elements.get(1);
                    element.click();
                    System.out.println("button Dau Tri chua an di");
                } else {
                    System.out.println("button Dau Tri da an di");
                }
            }
        }

        sleep(2000);
        //ket thuc tran dau, xoa giai dau, thoat trinh duyet
        chromeDriver.switchTo().window(window1Handle);
        chromeDriver.switchTo().activeElement();
        WebElement buttonFinishMatch = chromeDriver.findElements(By.className("v-size--default")).get(4);
        buttonFinishMatch.click();
        sleep(1000);
        WebElement buttonConfirmFinishMatch = chromeDriver.findElements(By.className("v-btn__content")).get(75);
        buttonConfirmFinishMatch.click();
        WebElement buttonQuanLyGiaiDau = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[4]/main/div/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]")));
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
    private static void sleep(int time){
        try{
            Thread.sleep(time);
        } catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
    }
}
