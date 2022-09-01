package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertion {
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }
    @Test(groups = "regression")
    public void invalidCredentials(){

        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys("WeatherMay");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("lololol");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String errorText=errorMsg.getText();
        String expectedText="Invalid credentials";

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(errorText,expectedText);
        username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        boolean displayed=username.isDisplayed();
        soft.assertTrue(displayed);
        soft.assertAll();

    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}
