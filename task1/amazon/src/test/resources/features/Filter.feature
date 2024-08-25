Feature: Filter and Add to Cart from Today's Deals

  In order to get a discounted deal
  As a customer
  I want to filter deals, select an item, and add it to the cart

@FilterAndAddToCart
  Scenario Outline: Filter items and add to cart
    Given I am on the Today's Deals Page
    When I select the <departmentFilter> and discount of <discountFilter>
    And I navigate to the fourth page
    And I select an item and add it to the cart
    Then item should be in the cart
  Examples:
    | departmentFilter          | discountFilter         |
    | "Grocery"    | "10% off or more"      |
    | "Electronics + Headphones, Earbuds & Accessories + Headphones & Earbuds" | "20% off or more"      |