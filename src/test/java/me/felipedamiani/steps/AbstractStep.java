package me.felipedamiani.steps;

import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import me.felipedamiani.util.BrowserDriver;

/**
 *
 * @author felipe.damiani
 */
public class AbstractStep implements En {
    
    WebDriver driver = BrowserDriver.getCurrentDriver();
    
}
