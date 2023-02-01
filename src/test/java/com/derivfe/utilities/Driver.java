package com.derivfe.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {


    /**
     * 1- creating a private constructor,
     * so we're closing access to the object of this class from outside of any classes
     */
    private Driver() {
    }

    /**
     * 2- making Driver instance private that is not reachable form outside of any class
     * we made it Static, because we want it to run before anything else
     * also we're going to use it in Static method
     */
    private static WebDriver driver;


    /**
     * 3- create reusable get() wich will return the same driver when we call it
     * if driver(browser) equals null, means has not been opened yet
     * we will use switch statement to switch browsers
     * depending on browser type, our switch statement will determine which type of browser to open
     */
    public static WebDriver getDriver() {

        if (driver == null) {

            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    driver = new ChromeDriver(options);
                    options.addArguments("--lang=en");
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();

                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

            }
            driver.manage().window().maximize();
            // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver; // same driver instance will be returned every time we call Driver.getDriver()

    }

    public static void closeDriver() {
        if (driver != null)
            driver.quit();
        driver = null;
    }

}
