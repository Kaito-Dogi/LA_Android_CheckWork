package app.doggy.lacheckwork

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val countArray: Array<String> = arrayOf("apple", "dog", "cat", "banana")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count = 0

        val plusButton = findViewById<Button>(R.id.plusButton)
        val minusButton = findViewById<Button>(R.id.minusButton)
        val clearButton = findViewById<Button>(R.id.clearButton)

        val countText = findViewById<TextView>(R.id.countText)
        val wordText = findViewById<TextView>(R.id.wordText)

        plusButton.setOnClickListener {

            count += 1

            countText.text = count.toString()

            changeTextColor(count, countText)

            displayWord(count, wordText)

        }

        minusButton.setOnClickListener {

            count -= 1

            countText.text = count.toString()

            changeTextColor(count, countText)

            displayWord(count, wordText)

        }

        clearButton.setOnClickListener {

            count = 0

            countText.text = count.toString()

            changeTextColor(count, countText)

            displayWord(count, wordText)

        }

    }

    fun changeTextColor(count: Int, textView: TextView) {
        if (count == 0) {
            textView.setTextColor(Color.BLACK)
        } else if (count%5 == 0 && count%3 == 0) {
            textView.setTextColor(Color.RED)
        } else if (count%5 == 0) {
            textView.setTextColor(Color.BLUE)
        } else if (count%3 == 0) {
            textView.setTextColor(Color.GREEN)
        } else {
            textView.setTextColor(Color.BLACK)
        }
    }

    fun displayWord(count: Int, textView: TextView) {
        when (count) {
            0 -> textView.text = countArray[0]
            5 -> textView.text = countArray[1]
            10 -> textView.text = countArray[2]
            30 -> textView.text = countArray[3]
            else -> textView.setText(R.string.word_text)
        }
    }
}