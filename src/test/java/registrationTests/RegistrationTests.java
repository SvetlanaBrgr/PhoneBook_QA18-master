package registrationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests {

    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
    }

    @Test
    public void regPositiveTest(){

//        1. open login/registration form
        WebElement loginBtn = wd.findElement(By.xpath("//a[@href='/login']"));
        loginBtn.click();
//        2. fill login/registration form
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abc" + i + "@def.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abcd1234");
////        3. submit by click registration button
//        wd.findElement(By.xpath("//button[2]")).click();
////        4. assert
//        Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));

//-----------------HW_8-------------------------
//        1. fill out the registration form with an incorrect email and correct password
        WebElement emailIncorr = wd.findElement(By.xpath("//input[1]"));
        emailIncorr.click();
        emailIncorr.clear();
        emailIncorr.sendKeys("test1" + i +"mail.ru");

        WebElement passCorr = wd.findElement(By.xpath("//input[2]"));
        passCorr.click();
        passCorr.clear();
        passCorr.sendKeys("Qwer1234$");

//     2. fill out the registration form with an correct email and incorrect password
        WebElement emailCorr= wd.findElement(By.xpath("//input[1]"));
        emailCorr.click();
        emailCorr.clear();
        emailCorr.sendKeys("test" + i +"@mail.ru");

        WebElement passIncorr = wd.findElement(By.xpath("//input[2]"));
        passIncorr.click();
        passIncorr.clear();
        passIncorr.sendKeys("asdfg");

//        3. submit by click registration button
        wd.findElement(By.xpath("//button[2]")).click();


    }

    @AfterMethod
    public void tearDown() {
//        wd.quit();
    }
}
