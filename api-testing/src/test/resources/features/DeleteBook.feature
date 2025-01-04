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

#  Scenario Outline: Delete a book with a non-existing ID
#    Given user authenticate using "<username>" and "<password>"
#    When I send a DELETE request to delete a book with non-existing <id>
#    Then Delete response status should be <statusCode>
#    Examples:
#      | username | password | statusCode |   id  |
#      |   user   | password |    403     |  1000 |
#      |   admin  | password |    404     |  2000 |

  Scenario: Delete a book with a non-existing ID as a user
    Given user authenticate using "user" and "password"
    When I send a DELETE request to delete a book with non-existing 2000
    Then Delete response status should be 403

#  Scenario Outline: Delete a book with a invalid ID
#    Given user authenticate using "<username>" and "<password>"
#    When I send a DELETE request to delete a book with invalid ID format "<id>"
#    Then Delete response status should be <statusCode>
#    Examples:
#      | username | password | statusCode | id |
#      |   user   | password |    403     |  a |
#      |   admin  | password |    400     |  b |

  Scenario: Delete a book with a invalid ID as a user
    Given user authenticate using "user" and "password"
    When I send a DELETE request to delete a book with invalid ID format "a"
    Then Delete response status should be 403


