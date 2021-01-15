package superhero.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty",
		"html:target/html/" }, features = "src//test//resources//features", glue = { "superhero.stepDefinition", "superhero.utility" })

public class RunnerTest {









}
