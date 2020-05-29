package com.example.kotlinespresso2

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test

class MainActivityTest{
    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)

    // is bitmap set to imageview
    @Test
    fun  test_cameraIntent() {

        // GIVEN
        val activityResult = createImageCaptureActivityResultStub()
        val expectedIntent: Matcher<Intent> = hasAction(MediaStore.ACTION_IMAGE_CAPTURE)
        intending(expectedIntent).respondWith(activityResult)

        // Execute and Verify
        onView(withId(R.id.image)).check(matches(not(hasDrawable())))
        onView(withId(R.id.button_launch_camera)).perform(click())
        intended(expectedIntent)
        onView(withId(R.id.image)).check(matches(hasDrawable()))
    }

    private fun createImageCaptureActivityResultStub(): ActivityResult? {
        val bundle = Bundle()
        bundle.putParcelable(
            KEY_IMAGE_DATA, BitmapFactory.decodeResource(
                intentsTestRule.getActivity().getResources(),
                R.drawable.ic_launcher_background
            )
        )
        val resultData = Intent()
        resultData.putExtras(bundle)
        return ActivityResult(Activity.RESULT_OK, resultData)
    }

    fun hasDrawable(): BoundedMatcher<View, ImageView> {
        return object: BoundedMatcher<View, ImageView>(ImageView::class.java){

            override fun matchesSafely(item: ImageView?): Boolean {
                return item?.getDrawable() != null;
            }

            override fun describeTo(description: Description?) {
                description?.appendText("has drawable")
            }

        }
    }

//    fun hasDrawable(@DrawableRes id: Int) = object : TypeSafeMatcher<View>() {
//
//        override fun describeTo(description: Description) {
//            description.appendText("ImageView with drawable same as drawable with id $id")
//        }
//
//        override fun matchesSafely(view: View): Boolean {
//            val context = view.context
//            val expectedBitmap = context.getDrawable(id)!!.toBitmap()
//            return view is ImageView && view.drawable.toBitmap().sameAs(expectedBitmap)
//        }
//    }
}