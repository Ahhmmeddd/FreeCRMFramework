package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests
{
    public static WebDriver driver ;

    public static String downloadPath = System.getProperty("user.dir")+"\\Downloads";


    public static FirefoxOptions firefoxOption() {
        FirefoxOptions option = new FirefoxOptions();
        option.addPreference("browser.download.folderList", 2);
        option.addPreference("browser.download.dir", downloadPath);
        option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
        option.addPreference("browser.download.manager.showWhenStarting", false);
        option.addPreference("pdfjs.disabled", true);
        return option;
    }

    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return options;
    }

    @Parameters({"browser"})
    @BeforeSuite
    public void startDriver(@Optional("chrome") String browserName)
    {
        if (browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromeDriver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
             options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Drivers/geckoriver.exe");
            driver = new FirefoxDriver(firefoxOption());
            
        } else if (browserName.equalsIgnoreCase("ie"))
        {
            System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/Drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            
        }
        else if (browserName.equalsIgnoreCase("headless"))
        {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setJavascriptEnabled(true);
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY
                    ,System.getProperty("user.dir")+"/phantomjsDriver/phantomjs.exe");
            String[] phantomJSArgs = {"--web-security=no","ignore-ssl-errors=yes"};
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,phantomJSArgs);
            driver = new PhantomJSDriver(caps);
        }

        else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to("https://classic.freecrm.com/");

    }
    @AfterSuite
    public void stopDriver()
    {
        driver.quit();
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName());
        }
    }

}
