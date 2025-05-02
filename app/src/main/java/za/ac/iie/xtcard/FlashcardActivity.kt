package za.ac.iie.xtcard

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class FlashcardActivity : AppCompatActivity() {

    private lateinit var questionText: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var feedbackText: TextView
    private lateinit var nextButton: Button

    // Two parallel arrays for questions and answers as per requirements
    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994.",
        "The American Civil War ended in 1865.",
        "The Great Wall of China was built in the 19th century.",
        "The Roman Empire fell in 476 AD.",
        "World War I began in 1918."
    )
    private val answers = arrayOf(true, true, false, true, false)
    private var currentQuestionIndex = 0
    private var score = 0 // Initialize score to zero
    private var answerSelected = false
    private val userAnswers = BooleanArray(questions.size) // Track user answers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard)

        // Initialize UI components
        questionText = findViewById(R.id.questionText)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        feedbackText = findViewById(R.id.feedbacktext)
        nextButton = findViewById(R.id.nextButton)

        // Display the first question
        displayQuestion()

        // Handle True button click
        trueButton.setOnClickListener {
            if (!answerSelected) {
                checkAnswer(true)
                userAnswers[currentQuestionIndex] = true // Store user answer
                answerSelected = true
                trueButton.isEnabled = false
                falseButton.isEnabled = false
                nextButton.visibility = View.VISIBLE
            }
        }

        // Handle False button click
        falseButton.setOnClickListener {
            if (!answerSelected) {
                checkAnswer(false)
                userAnswers[currentQuestionIndex] = false // Store user answer
                answerSelected = true
                trueButton.isEnabled = false
                falseButton.isEnabled = false
                nextButton.visibility = View.VISIBLE
            }
        }

        // Handle Next button click to move to the next question or Score Screen
        nextButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                displayQuestion()
                answerSelected = false
                trueButton.isEnabled = true
                falseButton.isEnabled = true
                nextButton.visibility = View.GONE
                feedbackText.text = ""
            } else {
                // Move to Score Screen after all questions are answered
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("SCORE", score)
                intent.putExtra("TOTAL_QUESTIONS", questions.size)
                intent.putExtra("QUESTIONS", questions)
                intent.putExtra("USER_ANSWERS", userAnswers)
                startActivity(intent)
                finish()
            }
        }
    }

    // Function to display the current question
    private fun displayQuestion() {
        questionText.text = questions[currentQuestionIndex]
    }

    // Function to check the user's answer and provide feedback
    @SuppressLint("SetTextI18n")
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestionIndex]
        if (userAnswer == correctAnswer) {
            feedbackText.text = "Correct!"
            score++ // Update score (1 mark per correct answer)
        } else {
            feedbackText.text = "Incorrect!"
        }
    }
}