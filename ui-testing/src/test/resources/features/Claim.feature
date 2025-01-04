Feature: Claim

  Scenario: Navigate to Claim page
    Given user is in dashboard
    When user click claim section in sidebar
    Then user expect redirection to claim section

  Scenario: Assign Claim
    Given user is in claim page and click assign claim button
    When user create new claim request with employee name "Sachini Fonseka",event "Travel Allowance", currency "Algerian Dinar"
    Then user expect success message

  Scenario: Search existing claim
    Given user is in claim page wants to search for initiated claim
    When user search for claim with employee name "Sachini Fonseka",event "Travel Allowance" and status "Initiated"
    Then user expect to see claim with name "Sachini Fonseka",event "Travel Allowance", currency "Algerian Dinar" and status "Initiated"
