package com.naveed.practice_arch.utils

/**
 * Wraps the event to handle the single use case
 */
open class Event<out T>(
    private val content: T
) {
    var hasBeenHandled = false
        private set //Allow read but not write

    /**
     * Return the content and prevent it's use again
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}