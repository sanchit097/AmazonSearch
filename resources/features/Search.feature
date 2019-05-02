#Author: sanchit_negi@yahoo.com
@assignment
Feature: Search from home page
  I want to search specific product from searchResult

  Background: User is navigated to website
    Given I open the web browser
    When I enter url
      | http://amazon.com |
    Then I should be navigated to homepage

  Scenario Outline: Getting specific product from search results by sorting
    Given user search for "<keyword>" in searchbox
    When user sort it by "<sortingValue>"
    And select details "<resultOrder>" from list
    Then Product with keyword "<expectedResult>" should be present

    Examples: 
      | keyword | sortingValue       | resultOrder | expectedResult |
      | Nikon   | Price: High to Low |           2 | Nikon D3X      |
