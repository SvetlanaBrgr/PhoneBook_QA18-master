package registrationTests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationOptimal extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if(isLogged()){
            logout();
        }
    }
    @Test
    public void regPositiveTest(){
        // 1.
        openLoginRegistrationForm();

        //2.
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;
        String email = "test"+i+"@mail.ru";
        String password = "Qwer1234$";
        fillLoginRegistrationForm(email,password);

        //3.
        submitRegistration();

        //4.
        Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));

    }

}