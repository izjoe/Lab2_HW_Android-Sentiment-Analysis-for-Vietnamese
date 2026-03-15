package com.example.homework;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private Button btnSubmit;
    private ImageView imgResult;
    private LinearLayout mainLayout;

    // Mock Sentiment Keywords
    private final List<String> positiveKeywords = Arrays.asList("good", "great", "happy", "love", "amazing", "excellent");
    private final List<String> negativeKeywords = Arrays.asList("bad", "sad", "terrible", "hate", "awful", "worst");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        inputText = findViewById(R.id.inputText);
        btnSubmit = findViewById(R.id.btnSubmit);
        imgResult = findViewById(R.id.imgResult);
        mainLayout = findViewById(R.id.mainLayout);

        // Set click listener for the Submit button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = inputText.getText().toString().trim();
                if (!text.isEmpty()) {
                    analyzeSentiment(text);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a sentence", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Analyzes the sentiment of the input text using simple keyword matching.
     * In a real app, this would call a REST API.
     */
    private void analyzeSentiment(String text) {
        String lowerCaseText = text.toLowerCase();
        String sentiment = "neutral";

        // Simple mock sentiment analysis logic
        for (String word : positiveKeywords) {
            if (lowerCaseText.contains(word)) {
                sentiment = "positive";
                break;
            }
        }

        if (sentiment.equals("neutral")) {
            for (String word : negativeKeywords) {
                if (lowerCaseText.contains(word)) {
                    sentiment = "negative";
                    break;
                }
            }
        }

        updateUI(sentiment);
    }

    /**
     * Updates the UI based on the sentiment analysis result.
     */
    private void updateUI(String sentiment) {
        if (sentiment.equals("positive")) {
            mainLayout.setBackgroundColor(Color.parseColor("#C8E6C9")); // Light Green
            imgResult.setImageResource(R.drawable.happy);
            Toast.makeText(this, "Positive Sentiment!", Toast.LENGTH_SHORT).show();
        } else if (sentiment.equals("negative")) {
            mainLayout.setBackgroundColor(Color.parseColor("#FFCDD2")); // Light Red
            imgResult.setImageResource(R.drawable.sad);
            Toast.makeText(this, "Negative Sentiment!", Toast.LENGTH_SHORT).show();
        } else {
            mainLayout.setBackgroundColor(Color.WHITE);
            imgResult.setImageDrawable(null);
            Toast.makeText(this, "Neutral Sentiment", Toast.LENGTH_SHORT).show();
        }
    }
}
