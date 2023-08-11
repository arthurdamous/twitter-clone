package dev.arthurdamous.clonetwitter.domain.repository

import dev.arthurdamous.clonetwitter.core.util.Resource
import dev.arthurdamous.clonetwitter.domain.model.Tweet
import kotlinx.coroutines.flow.Flow

interface TweetRepository {

    suspend fun getAllTweets(): Flow<Resource<List<Tweet>>>
}