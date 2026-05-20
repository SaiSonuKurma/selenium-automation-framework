package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driverfactory {

//    public WebDriver driver;
//
//    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
//
//    public WebDriver init_driver(String browser) {
//
//        System.out.println("Browser is: " + browser);
//
//        if (browser.equals("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            tlDriver.set(new ChromeDriver());
//        } else if (browser.equals("edge")) {
//            WebDriverManager.edgedriver().setup();
//            tlDriver.set(new EdgeDriver());
//        } else if (browser.equals("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            tlDriver.set(new FirefoxDriver());
//        } else {
//            System.out.println("Enter the correct browser name:" + browser);
//        }
//        getDriver().manage().deleteAllCookies();
//
//        getDriver().manage().window().maximize();
//        return getDriver();
//    }
//    public static WebDriver getDriver(){
//        return tlDriver.get();
//    }

    // ✅ Removed unused instance variable 'driver'
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser) {
        System.out.println("Browser: " + browser + " | Thread: " + Thread.currentThread().getId());

        boolean isCI = System.getenv("CI") != null;

        switch (browser.toLowerCase().trim()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeoptions = new ChromeOptions();
                if (isCI){
                    chromeoptions.addArguments("--headless=new");
                    chromeoptions.addArguments("--no-sandbox");
                    chromeoptions.addArguments("--disable-dev-shm-usage");
                    chromeoptions.addArguments("--disable-gpu");
                    chromeoptions.addArguments("--window-size=1920,1080");
                }
                tlDriver.set(new ChromeDriver(chromeoptions));
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                tlDriver.set(new EdgeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver());
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    // ✅ Added quit — always clean up ThreadLocal after use
    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove(); // Prevents memory leak
        }
    }

}
