# Workshop for Hogeschool Windesheim - Countries of the World - Structured Solution

## Introduction
Tests the functionality of naming all countries in the JetPunk country quiz.

This test automates the process of opening the browser, navigating to the JetPunk
"How many countries can you name?" quiz, and verifying that all countries can be
correctly entered and marked as correct answers.

### Steps
1. Arrange: Set up the Playwright environment and browser, and navigate to the quiz page.
2. Act: Accept cookie consent, start the quiz, retrieve all country names, and enter each country into the answer box. Close any popups that appear.
3. Assert: Verify that all entered countries are marked as correct.
4. Cleanup: Close the Playwright browser and environment.

## Prerequisites
* IntelliJ Community Edition (or any other IDE like Eclipse, Visual Studio Code, etc.)
* JDK 21

## Extra info
There are 5 more files added to this exercise.
* `src/test/java/com/polteq/workshop/lib/BrowserFactory.java`

Instead of creating the Browsers in the test itself, we now moved this code to a BrowserFactory.
This code makes it easier and more maintainable to create a Playwright Browser

* `src/test/java/com/polteq/workshop/lib/BrowserName.java`

To make sure you can only create the Browsers that are supported by Playwright, we made an Enumeration of the different browsers that you can use.

* `src/test/java/com/polteq/workshop/pages/BasePage.java`

Every Page of a Page Object Model will extend from this BasePage. Here we can collect methods that needs to be available to all pages.

* `src/test/java/com/polteq/workshop/pages/QuizPage.java`

This is the representation of the Quiz page of the game. Everything this page supports will be available from here.

* `src/test/java/com/polteq/workshop/CountriesOfTheWorldScenario.java`

This file is where the Hooks will be defined. Hooks will be triggered Before/After All tests and/or Before/After each test.

## Exercise
* Move all Quiz page specific code to `src/test/java/com/polteq/workshop/pages/QuizPage.java` and then call the functions of that page instead.
* Move all Initialization code and Cleanup code to `src/test/java/com/polteq/workshop/CountriesOfTheWorldScenario.java`.
  Since this code is called automatically in JUnit, you don't need to call these methods yourself.