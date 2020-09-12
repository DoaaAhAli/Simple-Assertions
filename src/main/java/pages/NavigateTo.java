package pages;

import org.openqa.selenium.WebDriver;

public class NavigateTo {
	private WebDriver driver;
	public NavigateTo(WebDriver driver) {
		this.driver = driver;
	}

	public void navigate(String url) {
		driver.navigate().to(url);
	}

}
