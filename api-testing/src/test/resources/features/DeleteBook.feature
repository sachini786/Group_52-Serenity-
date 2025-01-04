Feature: Delete book by ID

  @CreateBookForDelete
  Scenario: Delete a book with a valid ID as a user
    Given user authenticate using "user" and "password"
    When I send a DELETE request to delete a book with valid ID
    Then Delete response status should be 403

  @CreateBookForDelete
  Scenario: Delete a book with a valid ID as an admin
    Given user authenticate using "admin" and "password"
    When I send a DELETE request to delete a book with valid ID
    Then Delete response status should be 200

  Scenario: Delete a book with a non-existing ID as an admin
    Given user authenticate using "admin" and "password"
    When I send a DELETE request to delete a book with non-existing 1000
    Then Delete response status should be 404

  Scenario: Delete a book with a non-existing ID as a user
    Given user authenticate using "user" and "password"
    When I send a DELETE request to delete a book with non-existing 2000
    Then Delete response status should be 403