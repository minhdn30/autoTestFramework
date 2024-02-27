package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginCMSPage extends PageBase {
    public LoginCMSPage(WebDriver driver) {
        super(driver);
    }
        @FindBy(xpath ="/html/body/div/div/div/div/div/main/div/div/div/div/div/div/form/div/div[1]/form/div[2]/div/div/div/div/input")
        WebElement textUsername;
        @FindBy(xpath ="/html/body/div/div/div/div/div/main/div/div/div/div/div/div/form/div/div[1]/form/div[3]/div/div/div/div/input")
        WebElement textPassword;
        @FindBy(className ="btn-login")
        WebElement buttonLoginSubmit;
    public void loginCMS(String usernameCMS, String passwordCMS){
        System.out.println(driver.getTitle());
        sendKeysText(textUsername, usernameCMS);
        sendKeysText(textPassword,passwordCMS);
        clickButton(buttonLoginSubmit);
    }
}
