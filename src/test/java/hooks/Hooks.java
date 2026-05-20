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

//    private Driverfactory driverFactory;
//    private WebDriver driver;
//    private ConfigReader configReader;
//    Properties prop;
//
//    @Before(order = 0)
//    public void getproperty() throws IOException {
//        configReader = new ConfigReader();
//        prop = configReader.init_prop();
//    }
//
//    @Before(order = 1)
//    public void launchBrowser(){
//        String browserName = prop.getProperty("browser");
//        driverFactory = new Driverfactory();
//        driver = driverFactory.init_driver(browserName);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
//
//
//    @After(order = 1)
//    public void tearDown(Scenario scenario){
//        if(scenario.isFailed()) {
//            String screenshotName = scenario.getName().replaceAll(" ", "_");
//            byte[] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(sourcepath, "image/png", screenshotName);
//            File srcFile = ((TakesScreenshot) driver)
//                    .getScreenshotAs(OutputType.FILE);
//            try {
//                FileUtils.copyFile(srcFile,
//                        new File("target/screenshots/" + screenshotName + ".png"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    @After(order = 0)
//    public void quitBrowser(){
//        driver.quit();
//    }
//}

    private ConfigReader configReader;
    private Properties prop;

    @Before(order = 0)
    public void getProperty() throws IOException {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        Driverfactory driverFactory = new Driverfactory();
        driverFactory.init_driver(browserName);
        // ✅ No local 'driver' variable — everything goes through Driverfactory.getDriver()
        Driverfactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Browser launched on thread: " + Thread.currentThread().getId());
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        // ✅ Always fetch from ThreadLocal
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourceBytes = ((TakesScreenshot) Driverfactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourceBytes, "image/png", screenshotName);

            File srcFile = ((TakesScreenshot) Driverfactory.getDriver())
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
    public void quitBrowser() {
        // ✅ Uses new quitDriver() which also calls tlDriver.remove()
        Driverfactory.quitDriver();
        System.out.println("Browser quit on thread: " + Thread.currentThread().getId());
    }
}