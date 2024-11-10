package com.polteq.workshop;

import com.microsoft.playwright.*;
import com.polteq.workshop.lib.BrowserFactory;
import com.polteq.workshop.lib.BrowserName;
import com.polteq.workshop.pages.QuizPage;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CountriesOfTheWorldScenario {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    protected Page page;
    protected QuizPage quizPage;

    @BeforeAll
    public void beforeAllTests() {
        playwright = Playwright.create();
        browser = BrowserFactory.createBrowser(playwright, BrowserName.FIREFOX);
    }

    @BeforeEach
    public void setUp() {
        context = browser.newContext();
//        context.tracing().start(new Tracing.StartOptions()
//                .setScreenshots(true)
//                .setSnapshots(true)
//                .setSources(true));
        page = context.newPage();
        page.setViewportSize(1920, 1080);
        quizPage = new QuizPage(page);
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        page.close();
//        String currentTestName = testInfo.getDisplayName();
//        context.tracing().stop(new Tracing.StopOptions()
//                .setPath(Paths.get("target/traces/" + currentTestName + ".zip")));
        context.close();
    }

    @AfterAll
    public void afterAllTests() {
        browser.close();
        playwright.close();
    }
}
