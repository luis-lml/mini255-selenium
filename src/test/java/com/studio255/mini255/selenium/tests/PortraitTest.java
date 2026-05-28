package com.studio255.mini255.selenium.tests;

import com.studio255.mini255.selenium.pages.PortraitPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PortraitTest extends BaseTest {

    @Test
    void individualPortraitShowsSchedulingAction() {
        PortraitPage portraitPage = new PortraitPage(driver, wait)
                .open(config.baseUrl());

        assertTrue(portraitPage.isIndividualPortraitVisible());
        portraitPage.selectIndividualPortrait();
        assertTrue(portraitPage.isScheduleButtonVisible());
        portraitPage.goToNextPortraitOption();
    }

    @Test
    void individualPortraitStudioPortafolio() {
        PortraitPage portraitPage = new PortraitPage(driver, wait)
                .open(config.baseUrl());

        assertTrue(portraitPage.isIndividualPortraitVisible());
        portraitPage.selectIndividualPortrait();
    }

    @Test
    void familiarPortraitShowsSchedukingAction() {
        PortraitPage portraitPage = new PortraitPage(driver, wait)
                .open(config.baseUrl());

        assertTrue(portraitPage.isFamiliarPortraitVisible());
        portraitPage.selectFamiliarPortrait();
        assertTrue(portraitPage.isScheduleButtonVisible());
    }
}
