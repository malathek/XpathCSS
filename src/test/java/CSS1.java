import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Xpath1 {

    WebDriver driver;

    @BeforeTest
    public void OpenBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }

@Test(groups="QA")
@Description("Xpath Learn")
    public void xpath(){

    driver.navigate().to("https://awesomeqa.com/xpath/");
    WebElement self = driver.findElement(By.xpath("//div[@class='Mammal']/h4"));

    System.out.println(self.getText());

    //preceding-sibling
    WebElement preceSibli = driver.findElement(By.xpath("//div[@class='Mammal']/preceding-sibling::div[@class='Fish']"));

    System.out.println(preceSibli.getText());

    //following-sibling
    WebElement followSibli = driver.findElement(By.xpath("//div[@class='Mammal']/following-sibling::div[@class='Other']"));

    System.out.println(followSibli.getText());

    //child
    List<WebElement> child =  driver.findElements(By.xpath("//div[@class='Mammal']/child::div/h5"));

    for (WebElement childNew: child){
        System.out.println(childNew.getText());
    }

    //grandchild
   List<WebElement> grandchild = driver.findElements(By.xpath("//div[@class='Mammal']/descendant::div/h6"));
    //

    for (WebElement grandchildNew: grandchild){
        System.out.println(grandchildNew.getText());
    }
//ancestor
    WebElement anchest = driver.findElement(By.xpath("//div[@class='Mammal']/ancestor::div/h2"));

    System.out.println(anchest.getText());

}
 @AfterTest
    public void CloseBrowser(){
     driver.quit();
 }
}
