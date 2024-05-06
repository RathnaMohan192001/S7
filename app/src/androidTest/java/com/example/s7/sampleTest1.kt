package com.example.s7

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class sampleTest1 {

    //UI testing

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    //Checking text at textToBeChanged is hello_world.
    @Test
    fun test1() {
        onView(ViewMatchers.withId(R.id.textToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText("hello_world")))
    }

    //changeTextBt - CHANGE_TEXT
    @Test
    fun test2() {
        onView(ViewMatchers.withId(R.id.changeTextBt))
            .check(ViewAssertions.matches(ViewMatchers.withText("CHANGE_TEXT")))
    }

    //editTextUserInput - empty
    @Test
    fun test3() {
        onView(ViewMatchers.withId(R.id.editTextUserInput))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    //activityChangeTextBtn - OPEN_ACTIVITY_AND_CHANGE_TEXT
    @Test
    fun test4() {
        onView(ViewMatchers.withId(R.id.activityChangeTextBtn))
            .check(ViewAssertions.matches(ViewMatchers.withText("OPEN_ACTIVITY_AND_CHANGE_TEXT")))
    }

    //editTextUserInput - hint - n
    @Test
    fun test5() {
        onView(ViewMatchers.withId(R.id.editTextUserInput))
            .check(ViewAssertions.matches(ViewMatchers.withHint("n")))
    }





}