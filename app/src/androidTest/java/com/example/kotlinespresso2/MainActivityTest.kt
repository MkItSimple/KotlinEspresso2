package com.example.kotlinespresso2

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Assert.*
import org.junit.Test

class MainActivityTest {

    @Test
    fun test_navSecondaryActivity() {

        val activityScenario = ActivityScenario.launch(MainActivity::class.java) // when launch  main activity

        onView(withId(R.id.button_next_activity)).perform(click()) // when button click
        onView(withId(R.id.secondary)).check(matches(isDisplayed())) // is secondary displayed
    }

    /**
     * Test both ways to navigate from SecondaryActivity to MainActivity
     */
    @Test
    fun test_backPress_toMainActivity() {

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
        //onView(withId(R.id.button_back)).perform(click()) // method 1
        pressBack()  // method 2
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }
}