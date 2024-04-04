Feature: the internet saucedemo
  Background:
    Given I navigate to Saucedemo

  Scenario: Navigate to site and print the list

    Then I login using username-
    Then I apply password and click enter
    Then I print out all item names from page

Scenario: Login with locked used

  When I login with locked username and password
  Then I should get error message


  Scenario: Login, choose the product and validate the name of product in cart

    Then I login with visual_user
    Then I apply password and click enter
    Then I select product name and print price
    Then I add Onesie to Cart
    Then I open Cart
    Then I validate Onesie in the cart


    Scenario: Login, choose product, print price and validate it in the cart

      Then I login with visual_user
      Then I apply password and click enter
      Then I click on item and print the item name and price
      Then I click on Onesie to add it to Cart
      Then I click on Cart sign
      Then I validate the Item in the Cart


      Scenario: Login with visual user Backpack

        Given I login with visual_user
        Then I apply password and click enter
        Then I should see "backpack" item
        And price should be 7.99
