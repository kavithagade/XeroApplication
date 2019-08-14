package Runner;

import org.junit.runner.RunWith; 
import cucumber.api.CucumberOptions; 
import cucumber.api.junit.Cucumber; 


@RunWith(Cucumber.class)
@CucumberOptions( 
 			features = "C:/Users/saimanu/xeroworkspace/XeroTest/src/main/java/Features", 
 			glue={"stepDefinitions"}
 			//,format={"pretty","html:test-output"}
 						 
 			) 

public class TestRunner {

	
	
	
	
	
	

}
