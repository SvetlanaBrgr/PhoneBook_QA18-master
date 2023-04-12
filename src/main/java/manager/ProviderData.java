package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
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

    @DataProvider
    public Iterator<Object[]> registrationCsv() throws IOException {//cw_19
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src / test / resources / data.csv")));

        String line = reader.readLine();//переменная, readLine() - пробросить throws IOException

        while (line != null) {
            String[] split = line.split(",");//получили массив строк и обернуть в while
            list.add(new Object[] { new User()
                    .withEmail(split[0])//index element
                    .withPassword(split[1])
            });

            line = reader.readLine();//циклом пройти по строкам по строка не станет null

        }
        return list.iterator();
    }
}
