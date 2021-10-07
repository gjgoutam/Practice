package SelPractice;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CodingChallenge2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		CodingChallenge2 cc = new CodingChallenge2();

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.noon.com/uae-en/");
		String path = "//*[@class='sc-fbNXWD fictCR']";
		cc.jsScrollintoView(driver, path);
		List<WebElement> ItemList = driver.findElements(By.xpath("//*[@data-qa='product-name']"));
		System.out.println(ItemList.size() + "--");
		for (int i = 0; i < ItemList.size(); i++) {
			System.out.println(ItemList.get(i).getAttribute("title"));
		}

		 path = "(//*[@class='sc-dlfnbm hRlTQS'])[2]"; cc.jsScrollintoView(driver,path); 
		// driver.quit();
		 
	}

	public void jsScrollintoView(WebDriver driver, String path) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		do {
			try {
				WebElement element = driver.findElement(By.xpath(path));
				js.executeScript("arguments[0].scrollIntoView();", element);
				Thread.sleep(5000);
				break;
			} catch (NoSuchElementException e) {
				action.sendKeys(Keys.PAGE_DOWN).perform();
			}
		} while (true);
	}

}
