package steps;

import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import io.cucumber.java.Scenario;
import utils.CommonMethods;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks extends CommonMethods {

    @Before
    public void start() throws IOException {
        openBrowserAndLaunchApplication();
    }

    @After
    public void end(Scenario scenario){
        //scenario class - this class contains all the information about execution logs
        //screenshot right before the browser closes
        byte[] pic;
        if(scenario.isFailed()) {
            pic = takeScreenshot("failed/"+scenario.getName());
        }else{
            pic = takeScreenshot("passed/"+scenario.getName());
        }

        closeBrowser();
    }
}
