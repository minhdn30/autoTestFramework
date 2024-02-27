package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class StreamPage extends PageBase{
    public StreamPage(WebDriver driver) {
        super(driver);
    }
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    @FindBy(id = "btn-login")
    WebElement buttonLogin;
    @FindBy(id = "username")
    WebElement inputTextUsername;
    @FindBy(id = "password")
    WebElement inputTextPassword;
    @FindBy(className = "btn-danger")
    WebElement buttonLoginSubmit;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/div[11]/dl/dd[2]")
    WebElement buttonPlay;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div[28]/div/span/a/span")
    WebElement buttonHere;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/div[24]/div")
    WebElement buttonOpenPredictFrame;
    @FindBy(className = "normal")
    WebElement statusPredictBtn;
    @FindBy(className = "box-lucky")
    List<WebElement> luckyBoxes;

    public void openAndLoginStreamPage(String usernameStream, String passwordStream) throws InterruptedException {
        Thread.sleep(1000);
        clickButton(buttonLogin);
        sendKeysText(inputTextUsername, usernameStream);
        sendKeysText(inputTextPassword, passwordStream);
        clickButton(buttonLoginSubmit);
        Thread.sleep(1000);
        clickButton(buttonPlay);
        clickButton(buttonHere);
    }
    public void openPredictFrame(){
        clickButton(buttonOpenPredictFrame);
    }
    public void checkFramePredictDisplay() throws InterruptedException {
        driver.switchTo().defaultContent();
        Thread.sleep(7000);
        if(buttonOpenPredictFrame.isDisplayed()){
            System.out.println("Frame Dau Tri da an");
            Assert.assertTrue(true);
        } else {
            System.out.println("Frame Dau Tri chua an");
            Assert.assertFalse(true);
        }
    }
    public void checkStatusPredictBtnBefore (){
        String scriptBefore = "return arguments[0].classList;";
        Object classListBefore = jsExecutor.executeScript(scriptBefore, statusPredictBtn);
        String classListBeforeStr = classListBefore.toString();
        System.out.println("DOMTokenList:" + classListBefore);
        Assert.assertEquals(classListBeforeStr, "[normal]");
    }
    public void checkStatusPredictBtnAfter(){
        String scriptAfter = "return arguments[0].classList;";
        Object classListAfter = jsExecutor.executeScript(scriptAfter, statusPredictBtn);
        String classListAfterStr = classListAfter.toString();
        System.out.println("DOMTokenList:" + classListAfter);
        Assert.assertEquals(classListAfterStr, "[normal, power]");
        WebElement powerElementAfter = driver.findElement(By.className("power"));
        if (powerElementAfter.getAttribute("class").contains("power")) {
            System.out.println("power");
        } else {
            System.out.println("no power");
        }
    }
    public void checkBtnPredictDisplay(){
        if (!luckyBoxes.isEmpty()) {
            WebElement element = luckyBoxes.get(1);
            element.click();
            System.out.println("button Dau Tri chua an di");
        } else {
            System.out.println("button Dau Tri da an di");
        }
    }

}



