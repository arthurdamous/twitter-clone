package dev.arthurdamous.clonetwitter.domain.use_case

import dev.arthurdamous.clonetwitter.core.util.Resource
import dev.arthurdamous.clonetwitter.domain.model.Tweet
import dev.arthurdamous.clonetwitter.domain.repository.TweetRepository
import kotlinx.coroutines.flow.Flow

class GetAllTweets(
    private val repository: TweetRepository,
) {

    suspend operator fun invoke(): Flow<Resource<List<Tweet>>> {
        return repository.getAllTweets()
    }
}
