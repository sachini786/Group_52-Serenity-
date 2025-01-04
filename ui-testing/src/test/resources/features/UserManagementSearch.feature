Feature: User Management - Search Functionality

Scenario: Navigate to Admin page
  Given user in dashboard need to navigate to admin page
  When user click Admin section in sidebar
  Then user expect redirection to Admin section

  Scenario: Add User
    Given user is in Admin page
    When user clicking the add Button
    When user add new user role "userrole", employee name "John Doe", Status "Enabled", username "dasithrathana", password "password1", confirm password "password1"
    Then user expect to be redirected to the Admin section

  Scenario: navigate to the job page
    Given user is in the admin page
    When user clicked the job icon
    Then redirecting to the job title page
    And clicking the add job button
    Then redirecting to the Add job page
    Then fill the job title as "testing the  job title page"
    And click on the save button



