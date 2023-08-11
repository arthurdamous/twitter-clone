package dev.arthurdamous.clonetwitter.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dev.arthurdamous.clonetwitter.presentation.home.components.TweetItem

@Composable
fun HomeMainScreen(
    viewModel: MainViewModel = hiltViewModel(),
) {

    val state = viewModel.state.value

    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn {
            items(state.listOfTweets.size) {
                TweetItem(tweet = state.listOfTweets[it])
            }
        }
    }

}