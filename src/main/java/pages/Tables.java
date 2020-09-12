package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tables {
	private WebDriver driver;

	public Tables(WebDriver driver) {
		this.driver = driver;
	}

	public String findSpecificCellInTable(String companyName, int requiredCell) {
		 return driver.findElement(By.xpath("//table[@id='customers']//tr/td[text()='" + companyName
				+ "']/following-sibling::td[" + requiredCell + "]")).getText();
	}

}
