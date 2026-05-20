Feature: Book Store Page feature

Background:
Given User is logged into the book store

Scenario: Books count
Given user is on profile page
And User clicks on bookstore
Given user is on book store page
When books count should be 10

Scenario: Search a book
Given user is on profile page
And User clicks on bookstore
Given user is on book store page
When Search with "programming"
Then Author name should be "Eric Elliott"