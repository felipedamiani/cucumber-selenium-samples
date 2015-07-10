package me.felipedamiani.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *
 * @author felipe.damiani
 */
public class HomePage {

    @FindBy(how = How.CSS, using = "#showmenu")
    public WebElement menu;
    
}
