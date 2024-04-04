Feature: Google search
  Scenario: Happy path searchG
    Given I on google home page
    When I search for Codefish
    Then i should get results

