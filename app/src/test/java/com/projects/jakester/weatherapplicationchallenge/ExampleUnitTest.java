package com.projects.jakester.weatherapplicationchallenge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class ExampleUnitTest {

    @Test
    public void searchEqualsResult() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void noSameResultsForDifferentSearches() throws Exception {
        assertEquals(4, 2 + 2);
    }
}