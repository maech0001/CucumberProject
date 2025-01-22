Feature: Login Functionality

  Background:
    Given user is able to access the HRMS application

  @invalid1
  Scenario: Invalid Login with an empty username
   # Given user is able to access the HRMS application
    When user enters an empty username field and a valid password
    And user clicks on the login button
    And user should get an error message stating "Username cannot be empty."
    When user enters the valid username and password
    Then user clicks on the login button

  @invalid2
  Scenario: Invalid login with an empty password field
   # Given user is able to access the HRMS application
    When user enters a valid username and an empty password
    And user clicks on the login button
    And user should get an error message stating "Password is empty." on the application
    When user enters the valid username and password
    Then user clicks on the login button

  @invalid3
  Scenario: Invalid login with an invalid credential
   # Given user is able to access the HRMS application
    When user enters an invalid username and a valid password
    And user clicks on the login button
    And user should get an error message stating "Invalid credentials." after entering an invalid detail
    When user enters the valid username and password
    Then user clicks on the login button

  @valid
  Scenario: Valid user login
   # Given user is able to access the HRMS application
    When user enters the valid username and password
    And user clicks on the login button
    Then user should be able to see the dashboard


  #@v
  #Scenario: Valid user login
   # Given user is able to access the HRMS application
    #When user enters the valid username and password
    #And user clicks on the login button
    #Then user should be able to see the dashboard
    #When user clicks on PIM button
   # And user clicks on Add Employee option
   # When user enters firstname and middlename and lastname
    #And user enters the employee ID
    #When user clicks on save button
    #Then employee added successfully
