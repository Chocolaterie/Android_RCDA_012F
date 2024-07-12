package com.example.android_tp.movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.example.android_tp.R
import com.example.android_tp.databinding.ActivityListMovieBinding

class ListMovieActivity : ComponentActivity() {

    lateinit var viewBinding: ActivityListMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger la vue en mode DataBinding
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_movie)

        // Liste de films
        val movies = listOf(
            Movie(1, "Teletubbies", "Best serie ever", 1995),
            Movie(2, "MyLittlePoney", "Stylé en vrai", 1995),
            Movie(3, "Manège enchanté", "Pour les grands", 1995),
            Movie(4, "DB GT", "La moustache de V", 1995),
            Movie(5, "Oui !Oui !", "Y'a un ECF ?", 1998),
        );

        // Instancier l'adpateur personnalisé
        val adapter = MovieAdapter(this, movies);

        // Afficher la liste avec les données
        // -- associer l'adapter dans la listeview
        viewBinding.lvMovies.adapter = adapter;
    }
}