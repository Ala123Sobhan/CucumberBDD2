package stepdef;

import base.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.util.Strings;

public class Hook extends Config {

    public static String envData = System.getProperty("env");
    public static String driverType = System.getProperty("browser");
    public static String url;

    @Before
    public void openBrowser() {
        //default env set
        if (Strings.isNullOrEmpty(envData)) {
            envData = "qa";
        }
        //default browser set
        if (Strings.isNullOrEmpty(driverType)) {
            driverType = "ch";
        }
        driver = setupDriver(driverType);

        switch (envData) {
            case "qa":
                url = "http://qa.taltektc.com";
                break;
            case "stg":
                url = "http://stage.taltektc.com";
                break;
            case "prd":
                url = "http://prod.taltektc.com";
                break;
        }

        driver.get(url);
    }

    @After
    public void tearDown(Scenario scenario){
        try{
            if(scenario.isFailed())
            {
                final byte [] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        }
        finally {
            driver.quit();
        }
    }


}
