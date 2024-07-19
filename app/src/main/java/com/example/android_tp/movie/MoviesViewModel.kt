package com.example.android_tp.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {

    var movies = MutableLiveData<List<Movie>>();

    fun syncMovies(){
        // lancer une tâche de fond (Coroutine)
        viewModelScope.launch {
            // Appeler l'api
            // -- mettre la réponse de l'api dans movies donc notifier les changement
            movies.value = MovieService.MovieApi.movieService.getMovies().data!!;
        }

    }
}