Feature: Time

  Scenario: Redirect to Time Page
    Given user is in dashboard page
    When user click time section in sidebar
    Then user expect redirection to time page

  Scenario: Add Project Info
    Given user is in project info in time page and click add button
    When user add a project with name "AAA",customer name "Apache Software Foundation"
    Then user expect success message

  Scenario: Search existing Project
    Given user is in time page wants to search for project
    When user search for project with project name "AAA",customer name "Apache Software Foundation"
    Then user expect to see project with name "AAA",event "Apache Software Foundation"