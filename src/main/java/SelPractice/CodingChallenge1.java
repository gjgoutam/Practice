package SelPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CodingChallenge1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.worldometers.info/world-population/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		CodingChallenge1 c1 = new CodingChallenge1();
		int i=0;
		
		do{
		String text = c1.getTextFromElement("//*[@id=\"maincounter-wrap\"]/div/span", driver);
		text = text.replace(",","");
		System.out.println(i+" "+text);
		i++;
		Thread.sleep(5000);
		}while(i<5);
		
		driver.quit(); 
		
	}
	
	public String getTextFromElement(String xpath1, WebDriver driver) {
		
		return driver.findElement(By.xpath(xpath1)).getText();
		
	}
}
