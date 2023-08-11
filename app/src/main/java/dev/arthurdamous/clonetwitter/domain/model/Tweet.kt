package dev.arthurdamous.clonetwitter.domain.model

import java.time.LocalDateTime

data class Tweet(
    val id: String? = null,
    val content: String? = null,
    val imageUrl: String? = null,
    val timestamp: LocalDateTime? = null,
    val likesNumber: Long? = null,
    val commentNumber: Long? = null,
    val rtNumber: Long? = null,
    val viewNumber: Long? = null,
    val userId: String? = null,
)