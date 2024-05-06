package com.example.s7

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView

/**
 * A simple Activity that shows a message.
 */
class New1Activity : Activity() {

    companion object {
        // The name of the extra data sent through an Intent.
        const val KEY_EXTRA_MESSAGE = "com.example.android.testing.espresso.basicsample.MESSAGE"

        /**
         * Creates an Intent for ShowTextActivity with the message to be displayed.
         * @param context the Context where the Intent will be used
         * @param message a String with text to be displayed
         * @return an Intent used to start ShowTextActivity
         */
        fun newStartIntent(context: Context, message: String): Intent {
            val intent = Intent(context, New1Activity::class.java)
            intent.putExtra(KEY_EXTRA_MESSAGE, message)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new1)

        // Get the message from the Intent.
        val intent = intent
        val message = intent.getStringExtra(KEY_EXTRA_MESSAGE) ?: ""

        // Show message.
        findViewById<TextView>(R.id.show_text_view).text = message
    }
}
