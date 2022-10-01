package com.example.topmovies

/**
 * This interface is used by the [TopMoviesRecyclerViewAdapter] to ensure
 * it has an appropriate Listener.
 *
 * In this app, it's implemented by [TopMoviesFragment]
 */

interface OnListFragmentInteractionListener {
    fun onItemClick(item: TopMovie)
}
