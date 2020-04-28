package com.example.kotlinespresso2.data.source

import com.example.kotlinespresso2.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}