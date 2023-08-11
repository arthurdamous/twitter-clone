package dev.arthurdamous.clonetwitter.presentation.home

import dev.arthurdamous.clonetwitter.domain.model.Tweet

data class MainState(
    val isLoading: Boolean = false,
    val listOfTweets: List<Tweet> = emptyList()
)
