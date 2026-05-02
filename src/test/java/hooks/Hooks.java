package hooks;

import com.qa.factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Hooks {

    private Driverfactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getproperty() throws IOException {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser(){
        String browserName = prop.getProperty("browser");
        driverFactory = new Driverfactory();
        driver = driverFactory.init_driver(browserName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @After(order = 1)
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcepath, "image/png", screenshotName);
            File srcFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(srcFile,
                        new File("target/screenshots/" + screenshotName + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }
}