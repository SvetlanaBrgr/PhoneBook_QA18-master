package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {
    @DataProvider //cw_18
    public Iterator<Object[]> loginModelDto(){
        List<Object[]> list= new ArrayList<>();
        list.add(new Object[]{new User().withEmail("test@mail.ru").withPassword("Qwer1234$")}); //д.б. разные пользователи
        list.add(new Object[]{new User().withEmail("test@mail.ru").withPassword("Qwer1234$")});
        list.add(new Object[]{new User().withEmail("test@mail.ru").withPassword("Qwer1234$")});

        return list.iterator();

    }
}
