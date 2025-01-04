Feature: PIM

  Scenario: navigate to PIM page
    Given user is in dashboard
    When user click in PIM in sidebar
    Then user expect redirection to PIM section

  Scenario: add employee
    Given user is in PIM page and click the add button
    When user add employee with employee firstName "Sachini" lstName "Fonseka"
    Then user expect success message

  Scenario: Search existing employee
    Given user is in PIM page wants to search for employee
    When user search for employee with first name "Sachini" last name "Fonseka"
    Then user expect to see employee with first name "Sachini" last name "Fonseka"
