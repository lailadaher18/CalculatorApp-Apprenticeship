Feature: Calculator
  As a user
  I want to use a calculator
  So that I can perform basic arithmetic operations

  Scenario: Addition
    Given I am on the calculator page
    When I enter "2+2"
    And I press "="
    Then the result should be "4"

  Scenario: Subtraction
    Given I am on the calculator page
    When I enter "5-3"
    And I press "="
    Then the result should be "2"

  Scenario: Multiplication
    Given I am on the calculator page
    When I enter "3*4"
    And I press "="
    Then the result should be "12"

  Scenario: Division
    Given I am on the calculator page
    When I enter "10/2"
    And I press "="
    Then the result should be "5"

  Scenario: Modulo
    Given I am on the calculator page
    When I enter "10%3"
    And I press "="
    Then the result should be "1"

  Scenario: Division by zero
    Given I am on the calculator page
    When I enter "5/0"
    And I press "="
    Then the result should be "Division by zero error"

  Scenario: First Number is a Negative number
    Given I am on the calculator page
    When I enter "-5+2"
    And I press "="
    Then the result should be "-3"

  Scenario: Decimal numbers
    Given I am on the calculator page
    When I enter "2.5+3.1"
    And I press "="
    Then the result should be "5.6"

  Scenario: First Decimal Number is a Negative number
    Given I am on the calculator page
    When I enter "-2.5+3.1"
    And I press "="
    Then the result should be "0.6"

  Scenario: Multiple operations
    Given I am on the calculator page
    When I enter "2+3*4"
    And I press "="
    Then the result should be "20"

  Scenario: Invalid input
    Given I am on the calculator page
    When I enter "2++2"
    And I press "="
    Then the result should be "No digits found."

  Scenario: Large numbers
    Given I am on the calculator page
    When I enter "1000000*1000000"
    And I press "="
    Then the result should be "1000000000000"

  Scenario: Zero as input
    Given I am on the calculator page
    When I enter "0+0"
    And I press "="
    Then the result should be "0"

  Scenario: Second Number is a Negative number
    Given I am on the calculator page
    When I enter "2--2"
    And I press "="
    Then the result should be "4"

  Scenario: Result is Rounded to 7 Decimal Places
    Given I am on the calculator page
    When I enter "1/3"
    And I press "="
    Then the result should be "0.3333334"


# NOT DONE: Add more scenarios to cover edge cases and complex operations
#  Scenario: First and Second Number are Negative numbers
#    Given I am on the calculator page
#    When I enter "2--2"
#    And I press "="
#    Then the result should be "-4"

#  Scenario: Second Decimal Number is a Negative number
#    Given I am on the calculator page
#    When I enter "2.5+-3.1"
#    And I press "="
#    Then the result should be "0.6"