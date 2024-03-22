package com.example.lab_1;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import com.example.lab_1.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        appCompatEditText.perform(replaceText("12345"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));
        textView.check(matches(withText("You shall not pass!")));
    }

    /**
     * Tests that password is missing uppercase characters.
     * This method performs the following steps:
     * 1. Finds the view associated with the EditText (R.id.editText).
     * 2. Types the text "password123#$*" into the EditText.
     * 3. Finds the button associated with R.id.button.
     * 4. Clicks the button.
     * 5. Finds the text view associated with R.id.textView.
     * 6. Verifies that the displayed text is "You shall not pass!".
     */
    @Test
    public void testFindMissingUppercase(){
        // find the view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        // type in password123#$*
        appCompatEditText.perform(replaceText("password123#$*"));

        // find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click the button
        materialButton.perform(click());

        // find the text view
        ViewInteraction textView = onView(withId(R.id.textView));
        // check the text
        textView.check(matches(withText("You shall not pass!")));
    }

    /**
     * Tests that password is missing lowercase characters.
     * This method performs the following steps:
     * 1. Finds the view associated with the EditText (R.id.editText).
     * 2. Types the text "KOMAL123#$*" into the EditText.
     * 3. Finds the button associated with R.id.button.
     * 4. Clicks the button.
     * 5. Finds the text view associated with R.id.textView.
     * 6. Verifies that the displayed text is "You shall not pass!".
     */
    @Test
    public void testFindMissingLowercase(){
        // find the view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        // type in password123#$*
        appCompatEditText.perform(replaceText("KOMAL123#$*"));

        // find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click the button
        materialButton.perform(click());

        // find the text view
        ViewInteraction textView = onView(withId(R.id.textView));
        // check the text
        textView.check(matches(withText("You shall not pass!")));
    }

    /**
     * Tests that password is missing numbers.
     * This method performs the following steps:
     * 1. Finds the view associated with the EditText (R.id.editText).
     * 2. Types the text "Komal$$" into the EditText.
     * 3. Finds the button associated with R.id.button.
     * 4. Clicks the button.
     * 5. Finds the text view associated with R.id.textView.
     * 6. Verifies that the displayed text is "You shall not pass!".
     */
    @Test
    public void testFindMissingDigit(){
        // find the view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        // type in password123#$*
        appCompatEditText.perform(replaceText("Komal$$"));

        // find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click the button
        materialButton.perform(click());

        // find the text view
        ViewInteraction textView = onView(withId(R.id.textView));
        // check the text
        textView.check(matches(withText("You shall not pass!")));
    }

    /**
     * Tests that password is missing special characters.
     * This method performs the following steps:
     * 1. Finds the view associated with the EditText (R.id.editText).
     * 2. Types the text "Komal0029" into the EditText.
     * 3. Finds the button associated with R.id.button.
     * 4. Clicks the button.
     * 5. Finds the text view associated with R.id.textView.
     * 6. Verifies that the displayed text is "You shall not pass!".
     */
    @Test
    public void testFindMissingSpecial(){
        // find the view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        // type in password123#$*
        appCompatEditText.perform(replaceText("Komal0029"));

        // find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click the button
        materialButton.perform(click());

        // find the text view
        ViewInteraction textView = onView(withId(R.id.textView));
        // check the text
        textView.check(matches(withText("You shall not pass!")));
    }

    /**
     * Tests that password is meeting all requirements.
     * This method performs the following steps:
     * 1. Finds the view associated with the EditText (R.id.editText).
     * 2. Types the text "Komal0029$$" into the EditText.
     * 3. Finds the button associated with R.id.button.
     * 4. Clicks the button.
     * 5. Finds the text view associated with R.id.textView.
     * 6. Verifies that the displayed text is "You shall not pass!".
     */
    @Test
    public void testFindMeetingAllRequirements(){
        // find the view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        // type in password123#$*
        appCompatEditText.perform(replaceText("Komal0029$$"));

        // find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click the button
        materialButton.perform(click());

        // find the text view
        ViewInteraction textView = onView(withId(R.id.textView));
        // check the text
        textView.check(matches(withText("Your password meets the requirements")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
