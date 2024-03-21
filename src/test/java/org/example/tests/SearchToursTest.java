package org.example.tests;

import org.example.common.BaseTest;
import org.example.framework.listeners.FiledTestListener;
import org.example.framework.logger.AllureLogger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.example.framework.config.Config.NAME_REGION;
import static org.example.framework.config.Config.URL;

//@Listeners({FiledTestListener.class})
public class SearchToursTest extends BaseTest {

    @Test
    public void test1() {

        AllureLogger.debug("Test 1");
        basePage.open(URL);
        mainPage
                .checkTitle()
                .selectingRegion(NAME_REGION)
                .selectingViewRecreation()
                .selectingDate()
                .clickButtonOfSearch();
        filtersForSearchPage
                .checkingCountTours()
                .selectFilters()
                .checkingCountTours();
    }

    @Test
    public void test2() {

        AllureLogger.debug("Test 2");
        basePage.open(URL);
        mainPage
                .checkTitle()
                .selectingRegion(NAME_REGION)
                .selectingViewRecreation()
                .selectingDatesOfMarch()
                .clickButtonOfSearch();
        filtersForSearchPage
                .checkingCountTours()
                .moveSliderPrice()
                .checkingCountTours();
    }

    @Test
    public void test3() {

        AllureLogger.debug("Test 3");
        basePage.open(URL);
        mainPage
                .checkTitle()
                .selectingRegion(NAME_REGION)
                .selectingViewRecreation()
                .selectingDate()
                .clickButtonOfSearch();
        filtersForSearchPage
                .watchInfoOfTour()
                .switchingFrame();
        infoOfTour.switchingToPageBookYourPlace();
        applicationForTourPage
                .checkTitle()
                .selectingDate()
                .enteringName()
                .enteringPhoneNumber()
                .enteringEmail()
                .sendApplication()
                .checkingErrorMessage();
    }

}
