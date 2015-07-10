package me.felipedamiani.util;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author felipe.damiani
 */
public class NavigationHelper {

    private static final Logger LOG = LoggerFactory.getLogger(NavigationHelper.class);
    
    public static void waitForElementLoad(WebDriver driver, String cssSelector) {
        LOG.info(String.format("Waiting for the %s element loading", cssSelector));
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
    }

}
