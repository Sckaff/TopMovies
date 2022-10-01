package com.example.topmovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.topmovies.R.id

class TopMoviesRecyclerViewAdapter(
    private val movies: List<TopMovie>,
    private val mListener: OnListFragmentInteractionListener?
)
    : RecyclerView.Adapter<TopMoviesRecyclerViewAdapter.MovieViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movie, parent, false)
        return MovieViewHolder(view)
    }

    /**
     * This inner class lets us refer to all the different View elements
     * (Yes, the same ones as in the XML layout files!)
     */
    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: TopMovie? = null
        val mMovieTitle: TextView = mView.findViewById<View>(id.movie_title) as TextView
        val mMovieSummary: TextView = mView.findViewById<View>(id.movie_summary) as TextView
        val mMoviePoster: ImageView = mView.findViewById<View>(id.movie_poster) as ImageView

        override fun toString(): String {
            return mMovieTitle.toString()
        }
    }

    /**
     * This lets us "bind" each Views in the ViewHolder to its' actual data!
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.mItem = movie
        holder.mMovieTitle.text = movie.title
        holder.mMovieSummary.text = movie.summary

        Glide.with(holder.mView)
            .load("https://image.tmdb.org/t/p/w500/"+movie.bookImageUrl)
            .centerInside()
            .into(holder.mMoviePoster)

        holder.mView.setOnClickListener {
            holder.mItem?.let { book ->
                mListener?.onItemClick(book)
            }
        }
    }

    /**
     * Remember: RecyclerView adapters require a getItemCount() method.
     */
    override fun getItemCount(): Int {
        return movies.size
    }
}