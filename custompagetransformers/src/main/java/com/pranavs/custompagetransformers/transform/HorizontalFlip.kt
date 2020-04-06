package com.pranavs.custompagetransformers.transform

import android.view.View
import com.pranavs.custompagetransformers.PageTransformStyles
import kotlin.math.abs

class HorizontalFlip(
    page: View, position: Float,
    mCustomStyle: PageTransformStyles = PageTransformStyles.HORIZONTAL_FLIP_TRANSFORMATION
) {

    private val MIN_ALPHA = 0.3f

    init {
        page.translationX = -position * page.getWidth()
        page.setCameraDistance(30000f)
        page.pivotX = page.width / 2.toFloat()
        page.pivotY = page.height / 2.toFloat()

        if (position < 0.5 && position > -0.5)
            page.visibility = (View.VISIBLE)
        else
            page.visibility = (View.INVISIBLE)


        if (position < -1) page.alpha = 0f
        else if (position <= 0) {
            if (mCustomStyle.equals(PageTransformStyles.HORIZONTAL_FLIP_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle.equals(PageTransformStyles.HORIZONTAL_FLIP_TRANSFORMATION_FADE_START))
            ) {
                page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            } else page.alpha = 1f

            page.rotationX = 180 * (1 - Math.abs(position) + 1)
            page.scaleX = (1 - (abs(position)))
        } else if (position <= 1) {
            if (mCustomStyle.equals(PageTransformStyles.HORIZONTAL_FLIP_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle.equals(PageTransformStyles.HORIZONTAL_FLIP_TRANSFORMATION_FADE_END))
            ) {
                page.alpha = Math.max(MIN_ALPHA, 1 - abs(position))
            } else page.alpha = 1f
            page.rotationX = -180 * (1 - Math.abs(position) + 1)
            page.scaleX = (1 - (Math.abs(position)))
        } else page.alpha = 0f

    }
}