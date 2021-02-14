package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
    public static WebDriver createDriver(String browserName) {
        return createDriver(browserName, new DesiredCapabilities());
    }

    public static WebDriver createDriver(String browserName, DesiredCapabilities options) {
        browserName = browserName.toUpperCase();
        switch (Browsers.valueOf(browserName)) {
            case CHROME: {
                return getChromeDriver(new ChromeOptions().merge(options));
            }
            case FIREFOX: {
                return getFirefoxDriver(new FirefoxOptions().merge(options));
            }
            case EDGE: {
                return  getEdgeDriver(new EdgeOptions().merge(options));
            }
            case OPERA: {
                return getOperaDriver(new OperaOptions().merge(options));
            }
            default: {
                return getChromeDriver(new ChromeOptions());
            }
        }
    }

    private static ChromeDriver getChromeDriver (ChromeOptions options) {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    private static FirefoxDriver getFirefoxDriver (FirefoxOptions options) {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(options);
    }

    private static EdgeDriver getEdgeDriver (EdgeOptions options) {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(options);
    }

    private static OperaDriver getOperaDriver (OperaOptions options){
        WebDriverManager.operadriver().setup();
        return new OperaDriver(options);
    }
}
