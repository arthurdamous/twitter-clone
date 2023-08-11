package dev.arthurdamous.clonetwitter.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.arthurdamous.clonetwitter.core.ui.theme.CloneTwitterTheme
import dev.arthurdamous.clonetwitter.core.util.StandardScaffold
import dev.arthurdamous.clonetwitter.domain.model.Tweet
import dev.arthurdamous.clonetwitter.presentation.home.components.TweetItem

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CloneTwitterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val snackbarHostState = remember { SnackbarHostState() }
                    val navController = rememberNavController()

                    StandardScaffold(
                        snackbarHostState,
                        navController
                    )
                }
            }
        }
    }
}



@Preview
@Composable
fun TweetItemPreview() {
    CloneTwitterTheme {
        Surface {
            TweetItem(
                tweet = Tweet(
                    content = "ALow"
                )
            )
        }
    }
}
