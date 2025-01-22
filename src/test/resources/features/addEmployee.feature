Feature: Add an employee to the HRMS application

  Background:
   #Given user is able to access HRMS application
    When user enters the valid username and password
    And user clicks on the login button
    Then user should be able to see the dashboard
    When user clicks on PIM button
    And user clicks on Add Employee option
    When user enters firstname and middlename and lastname



  @withoutEmployeeID
  Scenario: add an employee to the HRMS application without providing an employee ID.
    When user clicks on PIM button
    And user clicks on Add Employee option
    When user enters firstname and middlename and lastname

    @withEmployeeID
  Scenario: add an employee to the HRMS application by providing an employee ID.
    And user enters the employee ID
    When user clicks on save button
    Then employee added successfully
