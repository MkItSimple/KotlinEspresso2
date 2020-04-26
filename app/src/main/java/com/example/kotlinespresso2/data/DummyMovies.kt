package com.example.kotlinespresso2.data

object DummyMovies {

    val INFINITY_WAR = Movie(
        0,
        "Avengers: Infinity War",
        "https://firebasestorage.googleapis.com/v0/b/fir-sampleapplication-23d5f.appspot.com/o/inifinity-war.png?alt=media&token=c9f47bf0-3670-4b5c-9488-983f9809d78c",
        "The Avengers and their allies must be willing to sacrifice all in an attempt to " +
                "defeat the powerful Thanos before his blitz of devastation and ruin puts an end to " +
                "the universe.",
        arrayListOf("Anthony Russo", "Joe Russo"),
        arrayListOf("Robert Downey Jr.", "Chris Hemsworth", "Mark Ruffalo", "+ more...")
    )

    val THE_RUNDOWN = Movie(
        1,
        "The Rundown",
        "https://firebasestorage.googleapis.com/v0/b/fir-sampleapplication-23d5f.appspot.com/o/rundown.png?alt=media&token=acc2b0e3-499a-473d-b6ca-944c4453894a",
        "A tough aspiring chef is hired to bring home a mobster's son from the Amazon but " +
                "becomes involved in the fight against an oppressive town operator and the search " +
                "for a legendary treasure.",
        arrayListOf("R.J. Stewart", "James Vanderbilt"),
        arrayListOf("Dwayne Johnson", "Seann William Scott", "Rosario Dawson", "Christopher Walken")
    )
}