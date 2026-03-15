package com.example.homework.data

import com.example.homework.model.SentimentResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class SentimentRepository {
    private val apiKey = "AIzaSyD_tB_-f3vJp3sQ-0zZ-L5X8v_JQx5vZg8" // Sample Key (User should replace)
    private val baseUrl = "https://generativelanguage.googleapis.com/"

    private val json = Json { ignoreUnknownKeys = true }

    private val api: SentimentApi by lazy {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(SentimentApi::class.java)
    }

    suspend fun analyzeSentiment(text: String): Result<String> {
        return try {
            val prompt = "Analyze the sentiment of the following text and reply with only one word: 'Positive', 'Negative', or 'Neutral'. Text: \"$text\""
            val request = ContentRequest(
                contents = listOf(
                    ContentPart(parts = listOf(TextPart(text = prompt)))
                )
            )
            val response = api.analyzeSentiment(apiKey, request)
            if (response.isSuccessful) {
                val sentiment = response.body()?.candidates?.firstOrNull()?.content?.parts?.firstOrNull()?.text?.trim() ?: "Neutral"
                Result.success(sentiment)
            } else {
                Result.failure(Exception("API Error: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
