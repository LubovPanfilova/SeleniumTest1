import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstTest {

    @Test
    public void checkMindPaymentSu(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://next.privat24.ua/mobile");
        By phoneNumer = By.xpath("//input[@data-qa-node='phone-numer']");
        By amount = By.xpath("//input[@data-qa-node='amount']");
        By cardNumber = By.xpath("//input[@data-qa-node='numberdebitSourse']");
        By expDate = By.xpath("//input[@data-qa-node='expiredebitSourse']");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSourse']");
        By firstName = By.xpath("//input[@data-qa-node='firstNamebitSourse']");
        By lastName = By.xpath("//input[@data-qa-node='lastNamedebitSourse']");
        By submitBnt = By.xpath("//button[@data-qa-node='submit']");



        driver.findElement(phoneNumer).sendKeys("957088872");
        driver.findElement(amount).sendKeys("1");
        driver.findElement(cardNumber).sendKeys("4006895689048337");
        driver.findElement(expDate).sendKeys("0225");
        driver.findElement(cvv).sendKeys("111");
        driver.findElement(firstName).sendKeys("Olga");
        driver.findElement(lastName).sendKeys("Ivanova");
        driver.findElement(submitBnt).click();


    driver.close();

  }

}