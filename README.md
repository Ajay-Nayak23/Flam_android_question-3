# 📚 BookReviewApp

BookReviewApp is an Android application developed in Java using Android Studio. It allows users to browse a list of books, view detailed information, and manage local reviews using Room Database.

---

## 🚀 Features

- 📘 Display a list of books using RecyclerView
- 🔍 View detailed information about selected books
- 📝 Store user reviews locally with Room database
- 🌐 Fetch book data from an API using Retrofit
- 🎨 Load book images with Glide
- 💡 MVVM Architecture using ViewModel and LiveData

---

## 🛠 Tech Stack

| Technology | Purpose |
|------------|---------|
| Java       | Main programming language |
| XML        | UI layouts |
| Room       | Local database |
| Retrofit   | Network requests |
| Gson       | JSON serialization |
| Glide      | Image loading |
| ViewModel & LiveData | Lifecycle-aware components |
| RecyclerView | Displaying lists of items |

---

## 📦 Project Structure

      BookReviewApp/
      ├── app/
      │ ├── java/com/example/bookreviewapp/
      │ │ ├── room/ # Room database and DAO
      │ │ ├── ui/ # Activities and UI components
      │ │ ├── network/ # Retrofit API services
      │ │ ├── viewmodel/ # ViewModels
      │ │ ├── model/ # Data models
      │ │ └── utils/ # Helper classes (if any)
      │ └── res/
      │ ├── layout/ # XML layout files
      │ └── drawable/ # Images and icons



---

## 🧑‍💻 Getting Started

### Prerequisites

- Android Studio Flamingo or newer
- JDK 11 or higher
- Gradle 8+

### Build & Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Ajay-Nayak23/Flam_android_question-3.git
2.  Open the project in Android Studio.
3.  Click “Run” to build and launch the app.



Here are some screenshots of the BookReviewApp in action:

Description of the first screenshot: This screenshot shows the BookReviewApp's main screen.
![image](https://github.com/user-attachments/assets/f8b86b28-19d3-4ad1-9501-043b4bdcea24)


Description of the second screenshot: This screenshot displays the list of books available in the app, showcasing the main content area.

![image](https://github.com/user-attachments/assets/c4655e79-5834-4abd-9f0e-c46a1cb2e91a)



Description of the third screenshot: This screenshot highlights the detailed view of a book, including the description and user reviews.
![image](https://github.com/user-attachments/assets/1c5fdc46-939c-4856-b347-8754a927419f)


(Upload your screenshots to your repository or an image hosting service, and replace path_to_screenshot_X.png with the actual paths to your images.)




Testing: 
    
    Run tests using Gradle:
  
      ./gradlew test
      ./gradlew connectedAndroidTest


Author
Created by Jarpula Ajay Nayak
   
