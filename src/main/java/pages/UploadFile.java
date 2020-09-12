package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadFile {
	private WebDriver driver;
	private By selectFileBtn = By.name("file");
	private By uploadFileBtn = By.id("file-submit");
	private By uploadedMessage = By.tagName("h3");
	public UploadFile(WebDriver driver)
	{
		this.driver = driver;
	}
	public String uploadfile() {
		driver.findElement(selectFileBtn).sendKeys("/home/doaa/Desktop/download.png");
		driver.findElement(uploadFileBtn).click();
		return driver.findElement(uploadedMessage).getText();
	}

}
