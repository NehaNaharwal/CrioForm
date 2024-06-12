package demo;

import java.time.Duration;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    @Test
    public void testCase01() throws InterruptedException{
        System.out.println("Start of testCase01");
        //navigate to google form
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        //Enter name
        WebElement name = driver.findElement(By.xpath("//input[@aria-labelledby='i1' and contains(@class, 'whsOnd zHQkBf')]"));
        Thread.sleep(2000);
        name.click();
        name.sendKeys("Crio Learner");
        //practicing automation
        WebElement automation = driver.findElement(By.xpath("//textarea[@aria-labelledby='i5' and contains(@class, 'KHxj8b tL9Q4c')]"));
        Thread.sleep(2000);
        automation.click();
        automation.sendKeys("I want to be the best QA Engineer! 1718128346");
        //experience
        driver.findElement(By.xpath("//div[contains(@id, 'i13')]")).click();
        Thread.sleep(2000);
        //skills java, selenium, testNG
        driver.findElement(By.xpath("//div[contains(@id, 'i30')]")).click();
        driver.findElement(By.xpath("//div[contains(@id, 'i33')]")).click();
        driver.findElement(By.xpath("//div[contains(@id, 'i39')]")).click();
        //addressed by
        driver.findElement(By.xpath("//span[contains(text(), 'Choose')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[2]/div[4]")).click();
        Thread.sleep(1000);
        //date
        WebElement date = driver.findElement(By.xpath("//input[@aria-labelledby='i50']"));
        // Perform Tab key action
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.sendKeys(Keys.TAB).perform();
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].value = '2024-06-05';", date);
        date.sendKeys("05-06-2024");
        Thread.sleep(1000);
        //time hour, minute
        WebElement hour = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        hour.click();
        hour.sendKeys("07");
        WebElement minute = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        minute.click();
        minute.sendKeys("30");
        //click on submit
        driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Thanks for your response, Automation Wizard!')]")));
        String successMessage = message.getText();
        if(successMessage.contains("Thanks for your response, Automation Wizard!")){
            System.out.println("Thanks for your response, Automation Wizard!");
        }

        System.out.println("End of testCase01");

    
    }

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}