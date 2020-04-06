package com.pranavs.custompagetransformers.transform

import android.view.View
import kotlin.math.abs

class GateOpenTransformation(page: View, position: Float) {

    init {
        page.translationX = -position * page.width
        if (position <= -1) {
            page.alpha = 0f
        }
        when {
            position <= 0 -> {
                page.alpha = 1f
                page.pivotX = 0f
                page.pivotY = page.height / 2f
                page.rotationY = (90 * abs(position))
            }
            position <= 1 -> {
                page.alpha = 1f
                page.pivotX = page.width.toFloat()
                page.pivotY = page.height / 2f
                page.rotationY = (-90 * abs(position))
            }
            else -> page.alpha = 0f
        }

    }
}