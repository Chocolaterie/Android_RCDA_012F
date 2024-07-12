package com.example.android_tp.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.android_tp.R

class MovieAdapter(context: Context, movies: List<Movie>) :
    ArrayAdapter<Movie>(context, 0, movies) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // 1 :: Retrouver notre cellule xml donc le list_item_movie.xml
        // itemView deviens notre cellule xml
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.listitem_movie, parent, false)
        }

        // 2 :: Retrouver l'instance Film associé à la cellule (get par l'index d'une List<Movie>)
        val movie = getItem(position);

        // 3 :: Alimenter la textview qui contient le titr du film par rapport à mon film
        // -- récupérer le TextView
        val idTextView = itemView!!.findViewById<TextView>(R.id.tvMovieId)
        val titleTextView = itemView!!.findViewById<TextView>(R.id.tvMovieTitle)
        val durationTextView = itemView!!.findViewById<TextView>(R.id.tvMovieDuration)

        // -- changer le texte des TextView
        idTextView.text = movie?.id.toString()
        titleTextView.text = movie?.title
        durationTextView.text = movie?.duration.toString()

        return itemView
    }
}