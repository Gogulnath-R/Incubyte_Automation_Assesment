package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pages.SignupPage;
import utils.DriverManager;
import utils.ScreenshotUtils;

public class SignupSteps {
    WebDriver driver = DriverManager.getDriver();
    
    SignupPage signupPage = new SignupPage(driver);

    @Given("I am on the Magento sign-up page")
    public void i_am_on_the_magento_sign_up_page() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        ScreenshotUtils.captureScreenshot(driver, "Signup_Page");
        }

    @When("I enter valid details")
    public void i_enter_valid_details() {
        signupPage.enterFirstName("John");
        signupPage.enterLastName("Doe");
        signupPage.enterEmail("johndoe" + System.currentTimeMillis() + "@mail.com"); // Unique email
        signupPage.enterPassword("Test@1234");
        signupPage.enterConfirmPassword("Test@1234");
        ScreenshotUtils.captureScreenshot(driver, "Entered_Valid_Details"); 
    }

    @When("I enter an already registered email")
    public void i_enter_an_already_registered_email() {
        signupPage.enterFirstName("Jane");
        signupPage.enterLastName("Doe");
        signupPage.enterEmail("existinguser@mail.com");
        signupPage.enterPassword("Test@1234");
        signupPage.enterConfirmPassword("Test@1234");
        ScreenshotUtils.captureScreenshot(driver, "Entered_Already_Registered_Email");
    }

    @When("I enter a weak password")
    public void i_enter_a_weak_password() {
        signupPage.enterFirstName("Mark");
        signupPage.enterLastName("Smith");
        signupPage.enterEmail("marksmith" + System.currentTimeMillis() + "@mail.com");
        signupPage.enterPassword("12345");
        signupPage.enterConfirmPassword("12345");
        ScreenshotUtils.captureScreenshot(driver, "Entered_Weak_Password");
    }

    @And("I click the Create Account button")
    public void i_click_the_create_account_button() {
        signupPage.clickCreateAccount();
        ScreenshotUtils.captureScreenshot(driver, "Clicked_Create_Account");
    }

    @Then("I should be redirected to the account dashboard")
    public void i_should_be_redirected_to_the_account_dashboard() {
        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
        ScreenshotUtils.captureScreenshot(driver, "Account_Dashboard");
        assert driver.getCurrentUrl().equals(expectedUrl) : "User is not on the dashboard";
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {ScreenshotUtils.captureScreenshot(driver, "Error_Message"); 
        // Add validation for error message here
    }

    @Then("I should see a password validation error")
    public void i_should_see_a_password_validation_error() {
    	ScreenshotUtils.captureScreenshot(driver, "Password_Validation_Error");
        // Add validation for password error message
    }

    @After
    public void tearDown() {
    	 ScreenshotUtils.captureScreenshot(driver, "Test_Completion"); 
        DriverManager.quitDriver();
    }
}
