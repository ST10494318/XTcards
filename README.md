LINK TO GITHUB REPORITORY : https://github.com/ST10494318/XTcards.git

LINK TO MY YOUTUBE VIDEO : https://youtu.be/cw3WAvkCuRE

1. Purpose of the App
   
The Flashcard app is a study tool to help users test their history knowledge with five True/False questions.
 It tracks scores, provides immediate feedback ("Correct" or "Incorrect"), and offers personalized feedback
 ("Great job!" for 3+ correct, "Keep practicing!" for <3). Users can review or exit after the quiz.

2. Design of the App
   
The app features three screens with a simple, user-friendly UI built in Android Studio with Kotlin.

Welcome Screen: Displays a welcome message and a "Start" button (RelativeLayout).
Flashcard Question Screen: Shows one question, "True"/"False" buttons, feedback, and a "Next" button (LinearLayout).
Score Screen: Displays the score (e.g., "Your Score: 3/5"), feedback, "Review" button, and "Exit" button (LinearLayout).
Navigation: Starts at Welcome, moves to Flashcard after "Start", to Score after five questions, with "Review" restarting and "Exit" closing the app.

3. Implementation Details
   
Activities: WelcomeActivity, FlashcardActivity, ScoreActivity.
Layouts: activity_welcome.xml, activity_flashcard.xml, activity_score.xml.
Logic: Uses QuizLogic class for quiz management (questions, answers, score).
Welcome: Navigates to Flashcard on "Start".
Flashcard: Checks answers, updates score, moves to next question or Score.
Score: Shows score and feedback, handles "Review" and "Exit".

Code Snippet (QuizLogic) :

data class QuizLogic(val questions: Array<String> = arrayOf(...), val answers: Array<Boolean> = arrayOf(...)) {
    var currentQuestionIndex = 0
    var score = 0
    fun checkAnswer(userAnswer: Boolean): String = if (userAnswer == answers[currentQuestionIndex]) { score++; "Correct!" } else "Incorrect!"
    fun moveToNextQuestion(): Boolean { currentQuestionIndex++; return currentQuestionIndex < questions.size }
}

4. Testing
   
Unit Tests:
FlashcardActivityTest: Tests QuizLogic (answer checking, navigation).
ScoreActivityTest: Tests score display and feedback (using Robolectric).
Tools: JUnit, Mockito, Robolectric.
Result: All tests pass locally.
6. Continuous Integration
Workflow: GitHub Actions (android-ci.yml) runs on master branch pushes/pull requests.
Steps: Sets up JDK 17, runs ./gradlew testDebugUnitTest, builds debug APK, uploads test reports and APK.
Outcome: Automates testing and building.

GITHUB ACTIONS :

![image](https://github.com/user-attachments/assets/4772d60c-06b4-4070-b5f6-8c4fa9457438)

UNIT TESTING :

![image](https://github.com/user-attachments/assets/9a9c7425-ea99-47f8-b8e0-d45bdc5bed02)

USER INTERFACE :

![image](https://github.com/user-attachments/assets/52ba3dbc-e47a-4423-a799-a01fb1789187)

![1](https://github.com/user-attachments/assets/e59f4519-2b44-47e3-8972-bb65cb134ded)

![2](https://github.com/user-attachments/assets/1efd821c-bf96-476b-aabc-ec7b4bdaf855)

![3](https://github.com/user-attachments/assets/7d4fba1f-2260-48c7-b1bc-a1243cfabe97)

CODE :

![4](https://github.com/user-attachments/assets/c9ddfcfd-57b1-4931-a8fe-04cc32c8e9e5)

![5](https://github.com/user-attachments/assets/cbe75fcb-f13b-4189-9f20-195cf813e2b6)

![6](https://github.com/user-attachments/assets/b1113778-49f8-4eef-a922-b51c48ed9cf4)

![7](https://github.com/user-attachments/assets/4c60dac6-a937-480a-a94e-6d790911b369)

![8](https://github.com/user-attachments/assets/8ef57e4f-d7b7-4638-9e60-c7f2c25b501f)

![9](https://github.com/user-attachments/assets/876a1fc8-a2bc-4ead-87c0-e5cc228fac02)





