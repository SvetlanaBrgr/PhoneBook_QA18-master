package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        String email = "asd@def.com";
        String password = "$Abcdef12345";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLogged());
    }
    @Test
    public void loginNegativeTestWrongEmail(){
        String email = "abcdef.com";
        String password = "$Abcdef12345";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitLogin();
    }

    @AfterMethod
    public void tearDown() {
//        wd.quit();
    }
}
