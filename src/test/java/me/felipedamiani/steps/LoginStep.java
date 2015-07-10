package me.felipedamiani.steps;

import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import me.felipedamiani.pages.HomePage;
import me.felipedamiani.util.BrowserDriver;
import me.felipedamiani.pages.LoginPage;
import me.felipedamiani.util.NavigationHelper;

/**
 *
 * @author felipe.damiani
 */
public class LoginStep extends AbstractStep {

    private static final Logger LOG = LoggerFactory.getLogger(LoginStep.class);
    
    private LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    private HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    
    public LoginStep() {

        Given("^I navigate to the login page (.*)$", (String url) -> {
            LOG.info(String.format("I navigate to the login page '%s'", url));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            BrowserDriver.loadPage(url);
        });

        When("^I try to login with '(.+)' credentials$", (String credentialsType) -> {
            LOG.info(String.format("I try to login with '%s' credentials", credentialsType));
            switch (credentialsType) {
                case "valid":
                    loginPage.key.sendKeys("1");
                    loginPage.user.sendKeys("1");
                    loginPage.pwd.sendKeys("1");
                    loginPage.logim.click();
                    break;
                case "invalid":
                    loginPage.key.sendKeys("1");
                    loginPage.user.sendKeys("3");
                    loginPage.pwd.sendKeys("1");
                    loginPage.logim.click();
                    break;
            }
        });

        Then("^I should see the menu button$", () -> {
            LOG.info("I should see the menu button");
            NavigationHelper.waitForElementLoad(driver, "#div_user_login");
            Assert.assertTrue(homePage.menu.isDisplayed());
        });
        
        Then("^I should see a error message$", () -> {
            LOG.info("I should see a error message");
            NavigationHelper.waitForElementLoad(driver, "div#topError");
            Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        });

    }

}
