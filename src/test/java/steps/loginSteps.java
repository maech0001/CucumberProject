package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;
import utils.ConfigReader;
import pages.LoginPage;

import java.time.Duration;

public class loginSteps extends CommonMethods {

    @Given("user is able to access the HRMS application")
    public void user_is_able_to_access_the_hrms_application() {
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @When("user enters an empty username field and a valid password")
    public void user_enters_an_empty_username_field_and_a_valid_password() {
        WebElement usernameTxtField= driver.findElement(By.id("txtUsername"));
        WebElement passwordTxtField=driver.findElement(By.name("txtPassword"));
        //sendText("",loginPage.usernameTxtField);
        //sendText(ConfigReader.read("password"),loginPage.passwordTxtField);
       usernameTxtField.sendKeys("");
       passwordTxtField.sendKeys("Hum@nhrm123");

    }
    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        WebElement loginButton= driver.findElement(By.id("btnLogin"));
        loginButton.click();
        //click(loginPage.loginButton);
    }
    @Then("user should get an error message stating {string}")
    public void user_should_get_an_error_message_stating(String string) {
        WebElement pageText= driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String loginPageText=pageText.getText();
        Assert.assertEquals("Username cannot be empty",loginPageText);
        System.out.println("Username test assertion passed");


    }

    @When("user enters a valid username and an empty password")
    public void user_enters_a_valid_username_and_an_empty_password() {
        WebElement usernameTxtField= driver.findElement(By.name("txtUsername"));
        WebElement passwordTxtField= driver.findElement(By.id("txtPassword"));
        usernameTxtField.sendKeys("admin");
        passwordTxtField.sendKeys("");
        //sendText(ConfigReader.read("username"),loginPage.usernameTxtField);
        //sendText("",loginPage.passwordTxtField);

    }


    @When("user enters an invalid username and a valid password")
    public void user_enters_an_invalid_username_and_a_valid_password() {
        WebElement invalidUsername= driver.findElement(By.name("txtUsername"));
        WebElement invalidPassword=driver.findElement(By.name("txtPassword"));
        invalidUsername.sendKeys("adminn");
        invalidPassword.sendKeys("Hum@nhrm123");
        //sendText(ConfigReader.read("invalidUsername"),loginPage.usernameTxtField);
        //sendText(ConfigReader.read("password"),loginPage.passwordTxtField);
    }

    @When("user enters the valid username and password")
    public void user_enters_the_valid_username_and_password() {
        WebElement usernameTxtField= driver.findElement(By.name("txtUsername"));
        WebElement passwordTxtField=driver.findElement(By.name("txtPassword"));
        usernameTxtField.sendKeys("admin");
        passwordTxtField.sendKeys("Hum@nhrm123");

       //sendText(ConfigReader.read("username"),loginPage.usernameTxtField);
       //sendText(ConfigReader.read("password"),loginPage.passwordTxtField);

    }
    @Then("user should be able to see the dashboard")
    public void user_should_be_able_to_see_the_dashboard() {
        WebElement dashBoardValidation= driver.findElement(By.id("welcome"));
        String dashBoardTxt=dashBoardValidation.getText();
        Assert.assertEquals("Welcome Admin", dashBoardTxt);
        System.out.println("User was able to see the dashboard");
    }

    @Then("user should get an error message stating {string} on the application")
    public void user_should_get_an_error_message_stating_on_the_application(String string) {
        WebElement pageText= driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String loginPageText=pageText.getText();
        Assert.assertEquals("Password is Empty",loginPageText);
        System.out.println("Password test assertion passed");
    }


    @When("user should get an error message stating {string} after entering an invalid detail")
    public void user_should_get_an_error_message_stating_after_entering_an_invalid_detail(String string) {
        WebElement pageText= driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String loginPageText=pageText.getText();
        Assert.assertEquals("Invalid credentials",loginPageText);
        System.out.println("Invalid credentials test assertion passed");
    }
    /*test
    @When("user clicks on PIM button")
    public void user_clicks_on_pim_button() {
        WebElement PIMOption= driver.findElement(By.id("menu_pim_viewPimModule"));
        PIMOption.click();

    }
    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
        addEmployeeOption.click();
    }
    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        WebElement firstName= driver.findElement(By.id("firstName"));
        WebElement middleName= driver.findElement(By.id("middleName"));
        WebElement lastName= driver.findElement(By.id("lastName"));
        firstName.sendKeys("mark");
        middleName.sendKeys("ms");
        lastName.sendKeys("jacob");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveButton= driver.findElement(By.id("btnSave"));
        saveButton.click();
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        WebElement addEmployeeValidate= driver.findElement(By.id("menu_pim_viewEmployeeList"));
        String addEmployeeTxt=addEmployeeValidate.getText();
        Assert.assertEquals("Employee List", addEmployeeTxt);
    }

    @When("user enters the employee ID")
    public void user_enters_the_employee_id() {
        WebElement employeeID= driver.findElement(By.name("employeeId"));
        employeeID.clear();
        employeeID.sendKeys("9432522");
    }
*/



}
