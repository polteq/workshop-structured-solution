package com.polteq.workshop.pages;

import com.microsoft.playwright.Page;

public abstract class BasePage {
    protected final Page page;

    /**
     * Constructs a new instance of the BasePage class.
     *
     * @param page the WebDriver instance to be used by the BasePage
     */
    public BasePage(Page page) {
        this.page = page;
    }
}
