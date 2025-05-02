package za.ac.iie.xtcard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val finalScoreText: TextView = findViewById(R.id.finalScoreText)
        val feedbackText: TextView = findViewById(R.id.feedbacktext)
        val reviewButton: Button = findViewById(R.id.reviewButton)


        // Retrieve data from intent
        val score = intent.getIntExtra("SCORE", 0)
        val totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 0)
        val questions = intent.getStringArrayExtra("QUESTIONS") ?: arrayOf()
        val userAnswers = intent.getBooleanArrayExtra("USER_ANSWERS") ?: booleanArrayOf()

        // Update UI
        finalScoreText.text = "$score/$totalQuestions"
        feedbackText.text = if (score >= 3) "Good job!" else "Keep practicing"

        // Review button navigates to ReviewActivity
        reviewButton.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            intent.putExtra("QUESTIONS", questions)
            intent.putExtra("USER_ANSWERS", userAnswers)
            startActivity(intent)
            finish()
        }

        }
    }
