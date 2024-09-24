package codingAssessment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidCredentialsCheck {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_csharp_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
		/*
		 * Valid Credentials: login@codility.com ; password
		 * Invalid Credentials: unknown@codility.com ; password
		 * */
		
		//1. Check if the email and password fields are on the main screen of the application:
		//Checking if the Email Input has id equal to email-input:
		driver.findElement(By.id("email-input")).sendKeys("unknown@codility.com"); //This confirms that email input field is email-input
		driver.findElement(By.id("password-input")).sendKeys("password");  //This confirms that password input field is password-input
		driver.findElement(By.id("login-button")).click(); //This confirms that login button field has id equal to login-button
		//Validating if the div with class equal to success message containing message as "Welcome to Codility" is visible:
		String actualErrorMsg = driver.findElement(By.xpath("//div[@class='message error']")).getText();
		System.out.println(actualErrorMsg);
		
		if(actualErrorMsg.equals("You shall not pass! Arr!")) {
			System.out.println("Expected Error Message matches with Actual Error Message");
		}
		
		
		
	}

}
