package tests;

import manager.ProviderData;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

//@Listeners(NGListener.class)//подключение NGListener.class

public class LoginTests extends TestBase {
    @Test //cw_19

    public void loginPositiveTestConfig(User user) {//cw_19
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginForm(app.getEmail(), app.getPassword());
        app.getUser().submitLogin();


    }
    @Test (invocationCount = 3, groups = {"smoke"},
            dataProvider = "loginModelDto", dataProviderClass = ProviderData.class) //cw_18 and cw_19

    public void loginPositiveTest(User user) {
//        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        User user = new User().withEmail("test@mail.ru").withPassword("Qwer1234$");
//        User user = User.builder()
//                .email("test" + i + "@mail.ru")
//                .password("Qwer1234$")
//                .build();
//        logger.info("regPositiveTest starts with:" + user.getEmail() + " & " + user.getPassword());
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();

        Assert.assertFalse(app.getUser().isLogged());
    }

    @Test(groups = {"smoke", "regress"})
    public void loginNegativeTestWrongEmail() {
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

    @Test(groups = {"regress"})
    public void loginNegativeTestWrongPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = User.builder()
                .email("test" + i + "@mail.ru")
                .password("Qwer1234")//Qwer1234$
                .build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isErrorFormatMessage());// method window Alert with text - confirmation
        Assert.assertTrue(app.getUser().isAlertPresent());// method window Alert with text in console
    }

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

