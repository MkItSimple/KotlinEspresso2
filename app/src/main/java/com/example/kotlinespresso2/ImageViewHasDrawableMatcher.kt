package com.example.kotlinespresso2

object ImageViewHasDrawableMatcher {

    // Continue #9 14:40

    fun hasDrawable(): BoundedMatcher<View, ImageView>{
        return object: BoundedMatcher<View, ImageView>(ImageView::class.java){

            override fun describeTo(description: EventLogTags.Description?) {
                description?.appendText("has drawable")
            }

            override fun matchesSafely(item: ImageView?): Boolean {
                return item?.getDrawable() != null;
            }

        }
    }
}