# Lab2_HW_Android-Sentiment-Analysis-for-Vietnamese
.Demo: https://drive.google.com/drive/u/0/folders/1OWWOfUnb6ZgYrqEV3iq92Jf93EvwMupE

## Overview

This repository contains the Lab 2 homework project for Android sentiment analysis.  
The application allows users to enter a text sentence and analyze its sentiment.

The sentiment result can be classified as:

- Positive
- Negative
- Neutral

The project is designed as an Android application and includes a simple sentiment analysis flow. It also contains API-related files for connecting to a text analysis service.

---

## Features

- Enter text for sentiment analysis
- Analyze user input
- Display sentiment result
- Support positive, negative, and neutral sentiment
- Update UI based on sentiment result
- Show result using color, image, or message
- Android mobile interface
- API structure for sentiment analysis integration

---

## Tech Stack

- Java
- Kotlin
- Android Studio
- Gradle Kotlin DSL
- XML Layout
- Retrofit
- OkHttp
- Kotlin Serialization
- Gemini API structure

---

## Project Structure

```text
Lab2_HW_Android-Sentiment-Analysis-for-Vietnamese/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/homework/
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── data/
│   │   │   │   │   ├── SentimentApi.kt
│   │   │   │   │   └── SentimentRepository.kt
│   │   │   │   ├── model/
│   │   │   │   │   └── SentimentResponse.kt
│   │   │   │   └── ui/
│   │   │   ├── res/
│   │   │   │   ├── drawable/
│   │   │   │   ├── layout/
│   │   │   │   ├── values/
│   │   │   │   └── xml/
│   │   │   └── AndroidManifest.xml
│   └── build.gradle.kts
│
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew
├── gradlew.bat
└── README.md
```

---

## Main Components

### MainActivity.java

`MainActivity.java` contains the main UI logic of the application.  
It allows users to enter a sentence, press a submit button, and receive a sentiment result.

The current logic can detect simple sentiment using keyword matching. For example:

- Positive keywords: good, great, happy, love, amazing, excellent
- Negative keywords: bad, sad, terrible, hate, awful, worst

After analyzing the text, the app updates the UI based on the detected sentiment.

---

### MainActivity.kt

`MainActivity.kt` is another Android activity entry file.  
It loads the main layout of the application.

---

### SentimentApi.kt

`SentimentApi.kt` defines the API interface for sending text to a sentiment analysis service.

---

### SentimentRepository.kt

`SentimentRepository.kt` handles API configuration and sends the sentiment analysis request.

Important note: API keys should not be hardcoded in source code.  
Use `local.properties`, environment variables, or another secure configuration method instead.

---

### SentimentResponse.kt

`SentimentResponse.kt` defines response models used to parse the sentiment analysis result from the API.

---

## How to Run

### Requirements

Before running the project, make sure you have installed:

- Android Studio
- Android SDK
- JDK 17 or higher
- Android Emulator or a real Android device
- Internet connection if using API-based sentiment analysis

---

### Run with Android Studio

1. Clone this repository:

```bash
git clone https://github.com/izjoe/Lab2_HW_Android-Sentiment-Analysis-for-Vietnamese.git
```

2. Open **Android Studio**.

3. Choose **Open an Existing Project**.

4. Select the cloned project folder:

```text
Lab2_HW_Android-Sentiment-Analysis-for-Vietnamese
```

5. Wait for Gradle to sync.

6. Select an Android emulator or connect a real Android device.

7. Click the **Run** button.

8. The application will be built and launched on the selected device.

---

### Run with Terminal

For macOS or Linux:

```bash
./gradlew build
```

For Windows:

```bash
gradlew.bat build
```

To install the debug version on a connected Android device:

```bash
./gradlew installDebug
```

---

## API Key Setup

If the app uses Gemini API or another external sentiment analysis API, do not commit the API key directly to GitHub.

A safer approach is to store the key in `local.properties`:

```properties
GEMINI_API_KEY=your_api_key_here
```

Then load it through Gradle or BuildConfig.

Example idea:

```kotlin
val apiKey = BuildConfig.GEMINI_API_KEY
```

This helps avoid exposing sensitive keys in the public repository.

---

## How to Use

1. Open the application.
2. Enter a Vietnamese or English sentence.
3. Tap the submit/analyze button.
4. The app will analyze the text.
5. The result will be displayed as positive, negative, or neutral.
6. The UI may change color or show an image based on the result.

---

## Demo

Demo folder:

```text
https://drive.google.com/drive/u/0/folders/1OWWOfUnb6ZgYrqEV3iq92Jf93EvwMupE
```

---

## Notes

- This is a Lab 2 Android homework project.
- The app focuses on basic sentiment analysis on Android.
- The current project includes both simple local keyword-based logic and API integration structure.
- API keys should be removed from source code before pushing to GitHub.

---

## Future Improvements

- Improve Vietnamese sentiment analysis accuracy
- Add a real machine learning model
- Connect fully with a backend API
- Add loading state while analyzing
- Show confidence score
- Add sentiment history
- Improve UI design
- Support more Vietnamese expressions and slang
- Add error handling for API connection failures

---

## Author

**Nguyễn Bảo Châu**

- University: University of Information Technology – VNUHCM
- Major: Information System
- Email: baochaune21@gmail.com

---

## License

This project is used for educational purposes.
