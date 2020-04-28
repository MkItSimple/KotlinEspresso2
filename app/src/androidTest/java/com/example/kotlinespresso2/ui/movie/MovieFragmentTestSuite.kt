package com.example.kotlinespresso2.ui.movie

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    DirectorsFragmentTest::class,
    StarActorsFragmentTest::class
)
class MovieFragmentTestSuite