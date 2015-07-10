package me.felipedamiani.util;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *
 * @author felipe.damiani
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    dryRun = false,
    strict = true,
    features = "src/test/java/steps/features",
    glue = "steps",
    tags = {"@runIt"}
)
public class RunTest {
}
