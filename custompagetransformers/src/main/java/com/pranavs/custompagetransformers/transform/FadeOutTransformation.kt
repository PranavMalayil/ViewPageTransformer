package com.pranavs.custompagetransformers.transform

import android.util.Log
import android.view.View

class FadeOutTransformation(page: View,position: Float) {

    init {
        page.translationX = -position * page.width
        page.alpha = (1 - Math.abs(position))
    }
}