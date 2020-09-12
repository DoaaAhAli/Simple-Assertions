package AutomationTasks;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DragAndDrop;
import pages.NavigateTo;
import pages.SearchPage;
import pages.SearchResult;
import pages.Tables;
import pages.UploadFile;

public class NewTest {
	WebDriver driver;
	SearchPage search;
	SearchResult result;
	NavigateTo navigation;
	Tables table;
	UploadFile upload;
	DragAndDrop drag;

	@BeforeClass
	public void setProperty() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");

	}

	@BeforeMethod(onlyForGroups = "Firefox")
	public void firefoxSetup() {
		driver = new FirefoxDriver();
		search = new SearchPage(driver);
		result = new SearchResult(driver);
		navigation = new NavigateTo(driver);


	}

	@BeforeMethod(onlyForGroups = "Chrome")
	public void chromeSetup() {
		driver = new ChromeDriver();
		search = new SearchPage(driver);
		result = new SearchResult(driver);
		navigation = new NavigateTo(driver);
		table = new Tables(driver);
		upload = new UploadFile(driver);
		drag = new DragAndDrop(driver);

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@Test(groups = { "Chrome" })
	public void pageTitle() {
		navigation.navigate("https://www.google.com/ncr");
		assertEquals(search.pageTitle(), "Google");

	}

	@Test(groups = { "Chrome" })
	public void pageLogo() {
		navigation.navigate("https://www.google.com/ncr");
		assertTrue(search.googleLogoIsDisplayed());

	}

	@Test(groups = { "Chrome" })
	public void seleniumSearch() {
		navigation.navigate("https://www.google.com/ncr");
		search.searchForQuery("Selenium WebDriver");
		assertEquals(result.findSpecificSearchQueryText(1), "Selenium Projects");

	}

	@Test(groups = { "Chrome" })
	public void cucumberSearch() {
		navigation.navigate("https://www.google.com/ncr");
		search.searchForQuery("Cucumber IO");
		result.navigateBetweenSearchResultPages("2");
		assertTrue(result.findSpecificSearchQuerylink(3).contains("https://www.linkedin.com"));
	}

	@Test(groups = { "Chrome" })
	public void country() {
		navigation.navigate("https://www.w3schools.com/html/html_tables.asp");
		assertEquals(table.findSpecificCellInTable("Ernst Handel", 2), "Austria");

	}

	@Test(groups = { "Chrome" })
	public void uploadImage() {
		navigation.navigate("http://the-internet.herokuapp.com/upload");
		assertEquals(upload.uploadfile(), "File Uploaded!");
	}

	@Test(groups = { "Chrome" })
	public void dragDrop() {
		navigation.navigate("https://jqueryui.com/resources/demos/droppable/default.html");
		assertEquals(drag.dragAndDrop(), "Dropped!");
	}

	@Test(groups = { "Firefox" })
	public void tesNgSearch() {
		navigation.navigate("https://www.google.com/ncr");
		search.searchForQuery("TestNG Tutorial");
		assertTrue(result.findSpecificSearchQueryText(1).contains("TestNG Tutorial"));

	}
}
