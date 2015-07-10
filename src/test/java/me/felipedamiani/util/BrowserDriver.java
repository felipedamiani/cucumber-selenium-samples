package me.felipedamiani.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author http://www.ibm.com/developerworks/library/a-automating-ria/
 */
public class BrowserDriver {
    
    private static final Logger LOG = LoggerFactory.getLogger(BrowserDriver.class);

    private static WebDriver driver;

    public synchronized static WebDriver getCurrentDriver() {
        if (driver == null) {
            try {
                driver = new FirefoxDriver(new FirefoxProfile());
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
        }
        return driver;
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }

    public static void close() {
        try {
            getCurrentDriver().quit();
            driver = null;
        } catch (UnreachableBrowserException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public static void loadPage(String url) {
        getCurrentDriver().get(url);
    }

}
