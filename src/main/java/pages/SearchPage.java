package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage {
	private WebDriver driver;
	private By googlLogo = By.id("hplogo");
	private By searchBox = By.name("q");

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}


	public String pageTitle() {
		return driver.getTitle();
	}

	public boolean googleLogoIsDisplayed() {
		return driver.findElement(googlLogo).isDisplayed();
	}
	public void searchForQuery(String searchInput) 
	{
		driver.findElement(searchBox).sendKeys(searchInput,Keys.RETURN);
	}

}
