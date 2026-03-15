package com.example.homework.data

import com.example.homework.model.SentimentResponse
import kotlinx.serialization.Serializable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

@Serializable
data class ContentRequest(
    val contents: List<ContentPart>
)

@Serializable
data class ContentPart(
    val parts: List<TextPart>
)

@Serializable
data class TextPart(
    val text: String
)

interface SentimentApi {
    @POST("v1beta/models/gemini-1.5-flash:generateContent")
    suspend fun analyzeSentiment(
        @Query("key") apiKey: String,
        @Body request: ContentRequest
    ): Response<SentimentResponse>
}
