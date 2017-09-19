package core;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplrerDriver;
import org.openqa.selenium.safari.*;

public class CrossBrowser {
         static WebDriver driver;
         public static void setWebDriver(String browser) throws IOException {
                String driverPath = "";
        if ((browser == "Firefox") && (System.getProperty("os.name").contains("MAC")))
                 driverPath = "./src/main/resources/webdrivers/mac/geckodriver.sh";
else if ((browser == "Firefox") && (System.getProperty("os.name").contains("WINDOWS")))
                 driverPath = "./src/main/resources/webdrivers/pc/geckodriver.sh";
else if ((browser == "Chrome") && (System.getProperty("os.name").contains("MAC")))
                 driverPath = "./src/main/resources/webdrivers/mac/chromedriver.sh";
else if ((browser == "Chrome") && (System.getProperty("os.name").contains("WINDOWS")))
                 driverPath = "./src/main/resources/webdrivers/pc/chromedriver.sh";
else if ((browser == "Safari") && (System.getProperty("os.name").contains("MAC"))) {}
else if ((browser == "Safari") && (System.getProperty("os.name").contains("WINDOWS")))
                 throw new IllegalArgumentException("IE is not available for Windows");
else if ((browser == "IE") && (System.getProperty("os.name").contains("MAC")))
                  throw new IllegalArgumentException("IE is not available for macOS");
else if ((browser == "IE") && (System.getProperty("os.name").contains("WINDOWS")))
                 driverPath = "./src/main/resources/webdrivers/pc/geckodriver.sh";
else if ((browser == "Edge") && (System.getProperty("os.name").contains("MAC")))
                 throw new IllegalArgumentException("Edge is not available for macOS");
else if ((browser == "Edge") && (System.getProperty("os.name").contains("WINDOWS")))
                 driverPath = "./src/main/resources/webdrivers/pc/geckodriver.sh";  
else if (browser == "HtmlUnit") {}
else throw new IllegalArgumentexeption();
                 switch (browser) {
                 case "Firefox":
                       System.setProperty("webdriveer.gecko.driver", driverPath);
                       driver = new FirefoxDriver();
                       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); break;
                 case "Chrome":
                       System.setProperty("wedriver.chrome.driver", driverPath);
                       driver = new ChromeDriver();
                       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); break;
                 case "Safari":
                	   driver = new SafariDriver();
                	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); break; 
                 case "IE":
                	    System.setProperty("webdriver.ie.driver",  driverPath);
                	    driver = new InternetExplorerDriver();
                	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); break;
                 case "Edge":
                    	 System.setProperty("webdriver.edge.driver",  driverPath);
                    	 driver = new EdgeDriver();
                    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); break;
                 case "HtmlUnit":
                driver = new HtmlUnitDriver();((HtmlUnitDriver) driver).setJavascriptEnable(true); break;
                default: throw new IllegalArgumentException("Unknown Browser");}
         }
         public static void main(String[] args) throws IOException {
        	 String in_browser = System.getProperty("browser"); //Firefox|Chroome|Safari|IE|Edge
        	 setWebDriver(in_browser);
        	 driver.get("http://alexacademy/ua");
        	 String ua = driver.findElement(By.id("id_ua")).getText();
        	 System.out.println("User Agent: " + ua); if (driver != null) driver.quit();
              }
         }
                	   
                	   