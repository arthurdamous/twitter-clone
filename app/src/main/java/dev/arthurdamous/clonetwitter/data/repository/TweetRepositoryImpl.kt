package dev.arthurdamous.clonetwitter.data.repository

import android.annotation.SuppressLint
import com.google.firebase.FirebaseException
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.snapshots
import dev.arthurdamous.clonetwitter.core.util.Resource
import dev.arthurdamous.clonetwitter.domain.model.Tweet
import dev.arthurdamous.clonetwitter.domain.repository.TweetRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import java.time.LocalDateTime

class TweetRepositoryImpl(
    private val db: FirebaseFirestore,
) : TweetRepository {

    @SuppressLint("NewApi")
    override suspend fun getAllTweets(): Flow<Resource<List<Tweet>>> = channelFlow {
        send(Resource.Loading())
        delay(500L)
        try {
            val tweets = db.collection("tweets")

            tweets.snapshots()
                .collectLatest {
                    val listOfTweetsRemote = mutableListOf<Tweet>()
                    for (document in it) {
                        listOfTweetsRemote.add(
                            Tweet(
                                id = document.id,
                                content = document.data["content"] as String,
                                timestamp = LocalDateTime.now(),
                                likesNumber = document.data["likesNumber"] as Long,
                                commentNumber = document.data["commentNumber"] as Long,
                                viewNumber = document.data["viewNumber"] as Long,
                                rtNumber = document.data["rtNumber"] as Long,
                                imageUrl = document.data["imageUrl"] as String
                            )
                        )
                    }
                    send(
                        Resource.Success(
                            data = listOfTweetsRemote.plus(listOfTweetsRemote)
                        )
                    )
                }


        } catch (e: FirebaseException) {
            send(
                Resource.Error(
                    message = e.message ?: "Error unknown"
                )
            )
        }

    }

}