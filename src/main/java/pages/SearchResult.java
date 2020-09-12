package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResult {
	private WebDriver driver;
	private By searchResult;

	public SearchResult(WebDriver driver) {
		this.driver = driver;
	}
	public void navigateBetweenSearchResultPages(String pageIndex) {
		driver.findElement(By.linkText(pageIndex)).click();
	}
	public String findSpecificSearchQueryText(int searchIndex) {
		searchResult = By.xpath("(//h1[text()='Search Results']/following-sibling::div/div[@class='g']//h3)["+searchIndex+"]");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.findElement(searchResult).getText();
	}
	public String findSpecificSearchQuerylink(int searchIndex) {
		searchResult = By.xpath("(//h1[text()='Search Results']/following-sibling::div/div[@class='g']//div[@class='r']/a)["+searchIndex+"]");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.findElement(searchResult).getAttribute("href");
	}

}
