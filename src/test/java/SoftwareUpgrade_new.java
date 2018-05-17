import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;


public class SoftwareUpgrade_new {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void SoftwareUpgrade_new() {
        wd.get("http://10.10.9.13/login.html");
        wd.findElement(By.id("txtLogin")).click();
        wd.findElement(By.id("txtLogin")).clear();
        wd.findElement(By.id("txtLogin")).sendKeys("admin");
        wd.findElement(By.id("txtPassword")).click();
        wd.findElement(By.id("txtPassword")).clear();
        wd.findElement(By.id("txtPassword")).sendKeys("1234");
        wd.findElement(By.id("submitBtn")).click();
        wd.findElement(By.xpath("//div[@id='vms-export-container']//button[.='Close']")).click();
        wd.findElement(By.linkText("Configuration")).click();
        wd.findElement(By.cssSelector("span.vicon-font.v-software-upgrade")).click();
        wd.findElement(By.xpath("//div[@class='vms-right-panel-content']//button[.='click here']")).click();
        wd.findElement(By.id("upgradeFileInput")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
