Feature:Login functionality

  Scenario Outline:
    Given I am on Facebook login page
    When I enter invalid Facebook "<email>"
    And I login with invalid Facebook "<password>"
    Then I should get error message:"<error>"

    Examples:
      | email             | password   | error                                                |
      | test123456@te.com | myfavepass | The email you entered isn’t connected to an account. |


