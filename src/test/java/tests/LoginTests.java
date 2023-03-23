package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }
    @Test
    public void loginPositiveTest(){
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;
//        User user = new User().withEmail("test@mail.ru").withPassword("Qwer1234$");
        User user = User.builder()
                .email("test"+i+"@mail.ru")
                .password("Qwer1234$")
                .build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();

        Assert.assertFalse(app.getUser().isLogged());
    }
    @Test
    public void loginNegativeTestWrongEmail(){
        User user = User.builder()
                .email("test@mail.ru")
                .password("Qwer1234$")
                .build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
    }
    @Test
    public void loginNegativeTestWrongPassword(){
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;
        User user = User.builder()
                .email("test"+i+"@mail.ru")
                .password("Qwer1234$")
                .build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
    }
//    @Test
//    public void loginPositiveTest(){
//        String email = "asd@def.com";
//        String password = "$Abcdef12345";
//        app.getUser().openLoginRegistrationForm();
//        app.getUser().fillLoginRegistrationForm(email,password);
//        app.getUser().submitLogin();
//        Assert.assertTrue(app.getUser().isLogged());
//    }
//    @Test
//    public void loginNegativeTestWrongEmail(){
//        String email = "abcdef.com";
//        String password = "$Abcdef12345";
//        app.getUser().openLoginRegistrationForm();
//        app.getUser().fillLoginRegistrationForm(email, password);
//        app.getUser().submitLogin();
//    }

    @AfterMethod
    public void tearDown() {
//        wd.quit();
    }
}
