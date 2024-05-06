package com.example.s7

/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.VisibleForTesting
import androidx.test.espresso.IdlingResource
import com.example.s7.IdlingResource.SimpleIdlingResource

/**
 * An Activity that gets a text string from the user and displays it back when the user
 * clicks on one of the two buttons. The first one shows it in the same activity and the second
 * one opens another activity and displays the message.
 */
class MainActivity : Activity(), View.OnClickListener {

    // The TextView used to display the message inside the Activity.
    private lateinit var mTextView: TextView

    // The EditText where the user types the message.
    private lateinit var mEditText: EditText

    private var mIdlingResource: SimpleIdlingResource? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set the listeners for the buttons.
        findViewById<View>(R.id.changeTextBt).setOnClickListener(this)
        findViewById<View>(R.id.activityChangeTextBtn).setOnClickListener(this)

        mTextView = findViewById(R.id.textToBeChanged)
        mEditText = findViewById(R.id.editTextUserInput)
    }

    override fun onClick(view: View) {
        // Get the text from the EditText view.
        val text = mEditText.text.toString()

        val changeTextBtId = R.id.changeTextBt
        val activityChangeTextBtnId = R.id.activityChangeTextBtn

        if (view.id == changeTextBtId) {
            // First button's interaction: set a text in a text view.
            mTextView.text = text
            val waiting_msg="Waitttttt"
            mTextView?.setText(waiting_msg)
            MessageDelayer.processMessage(text, this, mIdlingResource)

            mEditText.setText("")
        }
        else if (view.id == activityChangeTextBtnId) {
            // Second button's interaction: start an activity and send a message to it.
            val intent = New1Activity.newStartIntent(this, text)
            mEditText.setText("")
            startActivity(intent)
        }
    }

    fun onDone(text: String?) {

        mTextView!!.text = text

    }

    @get:VisibleForTesting
    val idlingResource: IdlingResource
        get() {
            if (mIdlingResource == null) {
                mIdlingResource = SimpleIdlingResource()
            }
            return mIdlingResource as SimpleIdlingResource
        }
}
