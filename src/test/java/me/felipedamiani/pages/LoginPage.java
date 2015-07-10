package me.felipedamiani.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *
 * @author felipe.damiani
 */
public class LoginPage {

    @FindBy(how = How.CSS, using = "form[name=myForm]")
    public WebElement loginPageDiv;

    @FindBy(how = How.CSS, using = "input#key")
    public WebElement key;
    
    @FindBy(how = How.CSS, using = "input#user")
    public WebElement user;

    @FindBy(how = How.CSS, using = "input#pwd")
    public WebElement pwd;

    @FindBy(how = How.CSS, using = "input#login")
    public WebElement logim;

    @FindBy(how = How.CSS, using = "div#topError")
    public WebElement errorMessage;
    
}
