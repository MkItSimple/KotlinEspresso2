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
    fun testActivity_inView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun testVisibility_nextButton() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_main_title)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))
    }

    @Test
    fun testTitleTextDisplayed(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.activity_main_title))
            .check(matches(withText("MainActivity")))
    }
}