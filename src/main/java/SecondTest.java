import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SecondTest {


    @Test
    public void checkMindPaymentSu(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        driver.get("https://next.privat24.ua/money-transfer/card");


        By amount = By.xpath("//input[@data-qa-node='amount']");
        By cardNumber = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By expDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By receiver = By.xpath("//input[@data-qa-node='numberreceiver']");
        By toggleComment = By.xpath("//span[@data-qa-node='toggle-comment']");
        By comment = By.xpath("//textarea[@data-qa-node='comment']");
        By submitBtn = By.xpath("//button[@type='submit']");


        driver.findElement(amount).sendKeys("500");
        driver.findElement(cardNumber).sendKeys("4558032855841715");
        driver.findElement(expDate).sendKeys("0223");
        driver.findElement(cvv).sendKeys("902");
        driver.findElement(receiver).sendKeys("4006895689048337");
        driver.findElement(toggleComment).click();
        driver.findElement(comment).sendKeys("TESTTEST");
        driver.findElement(submitBtn).submit();

        Assert.assertEquals("4558 0328 5584 1715", driver.findElement(By.xpath("//span[@data-qa-node='payer-card']")).getText());
        Assert.assertEquals("4006 8956 8904 8337", driver.findElement(By.xpath("//span[@data-qa-node='receiver-card']")).getText());
        Assert.assertEquals("500 UAH", driver.findElement(By.xpath("//div[@data-qa-node='payer-amount']")).getText());
        Assert.assertEquals("500 UAH", driver.findElement(By.xpath("//div[@data-qa-node='receiver-amount']")).getText());
        Assert.assertEquals("106.72 UAH", driver.findElement(By.xpath("//div[@data-qa-node='payer-currency']")).getText());
        Assert.assertEquals("0 UAH", driver.findElement(By.xpath("//div[@data-qa-node='receiver-currency']")).getText());
        Assert.assertEquals("606.72 UAH", driver.findElement(By.xpath("//div[@data-qa-node='total']")).getText());
        Assert.assertEquals("TESTTEST", driver.findElement(By.xpath("//div[@data-qa-node='comment']")).getText());
    }

}