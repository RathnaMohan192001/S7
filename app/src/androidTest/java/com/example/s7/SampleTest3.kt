package com.example.s7

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class SampleTest3 {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    //Tests without idling.
    @Test
    fun test2() {
        Espresso.onView(ViewMatchers.withId(R.id.changeTextBt))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.textToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText("Waitttttt")))
    }

    @Test
    fun test1() {
        val text = "Hello, Have a wonderful day"
        Espresso.onView(ViewMatchers.withId(R.id.editTextUserInput))
            .perform(ViewActions.typeText(text), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.changeTextBt))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.editTextUserInput))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))

    }

    //Test when text is typed and open_activity button is clicked the text is displayed at next page.
    @Test
    fun test4() {
        val text = "Hello, Have a wonderful day"
        Espresso.onView(ViewMatchers.withId(R.id.editTextUserInput))
            .perform(ViewActions.typeText(text), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.activityChangeTextBtn))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.show_text_view))
            .check(ViewAssertions.matches(ViewMatchers.withText(text)))


    }

    //when nothing is typed and open_activity button clicked empty text shown.
    @Test
    fun test5() {
        Espresso.onView(ViewMatchers.withId(R.id.activityChangeTextBtn))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.show_text_view))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))

    }

    //when no text typed and change_text button is clicked empty text is displayed.
    @Test
    fun test6() {


        Espresso.onView(ViewMatchers.withId(R.id.changeTextBt))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.editTextUserInput))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))

    }
}