@BookTicket
Feature: Booking a Bus Ticket

@SelectCityAndDate
  Scenario Outline: Select Departure and Arrival Cities
    Given I am on the KSRTC homepage
    When I select Popular route <number>
    And I choose the <ArrivalDate>
    Then the available buses should be displayed
    Examples:
      |ArrivalDate|number|
      |"13/9"|"1"  |

@SelectSeat
  Scenario Outline: Select a Seat
    Given I am on trip details page
    When I select the seat <SeatNumber>
    And I choose the <BoardingPoint> and <DroppingPoint>
    Then provide passenger details button should be displayed

    Examples:
      | SeatNumber | BoardingPoint | DroppingPoint |
      | "24"         | "JALHALLI CROSS PH NO. 9886022381"| "CHIKKAMAGALURU BUS STAND"|

@FillInfo
  Scenario Outline: Fill Customer and Passenger Details
    Given I have chosen boarding and dropping points
    When I fill in the customer details with <CountryCode>, <PhoneNumber>, and  <Email>
    And I fill in the passenger details with <Name>,<Age>, <Gender>,<Concession>,  <IdCard>,  <IdCardNumber>, and  <Country>
    Then I should be taken to the review booking page
  Examples:
    | CountryCode | PhoneNumber | Email |Name  | Age | Gender | Concession       | IdCard   | IdCardNumber   | Country|
    | "Kenya"       | "6789125987"  | "test@example.com"| "Alaa"| "30"| "Female" | "GENERAL PUBLIC" | "Passport" | "123456789012" | "Cuba"|

@MakePayment
Scenario: Make Payment
     Given I'm on the review booking page
     When I click on Proceed to Pay
     And I choose payment method
     Then the payment page should be displayed
