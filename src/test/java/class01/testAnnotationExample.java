package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testAnnotationExample {
    public static WebDriver driver;
    @Test
    public void testingForInvalidCredentials(){

        String text = driver.findElement(By.xpath("//h2[contains(text(), 'Connect with friends')]")).getText();
        if(text.equals("Connect with friends and the world around you on Facebook.")){
            System.out.println("successful");
        }else {
            System.out.println("failed");

        }
    }
    @Test
    public void createAccountTest(){

        String text = driver.findElement(By.xpath("//a[text()='Create new account']")).getText();

        if(text.equals("Create new account")){
            System.out.println("successful");
        }else {
            System.out.println("Failure");
        }
    }
    @BeforeMethod
    public void settingupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://fb.com");

    }
    @AfterMethod
    public void quittingTheBrowser(){
        driver.quit();
    }
}

