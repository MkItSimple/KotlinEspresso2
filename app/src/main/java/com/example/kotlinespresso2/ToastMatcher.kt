package com.example.kotlinespresso2

import android.os.IBinder
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Root
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.view.WindowManager.LayoutParams.TYPE_TOAST
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher


class ToastMatcher : TypeSafeMatcher<Root?>() {
    fun describeTo(description: Description) {
        description.appendText("is toast")
    }

    fun matchesSafely(root: Root): Boolean {
        val type: Int = root.getWindowLayoutParams().get().type
        if (type == TYPE_TOAST) {
            val windowToken: IBinder = root.getDecorView().getWindowToken()
            val appToken: IBinder = root.getDecorView().getApplicationWindowToken()
            if (windowToken === appToken) { //means this window isn't contained by any other windows.
            }
        }
        return false
    }
}
