package org.example.tests;

import org.example.BaseTest;
import org.example.listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.example.constants.Constant.InputValue.NAME_REGION;
import static org.example.constants.Constant.Urls.URL;

@Listeners({TestListener.class})
public class SearchToursTest extends BaseTest {

    @Test
    public void test1() {

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
