package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    public MyListener() {//constructor
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {//method - с готовыми параметрами
        super.beforeFindBy(by, element, driver);
        logger.info("Stsrt searching element by" + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("The element with locator by" + by + "is found successfully");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("Something went wrong!");
        logger.info(throwable.getMessage());
//        logger.info(throwable.fillInStackTrace().getMessage());1-й вариант
        logger.info(String.valueOf(throwable.fillInStackTrace()));//2-й вариант
    }
}
