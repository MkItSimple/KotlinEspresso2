package com.example.kotlinespresso2.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.kotlinespresso2.R
import com.example.kotlinespresso2.factory.MovieFragmentFactory
import org.junit.Assert.*
import org.junit.Test

class DirectorsFragmentTest {

    // We will check if directors is in directors_text
    @Test
    fun test_isDirectorsListVisible() {

        // GIVEN
        val directors = arrayListOf("R.J. Stewart", "James Vanderbilt")
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_directors", directors) // this  is in MovieDetailFragment.kt  args_directors
        val scenario = launchFragmentInContainer<DirectorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        // VERIFY
        onView(withId(R.id.directors_text))
            .check(matches(withText(
                DirectorsFragment.stringBuilderForDirectors(directors)
            )))
    }
}