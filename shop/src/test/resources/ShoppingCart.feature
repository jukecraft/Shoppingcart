Feature: Pre-interview Exercise for Developer Candidates

  Scenario: First Step is Shopping cart - Scenario1
    Given the fruit cost in "fruit.properties"
    When the customer scans "Apple, Apple, Orange, Apple"
    Then The total cost should be 2.05

  Scenario: First Step is Shopping cart - Scenario2
    Given the fruit cost in "fruit.properties"
    When the customer scans "Apple, Apple, Apple"
    Then The total cost should be 1.80
