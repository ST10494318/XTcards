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






