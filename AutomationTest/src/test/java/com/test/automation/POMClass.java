package com.test.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class POMClass {
	static WebDriver driver;
	static String url;
	static String q="After Life";
	static WebElement element = null;

	public POMClass() {
		
		}

	
public static WebDriver setup() {
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.manage().window().maximize();
return driver;
}

public static String  setURL() {
	url="https://www.google.com/";
	driver.get(url);
	return url;
}
public static String  gettURL() {

	return url;
}
public static String query() {
	
	return q;
}


public static WebElement textfield(WebDriver driver){

    element = driver.findElement(By.name("q"));

    return element;

    }
public static WebElement searchResult(WebDriver driver){

    element = driver.findElement(By.xpath("//*[@class='NY3LVe']"));

    return element;

    }
public static WebElement rating(WebDriver driver){

    element = driver.findElement(By.xpath("//span[@class='gsrt IZACzd']"));

    return element;

    }

public static WebElement title(WebDriver driver){

    element = driver.findElement(By.xpath("//h1"));

    return element;

    }
public static WebElement ratingOnPage(WebDriver driver){

    element = driver.findElement(By.xpath("//span[@class='AggregateRatingButton__RatingScore-sc-1ll29m0-1 iTLWoV']"));

    return element;

    }

public static WebElement genre1(WebDriver driver){

    element = driver.findElement(By.xpath("//span[@class='ipc-chip__text']"));

    return element;

    }
public static WebElement genre2(WebDriver driver){

    element = driver.findElement(By.xpath("//span[@class='ipc-chip__text']"));

    return element;

    }
public static WebElement castlink(WebDriver driver){

    element = driver.findElement(By.xpath("(//*[@class='ipc-link ipc-link--baseAlt ipc-link--inherit-color'])[1]"));

    return element;

    }

public static WebElement castPageTitle(WebDriver driver){

    element = driver.findElement(By.xpath("//h1[@class='header']"));

    return element;

    }
public static WebElement locateTable(WebDriver driver){

    element = driver.findElement(By.xpath("(//table[@class='simpleTable simpleCreditsTable']"));

    return element;

    }
public static WebElement locateDirector(WebDriver driver){
	
	WebElement htmltable = driver.findElement(By.tagName("table"));
	// check if any record appear in the table
	List<WebElement> tableRows = htmltable.findElements(By.xpath("//table/tbody/tr"));
	tableRows.get(0).findElement(By.xpath("//table[1]/tbody/tr/td[1]"));
    return element;

    }
public static WebElement locateActor(WebDriver driver){
	
	WebElement htmltable = driver.findElement(By.xpath("//table[@class='cast_list']"));
	// check if any record appear in the table
	List<WebElement> tableRows = htmltable.findElements(By.xpath("//table/tbody/tr"));
	tableRows.get(0).findElement(By.xpath("//table[3]/tbody/tr[2]/td[2]"));
    return element;

    }
public static WebElement locateRole(WebDriver driver){
	
	WebElement htmltable = driver.findElement(By.xpath("//table[@class='cast_list']"));
	// check if any record appear in the table
	List<WebElement> tableRows = htmltable.findElements(By.xpath("//table/tbody/tr"));
	tableRows.get(0).findElement(By.xpath("//table[3]/tbody/tr[2]/td[4]/a[1]"));
    return element;

    }
public static WebElement locateEpisode(WebDriver driver){
	
	WebElement htmltable = driver.findElement(By.xpath("//table[@class='cast_list']"));
	// check if any record appear in the table
	List<WebElement> tableRows = htmltable.findElements(By.xpath("//table/tbody/tr"));
	tableRows.get(0).findElement(By.xpath("//table[3]/tbody/tr[2]/td[4]/a[2]"));
    return element;

    }
public static void OpenHIstory(WebDriver driver){
	
	
	driver.get("chrome://history/");

    }

public static List<WebElement> GetAllUrls(WebDriver driver){
	
	
	List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	return allLinks;

    }

}
