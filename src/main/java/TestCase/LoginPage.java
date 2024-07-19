package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPage extends BaseClass {
	@Parameters ({"username","password"})
	@Test
	public void runLoginPage(String username, String password) throws InterruptedException {
		// Click make appointment
		driver.findElement(By.xpath("//a[@id='btn-make-appointment']")).click();

		// give the Username on placeholder
		WebElement usernamebtn = driver.findElement(By.id("txt-username"));
		usernamebtn.click();
		usernamebtn.sendKeys(username);

		// give the password on placeholder
		WebElement passwordbtn = driver.findElement(By.id("txt-password"));
		passwordbtn.click();
		passwordbtn.sendKeys(password);

		// Click the login button
		driver.findElement(By.xpath("//button[@id='btn-login']")).click();

		// Select the require the hospital
		WebElement facilitydropdown = driver.findElement(By.id("combo_facility"));
		Select objdown = new Select(facilitydropdown);
		objdown.selectByIndex(1);

		// select the readmission button
		driver.findElement(By.id("chk_hospotal_readmission")).click();

		// select the health program check button
		driver.findElement(By.xpath("//label[normalize-space()='Medicaid']")).click();

		// select the required date on datepicker
		String month = "August 2024";
		String day = "6";

		driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-calendar']")).click();
		Thread.sleep(3000);
		while (true) {
			String text = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/table[1]/thead[1]/tr[2]/th[2]"))
					.getText();
			if (text.equals(month)) {
				break;
			} else {
				driver.findElement(
						By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")).click();
			}
		}

		driver.findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td[contains(text()," + day + ")]"))
				.click();

		// input the comment on placeholder
		WebElement comment = driver.findElement(By.id("txt_comment"));
		comment.click();
		comment.sendKeys("I need a apointment with ENT ");

		// click the submit button
		driver.findElement(By.id("btn-book-appointment")).click();

		// click return hompage button
		driver.findElement(By.xpath("//a[normalize-space()='Go to Homepage']")).click();
		
		

	}
}
