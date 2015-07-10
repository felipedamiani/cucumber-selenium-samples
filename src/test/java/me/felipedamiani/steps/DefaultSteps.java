package me.felipedamiani.steps;

import cucumber.api.DataTable;
import java.util.List;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author felipe.damiani
 */
public class DefaultSteps extends AbstractStep {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultSteps.class);

    public DefaultSteps() {

        When("^I type in (.*) the value (.*)$", (String cssSelector, String value) -> {
            LOG.info(String.format("I type in '%s' the value '%s'", cssSelector, value));
            driver.findElement(By.cssSelector(cssSelector)).sendKeys(value);
        });

        When("^I click on (.*)$", (String id) -> {
            LOG.info(String.format("I click in '%s'", id));
            driver.findElement(By.id(id)).click();
        });

        When("^I set the following values in the form$", (DataTable dados) -> {
            LOG.info("I set the following values in the form");
            List<List<String>> linhas = dados.asLists(String.class);
            linhas.stream().forEach((linha) -> {
                driver.findElement(By.cssSelector(linha.get(0))).sendKeys(linha.get(1));
            });
        });

    }

}
