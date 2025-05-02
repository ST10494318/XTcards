package za.ac.iie.xtcard

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        // Initialize UI components
        val tvReview: TextView = findViewById(R.id.tvReview)
        val btnExit: Button = findViewById(R.id.btnExit)

        // Retrieve data from intent
        val questions = intent.getStringArrayExtra("QUESTIONS") ?: arrayOf()
        val userAnswers = intent.getBooleanArrayExtra("USER_ANSWERS") ?: booleanArrayOf()

        // Build review text
        val reviewText = StringBuilder()
        for (i in questions.indices) {
            val userAnswer = if (i < userAnswers.size) userAnswers[i].toString() else "Not answered"
            reviewText.append("${i + 1}. ${questions[i]}\n")
            reviewText.append("Your answer: $userAnswer\n\n")
        }
        tvReview.text = reviewText.toString()

        // Exit button
        btnExit.setOnClickListener {
            finishAffinity() // Close the app
        }
    }
}