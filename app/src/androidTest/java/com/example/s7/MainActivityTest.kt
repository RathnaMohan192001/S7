package com.example.s7

import androidx.test.espresso.Espresso

import  androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainacitivityTest {


    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java) //Which activity you want to test.




    @Test  //It tells espresso that below is test code run it.
    fun checkTextPassingToNextActivity() {
        //Type some text into edit text

        val password3 = "Welcome shantveer"
        Espresso.onView(ViewMatchers.withId(R.id.editTextUserInput))
            .perform(ViewActions.typeText(password3), ViewActions.closeSoftKeyboard())   //closing keyboard because it may interrupt testing.


//        //Click on the button
        Espresso.onView(ViewMatchers.withId(R.id.changeTextBt))
            .perform(ViewActions.click())
        //            .check(ViewAssertions.matches(ViewMatchers.withText("Button")))

        //After click on button directs to next activity so no need to specify that.

        //Check if the text matches in the next activity
//        Espresso.onView(ViewMatchers.withId(R.id.textView2))
//            .check(ViewAssertions.matches(ViewMatchers.withText(password3)))


        //Checking whether text box has Hello World! text.
//        Espresso.pressBack() // To go back to previous page. - go to back page and then check Hello World!.
//        onView(ViewMatchers.withId(R.id.textView2))
//            .check(ViewAssertions.matches(ViewMatchers.withText("Hello World!")))



    }
}