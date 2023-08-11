package dev.arthurdamous.clonetwitter.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.arthurdamous.clonetwitter.core.util.Resource
import dev.arthurdamous.clonetwitter.domain.use_case.TweetUseCases
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val tweetUseCases: TweetUseCases,
) : ViewModel() {

    private val _state = mutableStateOf(MainState())
    val state: State<MainState> = _state

    init {
        viewModelScope.launch {
            tweetUseCases.getAllTweets().collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            isLoading = false
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            isLoading = true
                        )
                    }

                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            listOfTweets = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                }
            }
        }
    }

}