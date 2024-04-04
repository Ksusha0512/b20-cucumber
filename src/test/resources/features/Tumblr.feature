Feature: The internet Tumblr

  Scenario: I navigate to tumblr, try to sign in , place invalid password, validate error
    When I navigate to https://www.tumblr.com/
    Then I click Log In
    Then I click Continue with email
    Then I enter email : (test@test.com)
    Then I enter invalid password(abcabc)
    Then I Validate error message

  Scenario Outline:  Invalid login
    Given I'm on Tumblr home page
    When I click login button
    And I click continue with email button
    And I enter "<email>" email
    And I enter "<password>" password
    Then I should get "Your email or password were incorrect" error

    Examples:
      | email         | password |
      | test@test.com | abcabc   |
      | test@test.com | !^%&#%Y  |