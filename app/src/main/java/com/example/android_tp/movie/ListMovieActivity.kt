package com.example.android_tp.movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.android_tp.R
import com.example.android_tp.databinding.ActivityListMovieBinding

class ListMovieActivity : ComponentActivity() {

    lateinit var viewBinding: ActivityListMovieBinding;
    lateinit var moviesViewModel: MoviesViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger la vue en mode DataBinding
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_movie)

        // Instancer mon view model
        moviesViewModel = MoviesViewModel();

        // Ecouter les changements des films dans le viewmodel
        moviesViewModel.movies.observe(this, Observer {
            // Instancier l'adpateur personnalisé
            val adapter = MovieAdapter(this,  moviesViewModel.movies.value!!);

            // Afficher la liste avec les données
            // -- associer l'adapter dans la listeview
            viewBinding.lvMovies.adapter = adapter;
        })

        // Quand clique boutton rappeler l'api
        viewBinding.btnCallApi.setOnClickListener {
            // nettoyer la liste view (supprimer les elements)
            val adapter = MovieAdapter(this,  listOf());
            viewBinding.lvMovies.adapter = adapter;

            // appel api
            moviesViewModel.syncMovies();
        }

        // Lance appel API
        moviesViewModel.syncMovies();
    }
}