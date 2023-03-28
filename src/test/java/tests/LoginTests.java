package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;
//        User user = new User().withEmail("test@mail.ru").withPassword("Qwer1234$");
        User user = User.builder()
                .email("test"+i+"@mail.ru")
                .password("Qwer1234$")
                .build();
        logger.info("regPositiveTest starts with:" + user.getEmail() + " & " + user.getPassword());
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
        Assert.assertTrue(app.getUser().isErrorFormatMessage());// method window Alert with text - confirmation
        Assert.assertTrue(app.getUser().isAlertPresent());// method window Alert with text in console
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
        Assert.assertTrue(app.getUser().isErrorFormatMessage());// method window Alert with text - confirmation
        Assert.assertTrue(app.getUser().isAlertPresent());// method window Alert with text in console
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

//    @AfterMethod
//    public void tearDown() {
////        wd.quit();
//    }
}
