package dev.arthurdamous.clonetwitter.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.arthurdamous.clonetwitter.data.repository.TweetRepositoryImpl
import dev.arthurdamous.clonetwitter.domain.repository.TweetRepository
import dev.arthurdamous.clonetwitter.domain.use_case.GetAllTweets
import dev.arthurdamous.clonetwitter.domain.use_case.TweetUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun providesFirebaseFirestore(): FirebaseFirestore {
        return Firebase.firestore
    }

    @Provides
    @Singleton
    fun providesTweetRepository(
        firestore: FirebaseFirestore,
    ): TweetRepository {
        return TweetRepositoryImpl(firestore)
    }

    @Provides
    @Singleton
    fun providesTweetUseCases(
        repository: TweetRepository,
    ): TweetUseCases {
        return TweetUseCases(
            getAllTweets = GetAllTweets(repository)
        )
    }

}