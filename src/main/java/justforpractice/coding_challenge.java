package justforpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class coding_challenge {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/bekturyusupov/IdeaProjects/Drivers/chrome-mac-117/chromedriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();



    }
}
