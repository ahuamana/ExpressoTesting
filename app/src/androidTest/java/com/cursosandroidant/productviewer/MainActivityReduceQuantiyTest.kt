package com.cursosandroidant.productviewer


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityReduceQuantiyTest {

    @Rule
    @JvmField
    val mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityReduceQuantiyTest() {
        val constraintLayout = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(android.R.id.content),
                        childAtPosition(
                            withId(androidx.constraintlayout.widget.R.id.decor_content_parent),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        constraintLayout.perform(click())

        val constraintLayout2 = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(android.R.id.content),
                        childAtPosition(
                            withId(androidx.constraintlayout.widget.R.id.decor_content_parent),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        constraintLayout2.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.tvQuantity), withText("Disponibles: 343"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Disponibles: 343")))

        val textView2 = onView(
            allOf(
                withId(R.id.tvQuantity), withText("Disponibles: 343"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Disponibles: 343")))

        val appCompatImageButton = onView(
            allOf(
                withId(R.id.ibSum),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        val appCompatImageButton2 = onView(
            allOf(
                withId(R.id.ibSum),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        appCompatImageButton2.perform(click())

        val textInputEditText = onView(
            allOf(
                withId(R.id.etNewQuantity), withText("3"), withContentDescription("cantidad"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilNewQuantity),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(click())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.etNewQuantity), withText("3"), withContentDescription("cantidad"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilNewQuantity),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(replaceText("30"))

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.etNewQuantity), withText("30"), withContentDescription("cantidad"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilNewQuantity),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textInputEditText3.perform(closeSoftKeyboard())

        val appCompatImageButton3 = onView(
            allOf(
                withId(R.id.ibSub),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatImageButton3.perform(click())

        val extendedFloatingActionButton = onView(
            allOf(
                withId(R.id.efab), withText("A??adir al carrito"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        extendedFloatingActionButton.perform(click())

        val textView3 = onView(
            allOf(
                withId(R.id.tvQuantity), withText("Disponibles: 314"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("Disponibles: 314")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
