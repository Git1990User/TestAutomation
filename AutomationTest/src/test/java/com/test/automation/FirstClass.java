package com.test.automation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;


public class FirstClass  extends ExtentReportBaseClass  {
	
	WebDriver driver;
	public int statuscode=0;
	String rating="";
	@Test(priority=1)
	 public void ResponseCode() {
	test = extent.createTest("Check Response code", "Checking response code of url"); 
	driver=POMClass.setup();
	POMClass.setURL();
	statuscode=GetResponseCode(POMClass.gettURL());
	test.log(Status.INFO, "Response code is: "+ statuscode);
	
	}
	
	@Test(priority=2)
 public void Search() {
	SoftAssert	sf=new SoftAssert();
	 if(statuscode==200) {
		 POMClass.textfield(driver).click();
		 POMClass.textfield(driver).sendKeys(POMClass.query());
		/* WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.visibilityOf(POMClass.searchResult(driver)));
			*/
		 POMClass.textfield(driver).sendKeys(Keys.ENTER);
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 sf.assertEquals((POMClass.searchResult(driver)).getText(), "IMDb");
		rating=POMClass.rating(driver).getText();	
		System.out.println(rating);
	 }
		
 }
	@Test(priority=3)
	public void Verify() {
	SoftAssert	sf=new SoftAssert();
	String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
	POMClass.searchResult(driver).sendKeys(clicklnk);	
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs.get(1));
	//verify title
	sf.assertEquals((POMClass.title(driver)).getText(), "After Life");
	//verify rating
	sf.assertEquals((POMClass.ratingOnPage(driver)).getText(), rating);
	//verify genre
	sf.assertEquals((POMClass.genre1(driver)).getText(), "Comedy");
	sf.assertEquals((POMClass.genre2(driver)).getText(), "Drama");
	POMClass.castlink(driver).click();
	sf.assertEquals((POMClass.castPageTitle(driver)).getText(), "Full Cast & Crew");
	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 sf.assertEquals((POMClass.locateDirector(driver)).getText(), "Ricky Gervais");
	 //verify details
	 sf.assertEquals((POMClass.locateActor(driver)).getText(), "Ricky Gervais");
	 sf.assertEquals((POMClass.locateRole(driver)).getText(), "Tony Johnson");
	 sf.assertEquals((POMClass.locateEpisode(driver)).getText(), "18 episodes");
	}
	
	@Test(priority=4)
	public void checkURLs() {
		POMClass.OpenHIstory(driver);
		List<WebElement> allLinks=POMClass.GetAllUrls(driver);
		 for(WebElement link:allLinks){
			 System.out.println(link.getText() + " - " + link.getAttribute("href"));
			 }
	}
	
 public int GetResponseCode(String url) {
	 HttpURLConnection cn = null;
		try {
			cn = (HttpURLConnection)new URL(url).openConnection();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // set HEADER request
	    try {
			cn.setRequestMethod("HEAD");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // connection initiate
	    try {
			cn.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //get response code
	    int res = 0;
		try {
			res = cn.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	return res;	
	 
	 
 }
 
}

 
