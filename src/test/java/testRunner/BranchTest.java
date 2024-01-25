package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"./src/test/resources/featurefiles/branchCreation.feature"},
		
		glue = "stepDefination",
		
		dryRun = false
		
		)

public class BranchTest {

}
