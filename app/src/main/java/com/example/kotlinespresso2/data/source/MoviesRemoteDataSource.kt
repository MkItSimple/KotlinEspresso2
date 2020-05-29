package com.example.kotlinespresso2.data.source

import com.example.kotlinespresso2.data.FakeMovieData
import com.example.kotlinespresso2.data.Movie

class MoviesRemoteDataSource: MoviesDataSource {

    private var MOVIES_REMOTE_DATA = LinkedHashMap<Int, Movie>(FakeMovieData.movies.size)

    init {
        for (movie in FakeMovieData.movies){
            addMovie(movie)
        }
    }

    override fun getMovies(): List<Movie> {
        return ArrayList(MOVIES_REMOTE_DATA.values)
    }

    override fun getMovie(movieId: Int): Movie? {
        return MOVIES_REMOTE_DATA[movieId]
//        return Movie(
//            1,
//            "The Rundown",
//            "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/The_Rundown-the_rundown.png",
//            "A tough aspiring chef is hired to bring home a mobster's son from the Amazon but " +
//                    "becomes involved in the fight against an oppressive town operator and the search " +
//                    "for a legendary treasure.",
//            arrayListOf("R.J. Stewart", "James Vanderbilt"),
//            arrayListOf("Dwayne Johnson", "Seann William Scott", "Rosario Dawson", "Christopher Walken")
//        )
    }

    private fun addMovie(
        movie: Movie
    ){
        MOVIES_REMOTE_DATA.put(movie.id, movie)
    }

}














