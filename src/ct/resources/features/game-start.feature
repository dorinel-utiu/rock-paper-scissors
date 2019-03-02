Feature: Game start
  As a user I would like game to start

  Scenario: Game starts successfully
    Given The application is up and running
    When An id is given to start the game
    Then A 201 status code should be returned