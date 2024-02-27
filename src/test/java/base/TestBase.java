package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties prop = new Properties();
    protected Properties loc = new Properties();
    protected Properties inp = new Properties();
    protected FileReader fr;
    protected FileReader fr1;
    protected FileReader fr2;

    @BeforeTest
    public void setUp() throws IOException {
        if (driver == null) {
            fr = new FileReader("C:\\Users\\admin\\IdeaProjects\\autoTestFramework\\src\\test\\java\\config\\config.properties");
            fr1 = new FileReader("C:\\Users\\admin\\IdeaProjects\\autoTestFramework\\src\\test\\java\\config\\input.properties");
            fr2 = new FileReader("C:\\Users\\admin\\IdeaProjects\\autoTestFramework\\src\\test\\java\\config\\locators.properties");
            prop.load(fr);
            inp.load(fr1);
            loc.load(fr2);

            if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            driver.get(prop.getProperty("testurl"));
            //driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        }
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
      //  driver.close();
        System.out.println("Teardown successful");
    }
}
