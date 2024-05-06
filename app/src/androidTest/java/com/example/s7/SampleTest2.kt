package com.example.s7
import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SampleTest2 {
    private var mIdlingResource: IdlingResource? = null


    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


//Test with idling.
    @Before
    fun registerIdlingResource() {
        val activityScenario: ActivityScenario<MainActivity> =
            ActivityScenario.launch(MainActivity::class.java)
        activityScenario.onActivity { activity ->                //REgistering idle resources.
            mIdlingResource = activity.idlingResource
            IdlingRegistry.getInstance().register(mIdlingResource)
        }
    }
    //Testing idling when text typed and button clicked text is changed after idling.
    @Test
    fun test3() {
        val text = "Hello, Have a wonderful day"
        onView(ViewMatchers.withId(R.id.editTextUserInput))
            .perform(ViewActions.typeText(text), ViewActions.closeSoftKeyboard())
        onView(ViewMatchers.withId(R.id.changeTextBt))
            .perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.textToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText(text)))



    }
    @After
    fun unregisterIdlingResource() {
        if (mIdlingResource != null) {
            IdlingRegistry.getInstance().unregister(mIdlingResource)
        }
    }


    //
    @Test
    fun test7() {
        val text = "HIII"
        val text2 = "HELLO"
        onView(ViewMatchers.withId(R.id.editTextUserInput))
            .perform(ViewActions.typeText(text), ViewActions.closeSoftKeyboard())
        onView(ViewMatchers.withId(R.id.changeTextBt))
            .perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.textToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText(text)))
        onView(ViewMatchers.withId(R.id.editTextUserInput))
            .perform(ViewActions.typeText(text2), ViewActions.closeSoftKeyboard())
        onView(ViewMatchers.withId(R.id.activityChangeTextBtn))
            .perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.show_text_view))
            .check(ViewAssertions.matches(ViewMatchers.withText(text2)))
        Espresso.pressBack()
        onView(ViewMatchers.withId(R.id.textToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText(text)))


    }







}