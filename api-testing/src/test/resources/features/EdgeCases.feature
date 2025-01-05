Feature: Edge Cases

  Scenario: Accessing to an Invalid endpoint
    Given user needs to get all the authors
    When user send request to get all authors
    Then the edge case response status should be 404

  Scenario: Create a book with Extra unexpected details
    Given user need to create a book with extra field
    When user send request to create book
    Then the edge case response status should be 201

  Scenario: Delete a book with a invalid ID as a user
    Given user need to authenticate using "user" and "password"
    When user send a DELETE request to delete a book with invalid ID format "a"
    Then the edge case response status should be 403