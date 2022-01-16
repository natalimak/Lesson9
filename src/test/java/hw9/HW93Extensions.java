/*Run browsers without extensions.        */


package hw9;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HW93Extensions {
    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Administrator\\Documents\\Natali\\לימודים\\QA_Automation\\Tools\\chromedriver.exe");
    }

    @Test
    public static void Extensions(){
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--disable-extensions");
        ChromeDriver driver = new ChromeDriver(options);
        }

    }

