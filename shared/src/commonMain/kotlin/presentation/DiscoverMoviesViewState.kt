package presentation

import domain.model.MoviePosterSectionModel

data class DiscoverMoviesViewState(
    val isLoading: Boolean = false,
    val sections: List<MoviePosterSectionModel> = emptyList(),
    val errorMessage: String? = null
) {
    fun loading(
        placeholder: List<MoviePosterSectionModel>? = null
    ) = copy(isLoading = true, errorMessage = null, sections = placeholder ?: sections)

    fun error(message: String) =
        copy(isLoading = false, errorMessage = message)

    fun success(movies: List<MoviePosterSectionModel>) =
        copy(isLoading = false, errorMessage = null, sections = movies)
}