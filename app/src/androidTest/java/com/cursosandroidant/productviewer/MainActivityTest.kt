package com.cursosandroidant.productviewer

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Test 1 - Check if the initial quantity is 1
    @Test
    fun setNewQuantity_sum_increasesTextField() {
        onView(withId(R.id.etNewQuantity))
            .check(matches(withText("1")))

        onView(withId(R.id.ibSum)).perform(click())

        onView(withId(R.id.etNewQuantity))
            .check(matches(withText("2")))
    }

    // Test 2 - Check if the quantity is not increased when it is the same as the sum limit
    @Test
    fun setNewQuantity_sumlimit_noIncreasedTextField(){
        val scenario = activityRule.scenario
        scenario.moveToState(Lifecycle.State.RESUMED) // Move to resumed state when the activity is created and visible
        scenario.onActivity { activity ->
            activity.selectedProduct.quantity = 1 // Set the quantity to 1
        }

        onView(withId(R.id.etNewQuantity))
            .check(matches(withText("1")))

        onView(withId(R.id.ibSum)).perform(click())

        onView(withId(R.id.etNewQuantity))
            .check(matches(withText("1")))
    }

    // Test 3 - Check if the quantity is not decreased when it is the same as the sub limit
    @Test
    fun setNewQuantity_sub_decreasesTextField() {
        onView(withId(R.id.etNewQuantity))
            .check(matches(withText("1")))

        onView(withId(R.id.ibSub)).perform(click())

        onView(withId(R.id.etNewQuantity))
            .check(matches(withText("1")))
    }


    // Test 4 - Replace the text in the text field and check if the quantity is decreased
    @Test
    fun setNewQuantity_sub_increaseTextField() {
        onView(withId(R.id.etNewQuantity))
            .perform(ViewActions.replaceText("11"))

        onView(withId(R.id.ibSub)).perform(click())

        onView(withId(R.id.etNewQuantity))
            .check(matches(withText("10")))
    }

    @Test
    fun checkTestField_startsWith1() {
        onView(allOf(withId(R.id.etNewQuantity), withContentDescription("cantidad")))
            .check(matches( withText("1")))
    }

}