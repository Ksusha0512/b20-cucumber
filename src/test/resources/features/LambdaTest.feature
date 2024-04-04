Feature: LambdaTest Input Form

  Scenario: Fill in Input form on LambdaTest site and validate the success message
    Given I am on LambdaTest site
    When I click on Input Form link
    Then I fill in Input Form
    And Click submit
    And validate submit message

  Scenario: Fill in Input form on LambdaTest site and validate the success message
    Given I am on LambdaTest site
    When I click on Input Form link
    Then I enter all required data in form
      | name     | John          |
      | email    | jc@gmail.com  |
      | password | myFavPass     |
      | company  | Codefish      |
      | website  | Codefish.io   |
      | country  | United States |
      | city     | Des Plaines   |
      | address1 | 2200 E Devon  |
      | address2 | 351           |
      | state    | IL            |
      | zipCode  | 60018         |
    And Click submit
    And validate submit message