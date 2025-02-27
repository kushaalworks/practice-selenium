package com.selenium.tests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestAutomationBlogSpotPractice {

	static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {

		start();

		enterUserDetails("JP", "eaddress@123.com", "9888", "address123");

		// User input: Days to be selected
		List<String> userSelectedDays = Arrays.asList("monday", "wednesday", "friday");

		selectDays(userSelectedDays);

		String country = "Germany";

		selectCountry(country);

		String bookName = "Master In Java";

		verifyIfBookNameIsAvailableInTheTable(bookName);

		// User input: Product to be chosen on the paginated table:
		String producToBeChosen = "Soundbar";

		selectProductInThePaginatedTable(producToBeChosen);

		// stop();

	}

	static void start() {
		driver.get("https://testautomationpractice.blogspot.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

	}

	static void enterUserDetails(String username, String emailId, String phone, String address)

	{
		driver.findElement(By.xpath("//input[@class='form-control' and @id='name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@class='form-control' and @id='email']")).sendKeys(emailId);
		driver.findElement(By.xpath("//input[@class='form-control' and @id='phone']")).sendKeys(phone);
		driver.findElement(By.xpath("//div[@class='form-group']//textarea[@id='textarea']")).sendKeys(address);
		driver.findElement(By.xpath("//input[@class='form-check-input' and @id='male']")).click();
	}

	static void selectDays(List<String> userSelectedDays) {
		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		for (WebElement checkbox : checkboxes) {
			String dayText = checkbox.getAttribute("value");
			// System.out.println("Checkbox Value: " + dayText);

			if (userSelectedDays.contains(dayText)) {
				if (!checkbox.isSelected()) { // Avoid re-selecting already checked checkboxes
					checkbox.click();
					System.out.println("Selected: " + dayText);
				}
			}
		}
	}

	static void selectCountry(String country) {

		WebElement countryDropDown = driver.findElement(By.xpath("//select[@class='form-control' and @id='country']"));
		Select dropDown = new Select(countryDropDown);
		dropDown.selectByVisibleText(country);
	}

	static void verifyIfBookNameIsAvailableInTheTable(String bookName) {
		int noOfRows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();

		for (int r = 2; r < noOfRows; r++) {
			String tableData = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[1]"))
					.getText();
			if (bookName.equals(tableData)) {
				System.out.println("BookName: " + tableData);
			}
		}
	}

	static void selectProductInThePaginatedTable(String productToBeChosen) throws InterruptedException {
		int pages = driver.findElements(By.xpath("//ul[@class='pagination']//a")).size();

		System.out.println("No.of pages in the paginated table is: " + pages);

		for (int p = 1; p <= pages; p++) {
			if (p > 1) {
				driver.findElement(By.xpath("//ul[@class='pagination']//*[text()=" + p + "]")).click();
				Thread.sleep(3000);
			}

			int rows = driver.findElements(By.xpath("//table[@id='productTable']//tr")).size();

			for (int r = 1; r < rows; r++) {
				String productName = driver
						.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + r + "]//td[2]")).getText();
				if (productToBeChosen.equals(productName)) {
					driver.findElement(By.xpath("//tbody//tr[" + r + "]//td[4]//input[@type='checkbox']")).click();

				}

			}
		}

	}

	static void stop() {

		driver.quit();

	}

}
