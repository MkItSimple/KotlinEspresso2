package com.example.kotlinespresso2.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.bumptech.glide.request.RequestOptions
import com.example.kotlinespresso2.R
import com.example.kotlinespresso2.data.Movie
import com.example.kotlinespresso2.data.source.MoviesRemoteDataSource
import com.example.kotlinespresso2.factory.MovieFragmentFactory
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class MovieDetailFragmentTest{

    @Test
    fun test_isMovieDataVisible() {

        // SETUP
        val movieId = 1
        val title = "The Rundown"
        val description = "A tough aspiring chef is hired to bring home a mobster's son from the Amazon but " +
                "becomes involved in the fight against an oppressive town operator and the search " +
                "for a legendary treasure."
        val movie = Movie(
            1,
            "The Rundown",
            "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/The_Rundown-the_rundown.png",
            "A tough aspiring chef is hired to bring home a mobster's son from the Amazon but " +
                    "becomes involved in the fight against an oppressive town operator and the search " +
                    "for a legendary treasure.",
            arrayListOf("R.J. Stewart", "James Vanderbilt"),
            arrayListOf("Dwayne Johnson", "Seann William Scott", "Rosario Dawson", "Christopher Walken")
        )
        // NOTE:
        // Also could have built a "FakeMoviesRemoteDataSource" (AKA a STUB).
        // I don't think it matters in this case.
        // Probably for a larger repository and more complex app I would stub the repository. Then
        // you could test errors, various success cases, etc...
        val moviesDataSource = mockk<MoviesRemoteDataSource>()

        //val mMovie = moviesDataSource.getHello()


//        every {
//            moviesDataSource.getMovie(movieId)
//        } returns movie
//
//        val requestOptions = RequestOptions()
//            .placeholder(R.drawable.default_image)
//            .error(R.drawable.default_image)
//        val fragmentFactory = MovieFragmentFactory(requestOptions, moviesDataSource)
//        val bundle = Bundle()
//        bundle.putInt("movie_id", movieId)
//        val scenario = launchFragmentInContainer<MovieDetailFragment>(
//            fragmentArgs = bundle,
//            factory = fragmentFactory
//        )
//
//        // VERIFY
//        onView(withId(R.id.movie_title)).check(matches(withText(title)))
//
//        onView(withId(R.id.movie_description)).check(matches(withText(description)))

        // Checking image is more complex so we'll do in another video
    }

}