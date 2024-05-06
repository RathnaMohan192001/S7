package com.example.s7

import android.os.Handler
import com.example.s7.IdlingResource.SimpleIdlingResource

internal object MessageDelayer {
    private const val DELAY_MILLIS = 3000


    fun processMessage(
        message: String?, callback: MainActivity,
        idlingResource: SimpleIdlingResource?
    ) {
        // The IdlingResource is null in production.
        if (idlingResource != null) {
            idlingResource.setIdleState(false)
        }

        // Delay the execution, return message via callback.
        val handler = Handler()
        handler.postDelayed({
            if (callback != null) {
                callback.onDone(message)
                if (idlingResource != null) {
                    idlingResource.setIdleState(true)
                }
            }
        }, DELAY_MILLIS.toLong())
    }

    internal interface DelayerCallback {
        fun onDone(text: String?)
    }
}
