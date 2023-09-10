package presentation

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.usecase.GetDiscoverMoviesUseCase
import domain.model.MoviePosterSectionModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class DiscoverMoviesViewModel(
    private val getMovies: GetDiscoverMoviesUseCase
) : ViewModel() {
    private val _viewState = MutableStateFlow(DiscoverMoviesViewState())
    val viewState: StateFlow<DiscoverMoviesViewState> = _viewState

    init {
        refreshMovies()
    }

    fun refreshMovies() {
        viewModelScope.launch {
            _viewState.update { it.loading() }
            getMovies()
                .onSuccess(::handleSuccess)
                .onFailure(::handleFailure)
        }
    }

    private fun handleFailure(cause: Throwable) {
        val message = "Something went wrong"
        logError(message, cause)
        _viewState.update { it.error(message) }
    }

    private fun logError(message: String, cause: Throwable) {
        println("Movies App -> $message")
        println("Movies App -> Cause:")
        println("Movies App -> ${cause.stackTraceToString()}")
    }

    private fun handleSuccess(movies: List<MoviePosterSectionModel>) {
        _viewState.update { it.success(movies) }
    }
}