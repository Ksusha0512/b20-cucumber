Feature: the internet herokuapp

  Scenario: Validate links on homepage
    When I navigate to homepage
    Then I should see 44 links

    Scenario: Validate Checkboxes header
      When I navigate to Checkboxes page
      Then I validate the header of Checkbox header
      Then I print the header