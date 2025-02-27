# practice-selenium
# Test Automation BlogSpot Practice 🚀
This repository contains Selenium automation scripts that interact with the **Test Automation Practice** website. The scripts demonstrate various **Selenium WebDriver functionalities**, such as handling tables, dropdowns, alerts, and more.

## 📌 Features Covered
Features Covered:
✅ Browser Setup & Navigation
Launch and maximize browser (start())
Set implicit wait (start())
Close browser session (stop())

✅ Form Handling
Enter user details (name, email, phone, address) (enterUserDetails())
Select gender option (enterUserDetails())
Select multiple checkboxes for days (selectDays())
Select country from a dropdown (selectCountry())

✅ Web Table Handling
Verify if a book name exists in a static table (verifyIfBookNameIsAvailableInTheTable())
Select a product from a paginated table (selectProductInThePaginatedTable())

## 📂 Class: `TestAutomationBlogSpotPractice.java`
The `TestAutomationBlogSpotPractice` class contains methods that automate different Selenium tasks. Below is a description of each method.

### **🔹 Method Descriptions**

| Method Name                         				| Description 										  	|
|---------------------------						|-------------											|
| `start()`                   						| Opens website, maximizes window, sets implicit wait.	|
| `enterUserDetails()`                 				| Fills user details and selects the male option. 	  	|
| `selectDays(String option)` 						| Selects checkboxes for user-specified days. 		  	|
| `selectCountry()`                       			| Selects a country from the dropdown by visible text.	|
| `verifyIfBookNameIsAvailableInTheTable()`       	| Checks if the given book name exists in the table.  	|
| `selectProductInThePaginatedTable()`             	| Selects a specified product from a paginated table. 	|
| `stop()`             								| Closes the browser and ends the session. 			  	|


## 🔧 How to Run the Tests
1. Clone the repository:  
   ```bash
   git clone https://github.com/kushaalworks/practice-selenium.git

