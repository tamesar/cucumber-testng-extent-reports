Feature: Google Search

  @passFlow
  Scenario: Validate Search Results count - Happy Flow
    Given user launches google
    When user types in search query as "selenium webdriver"
    And user hits enter
    Then search results should be displayed

  @failFlow
  Scenario: Validate Search Results count - Failure
    Given user launches google
    When user types in search query as "selenium webdriver"
    And user hits enter
    Then search results should not be displayed
