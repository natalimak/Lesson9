/*Create a TestNG test with the following:
         Enter https://dgotlieb.github.io/WebCalculator/
         Print “7” button dimensions.
         Check if “6” button is displayed
         Prepare a String variable with any number
         Calculate a mathematical formula that will give the result
        you choose in the String variable earlier.
         Use assert to check if you got the expected result

        ** For example: press 4  press + button  press 2  Press = button
        The above will generate the result 6 (4+2).

         Print “2” button height.
         Print “6” button width.
        */



package hw9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebCalculator {
    private static ChromeDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Administrator\\Documents\\Natali\\לימודים\\QA_Automation\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/WebCalculator/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public static void test_01_ButtonSize() {
        WebElement button7 = driver.findElement(By.id("seven"));
        System.out.println("Height of button 7: " + button7.getRect().getHeight());
        System.out.println("Width of button 7: " + button7.getRect().getWidth());

        WebElement button2 = driver.findElement(By.id("two"));
        System.out.println("Height of button 2: " + button2.getRect().getHeight());

        WebElement button6 = driver.findElement(By.id("six"));
        System.out.println("Width of button 6: " + button6.getRect().getWidth());
    }

    @Test
    public static void test_01_6_Button() {
        WebElement button6 = driver.findElement(By.id("six"));
        if (button6.isDisplayed()) {
            System.out.println("6 Button is displayed");
        } else
            System.out.println("6 Button isn''t displayed");
    }

    @Test
    public static void test_01_Calculate() {
        WebCalculate_Tool res=new WebCalculate_Tool();
        WebElement result = driver.findElement(By.cssSelector("div[id$='screen'"));
        WebElement button6 = driver.findElement(By.id("six"));
        WebElement button5 = driver.findElement(By.id("five"));
        WebElement add = driver.findElement(By.id("add"));
        WebElement equal = driver.findElement(By.id("equal"));

        button5.click();
        add.click();
        button6.click();
        equal.click();
        System.out.println(result.getText());

       String result_e=String.valueOf(res.Add5_6());
        Assert.assertEquals(result_e,result.getText());

    }
}
