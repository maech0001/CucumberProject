package steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import java.io.IOException;


public class addEmployeeSteps extends CommonMethods {

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
        employeeID.sendKeys("9439522");
    }





}
