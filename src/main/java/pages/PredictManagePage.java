package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PredictManagePage extends PageBase{
    public PredictManagePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/main/div/div/div/div[2]/div/div[1]/div[2]/div[2]/button/span/span")
    WebElement buttonAddQuestion;
    public void openAddPredictQuestionFrame(){
        clickButton(buttonAddQuestion);
    }
}
