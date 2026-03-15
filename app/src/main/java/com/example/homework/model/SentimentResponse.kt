package com.example.homework.model

import kotlinx.serialization.Serializable

@Serializable
data class SentimentResponse(
    val candidates: List<Candidate>
)

@Serializable
data class Candidate(
    val content: Content
)

@Serializable
data class Content(
    val parts: List<Part>
)

@Serializable
data class Part(
    val text: String
)

data class SentimentResult(
    val sentiment: String,
    val emoji: String,
    val color: String
)
