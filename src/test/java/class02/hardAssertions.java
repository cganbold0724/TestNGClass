package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class hardAssertions {

    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }
    @Test
    public void verifyInvalidCredentialsError() throws InterruptedException {

        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys("WeatherMay");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("lololol");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();
        WebElement invalidMessage = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String errorText=invalidMessage.getText();
        System.out.println(errorText);

        String expectedMsg="Invalid credentials";
        Assert.assertEquals(errorText,expectedMsg);

        username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        boolean displayed=username.isDisplayed();
        Assert.assertTrue(displayed);


    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();

    }
}
