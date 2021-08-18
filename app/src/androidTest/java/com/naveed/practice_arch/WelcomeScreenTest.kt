package com.naveed.practice_arch

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.naveed.practice_arch.welcome.list.WelcomeViewHolder
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class WelcomeScreenTest {

    @get:Rule var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun validate_welcomeScreen() {
        onView(withId(R.id.main_toolbar))
            .check(matches(isDisplayed()))
        onView(withId(R.id.recycler_view))
            .perform(
                RecyclerViewActions.scrollTo<WelcomeViewHolder>(
                    hasDescendant(withText("Github Profile"))
                ),
                RecyclerViewActions.actionOnItemAtPosition<WelcomeViewHolder>(0, click())
            )
    }
}