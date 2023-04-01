package tests;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {

    //    WebDriver wd;
    public static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
        app.init();
    }
//    public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }

    @AfterSuite
    public void tearDown() {
//        wd.quit();
        app.stop();
    }

    @BeforeMethod
    public void started(Method method) {
        logger.info("  ### Start test" + method.getName());

    }

    @AfterMethod
    public void finished() {
        logger.info("   ### Finished ###");

    }
}

//================================================================================
//    public void logout(){
//        click(By.xpath("//button[.='Sign Out']"));
//    }
//    public boolean isLogged(){
//        return isElementPresent(By.xpath("//button[.='Sign Out']"));
//    }

//    public boolean isElementPresent(By locator){
//        return (wd.findElements(locator).size() > 0);
//    }
//    public void openLoginRegistrationForm() {
////        wd.findElement(By.xpath("//a[@href='/login']")).click();
//        click(By.xpath("//a[@href='/login']"));
//    }

//    public void fillLoginRegistrationForm(String email, String password){
//        type(By.xpath("//input[1]"), email);
//        type(By.xpath("//input[2]"), password);
//    }
//
//    public void submitRegistration(){
//        click(By.xpath("//button[2]"));
//    }
//    public void submitLogin(){
//        click(By.xpath("//button[1]"));
//    }

//    public void click(By locator){
//        wd.findElement(locator).click();
//    }

//    public void type(By locator, String text){
//        if(text != null){
//            WebElement element = wd.findElement(locator);
//            element.click();
//            element.clear();
//            element.sendKeys(text);
//        }
//    }

