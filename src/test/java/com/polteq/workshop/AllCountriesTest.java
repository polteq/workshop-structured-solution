package com.polteq.workshop;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AllCountriesTest extends CountriesOfTheWorldScenario {

    /**
     * Tests the functionality of naming all countries in the JetPunk country quiz.
     * <p>
     * This test automates the process of opening the browser, navigating to the JetPunk
     * "How many countries can you name?" quiz, and verifying that all countries can be
     * correctly entered and marked as correct answers.
     * <p>
     * Steps:
     * 1. Arrange: Set up the Playwright environment and browser, and navigate to the quiz page.
     * 2. Act: Accept cookie consent, start the quiz, retrieve all country names, and enter each
     * country into the answer box. Close any popups that appear.
     * 3. Assert: Verify that all entered countries are marked as correct.
     */
    @Test
    @DisplayName("Test all Countries of the World")
    public void allCountriesTest() {
        // +-----------------------------------------------------------------------------------------------------------+
        // | Arrange
        // +-----------------------------------------------------------------------------------------------------------+

        // Navigate to the quiz website
        quizPage.navigateToQuizPage();

        // +-----------------------------------------------------------------------------------------------------------+
        // | Act
        // +-----------------------------------------------------------------------------------------------------------+

        // Click on the cookie consent button
        quizPage.acceptCookieConsent();

        // Retrieve all countries
        List<String> countries = quizPage.getCountryList();

        // Click on the start button to start the game
        quizPage.startQuiz();

        // For every country fill in the country in the answer box
        for (String country : countries) {
            quizPage.fillInCountry(country);
        }

        // Close the first popup
        quizPage.closeModal();
        // Close the second popup
        quizPage.closeModal();

        // +-----------------------------------------------------------------------------------------------------------+
        // | Assert
        // +-----------------------------------------------------------------------------------------------------------+

        // Check if all countries are marked as correct in the tables
        SoftAssertions softAssertions = new SoftAssertions();
        for (String country : countries) {
            softAssertions.assertThat(quizPage.isCountryCorrect(country))
                    .as("Country " + country + "should be in the list")
                    .isTrue();
        }
        softAssertions.assertAll();
    }
}
