package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	private WebDriver driver;
	private By drag = By.xpath("//div[@id='draggable']/p");
	private By drop = By.xpath("//div[@id='droppable']/p");
	private By dropMessage = By.xpath("//div[@id='droppable']/p");

	public DragAndDrop(WebDriver driver) {
		this.driver = driver;

	}

	public String dragAndDrop() {

		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(drag), driver.findElement(drop)).build().perform();
		return driver.findElement(dropMessage).getText();

	}
}
