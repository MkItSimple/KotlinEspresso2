package com.example.kotlinespresso2.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.kotlinespresso2.R
import com.example.kotlinespresso2.data.DummyMovies.THE_RUNDOWN
import com.example.kotlinespresso2.factory.MovieFragmentFactory
import org.junit.Assert.*
import org.junit.Test

class MovieDetailFragmentTest{

    @Test
    fun test_isMovieDataVisible() {

        // GIVEN
        val movie = THE_RUNDOWN     // check on the DummyMovies file
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putInt("movie_id", movie.id)
        val scenario = launchFragmentInContainer<MovieDetailFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        // VERIFY
        onView(withId(R.id.movie_title)).check(matches(withText(movie.title)))

        onView(withId(R.id.movie_description)).check(matches(withText(movie.description)))
    }
}