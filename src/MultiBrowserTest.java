import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {

    static String browser = "firefox";

    static String baseurl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    static WebDriver driver;

    //1. Setup chrome browser
    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "drives/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.Firefox.driver", "drives/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("weddriver.Edge.driver", "drives/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name");
        }
        //2. Open URL
        driver.get(baseurl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        // 3. Print the title of the page
        String title = driver.getTitle();
        System.out.println("page title is:" + title);

        //4. Print the current url
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //5. Print the page source
        System.out.println("page source:" + driver.getPageSource());

        //6. Enter the email to email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("kishan_0204@yahoo.co.in");

        //7. Enter the password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("kishan");

        //8. Close the browser
        driver.quit();

    }
}


