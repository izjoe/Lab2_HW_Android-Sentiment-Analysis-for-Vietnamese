package com.example.homework.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework.data.SentimentRepository
import com.example.homework.model.SentimentResult
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = SentimentRepository()

    private val _sentimentResult = MutableLiveData<SentimentResult?>()
    val sentimentResult: LiveData<SentimentResult?> = _sentimentResult

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun analyze(text: String) {
        if (text.isBlank()) {
            _errorMessage.value = "Please enter some text"
            return
        }

        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            val result = repository.analyzeSentiment(text)
            
            result.onSuccess { sentiment ->
                val processed = when {
                    sentiment.contains("Positive", ignoreCase = true) -> 
                        SentimentResult("Positive", "😊", "#2ECC71")
                    sentiment.contains("Negative", ignoreCase = true) -> 
                        SentimentResult("Negative", "☹️", "#E74C3C")
                    else -> 
                        SentimentResult("Neutral", "😐", "#95A5A6")
                }
                _sentimentResult.value = processed
            }.onFailure {
                _errorMessage.value = "Failed to analyze: ${it.message}"
            }
            
            _isLoading.value = false
        }
    }
}
