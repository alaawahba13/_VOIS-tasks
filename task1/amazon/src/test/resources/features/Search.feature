Feature: Search for item functionality
  In order easily find desired products
  As a customer
  I want to search for the item by typing its name in search box

  @SearchForItemAndAddToCart
  Scenario Outline: item search and selection
    Given I am on the Amazon home page
    When I am searching for <itemName>
    And Choosing the first item
    And Adding the item to the cart
    Then The item should be added successfully in the cart
    Examples:
      |itemName|
      |"Car Accessories"|
      |"Makeup"         |
      |"Grocery"        |



