package logTests;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest extends TestLog {
    @BeforeSuite
    public void preCondition() {
        if (isLogged()) {
            logout();
        }
    }

    @Test
    public void loginPositiveTest() {

        String email = "test@mail.ru";
        String password = "Qwer1234$";
        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitLogin();

            Assert.assertTrue(isLogged());
}
    @Test
        public void loginWrongEmail() {
            int i = (int)(System.currentTimeMillis() / 1000) % 3600;
            String email = "testmail.ru";
            String password = "Qwer1234$";
            openLoginRegistrationForm();
            fillLoginRegistrationForm(email, password);
            submitLogin();
        }

    @Test
    public void loginWrongPassword() {
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;
        String email = "test123@mail.ru";
        String password = "q123";
        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitLogin();
    }

//     Assert.assertTrue(wd.findElement(By.xpath("//input[@name='Password']")).getText().equals("Password"));

//     Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));
    }
