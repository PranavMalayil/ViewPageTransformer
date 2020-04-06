package com.pranavs.custompagetransformers.transform

import android.util.Log
import android.view.View
import com.pranavs.custompagetransformers.PageTransformStyles

class ZoomOutTransformation(
    page: View, position: Float,
    mCustomStyle: PageTransformStyles = PageTransformStyles.ZOOM_OUT_TRANSFORMATION_FADE_BOTH
) {
    private val MIN_SCALE = 0.65f
    private val MIN_ALPHA = 0.3f

    init {
        if (position < -1) {
            page.alpha = 0f
        } else if (position <= 1) {

            if (mCustomStyle.equals(PageTransformStyles.ZOOM_OUT_RIGHT_TRANSFORMATION_FADE_LEFT)) {
                if (position >= 0) {
                    page.scaleX = Math.max(MIN_SCALE, 1 - Math.abs(position))
                    page.scaleY = Math.max(MIN_SCALE, 1 - Math.abs(position))
                }
                if (position <= 0) {
                    page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
                }
            } else if (mCustomStyle.equals(PageTransformStyles.ZOOM_OUT_LEFT_TRANSFORMATION_FADE_RIGHT)) {
                if (position <= 0) {
                    page.scaleX = Math.max(MIN_SCALE, 1 - Math.abs(position))
                    page.scaleY = Math.max(MIN_SCALE, 1 - Math.abs(position))
                }
                if (position >= 0) {
                    page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
                }
            } else if (mCustomStyle.equals(PageTransformStyles.ZOOM_OUT_LEFT_TRANSFORMATION_FADE_LEFT)) {
                if (position <= 0) {
                    page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
                    page.scaleX = Math.max(MIN_SCALE, 1 - Math.abs(position))
                    page.scaleY = Math.max(MIN_SCALE, 1 - Math.abs(position))
                }
            } else if (mCustomStyle.equals(PageTransformStyles.ZOOM_OUT_RIGHT_TRANSFORMATION_FADE_RIGHT)) {
                if (position >= 0) {
                    page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
                    page.scaleX = Math.max(MIN_SCALE, 1 - Math.abs(position))
                    page.scaleY = Math.max(MIN_SCALE, 1 - Math.abs(position))
                }
            } else if (mCustomStyle.equals(PageTransformStyles.ZOOM_OUT_TRANSFORMATION_FADE_BOTH))
                page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            else if (mCustomStyle.equals(PageTransformStyles.ZOOM_OUT_TRANSFORMATION_FADE_RIGHT)) {
                if (position >= 0)
                    page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            } else if (mCustomStyle.equals(PageTransformStyles.ZOOM_OUT_TRANSFORMATION_FADE_LEFT)) {
                if (position <= 0)
                    page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            } else {
                page.scaleX = Math.max(MIN_SCALE, 1 - Math.abs(position))
                page.scaleY = Math.max(MIN_SCALE, 1 - Math.abs(position))
            }
        }
    }
}