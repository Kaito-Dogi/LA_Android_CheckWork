package app.doggy.lacheckwork

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var count = 0
    val words: Array<String> = arrayOf("apple", "dog", "cat", "banana")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plusButton = findViewById<Button>(R.id.plusButton)
        val minusButton = findViewById<Button>(R.id.minusButton)
        val clearButton = findViewById<Button>(R.id.clearButton)

        val countText = findViewById<TextView>(R.id.countText)
        val wordText = findViewById<TextView>(R.id.wordText)

        plusButton.setOnClickListener(CountListener(countText, wordText))
        minusButton.setOnClickListener(CountListener(countText, wordText))
        clearButton.setOnClickListener(CountListener(countText, wordText))

    }

    private inner class CountListener(val countText: TextView, val wordText: TextView): View.OnClickListener {
        override fun onClick(view: View) {

            when(view.id) {
                R.id.plusButton -> count += 1
                R.id.minusButton -> count -= 1
                R.id.clearButton -> count = 0
            }

            countText.text = count.toString()

            changeTextColor(countText)

            displayWord(wordText)

        }
    }

    fun changeTextColor(countText: TextView) {
        if (count == 0) {
            countText.setTextColor(Color.BLACK)
        } else if (count%5 == 0 && count%3 == 0) {
            countText.setTextColor(Color.RED)
        } else if (count%5 == 0) {
            countText.setTextColor(Color.BLUE)
        } else if (count%3 == 0) {
            countText.setTextColor(Color.GREEN)
        } else {
            countText.setTextColor(Color.BLACK)
        }
    }

    fun displayWord(wordText: TextView) {
        when (count) {
            1 -> wordText.text = words[0]
            5 -> wordText.text = words[1]
            10 -> wordText.text = words[2]
            30 -> wordText.text = words[3]
            else -> wordText.setText(R.string.word_text)
        }
    }
}