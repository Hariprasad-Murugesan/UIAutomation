package TestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class FrontPage extends BaseClass {
	@Test
	public  void runFrontPage() throws InterruptedException {

		
		// Make appointment button on HomePage
		driver.findElement(By.id("btn-make-appointment")).click();

		// Wait for 5 seconds
		Thread.sleep(5000);

		// Navigate back
		driver.navigate().back();

		// Slide option button
		WebElement slideOptionButton = driver.findElement(By.xpath("//i[@class='fa fa-bars']"));
		slideOptionButton.click();

		// Wait for elements to be clickable

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// To the Home button is clickable

		WebElement makeAppointmentButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Home']")));
		if (makeAppointmentButton != null) {
			System.out.println("The 'Home' link is clickable.");
		} else {
			System.out.println("The 'Home' link is not clickable.");
		}
		makeAppointmentButton.click();

	

	}
}
