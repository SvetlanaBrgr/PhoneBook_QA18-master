package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod (alwaysRun = true)
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
////        wait = new FluentWait<>(wd);
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }

    @Test (groups = {"smoke"})
    public void regPositiveTest(){
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;
//        String email = "name" + i + "@mail.com";
//        String password = "$Abcd1234";
        User user = User.builder()
                .email("test"+i+"@mail.ru")
                .password("Qwer1234$")
                .build();
        logger.info("regPositiveTest starts with:" + user.getEmail() + " & " + user.getPassword());
        app.getUser().openLoginRegistrationForm();
//        app.getUser().fillRegistrationForm(email, password);
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitRegistration();
    }

    @Test
    public void regNegativeWrongEmail(){
        User user = User.builder()
                .email("testmail.ru")
                .password("Qwer1234$")
                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitRegistration();
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//a[text()='ADD']")));
        //  Assert.assertTrue -> expected [true] but found [false]

        Assert.assertTrue(app.getUser().isErrorFormatMessage());// method window Alert with text - confirmation
        Assert.assertTrue(app.getUser().isAlertPresent());// method window Alert with text in console
    }
    @Test
    public void regNegativeWrongPassword(){
        User user = User.builder()
                .email("test@mail.ru")
                .password("qw34")
                .build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitRegistration();

        Assert.assertTrue(app.getUser().isErrorFormatMessage());// method window Alert with text - confirmation
        Assert.assertTrue(app.getUser().isAlertPresent());// method window Alert with text in console
    }
    @AfterMethod (alwaysRun = true)
    public void tearDown() {
//        wd.quit();
    }
}
