package com.pranavs.custompagetransformers.transform

import android.view.View
import com.pranavs.custompagetransformers.PageTransformStyles

class VerticalFlipTransformation(
    page: View, position: Float,
    mCustomStyle: PageTransformStyles = PageTransformStyles.VERTICAL_FLIP_TRANSFORMATION
) {

    private val MIN_ALPHA = 0.3f
    val MAX_SCALE = 0.9

    init {
        page.translationX = -position * page.width
        val mPageWidth = page.width
        page.setCameraDistance(20000f);

        if (position < 0.5 && position > -0.5)
            page.visibility = (View.VISIBLE)
        else
            page.visibility = (View.INVISIBLE)


        if (position < -1) page.alpha = 0f
        else if (position <= 0) {
            page.translationX = (-mPageWidth * MAX_SCALE * position).toFloat()
            if (mCustomStyle.equals(PageTransformStyles.VERTICAL_FLIP_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle.equals(PageTransformStyles.VERTICAL_FLIP_TRANSFORMATION_FADE_START))
            ) {
                page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            } else page.alpha = 1f
            page.rotationY = 180 * (1 - Math.abs(position) + 1)
            page.scaleY = 1 - Math.abs(position)/2
            page.scaleX = 1 - Math.abs(position)/2
        } else if (position <= 1) {
            page.translationX = (mPageWidth * MAX_SCALE * -position).toFloat()
            if (mCustomStyle.equals(PageTransformStyles.VERTICAL_FLIP_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle.equals(PageTransformStyles.VERTICAL_FLIP_TRANSFORMATION_FADE_END))
            ) {
                page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            } else page.alpha = 1f
            page.rotationY = -180 * (1 - Math.abs(position) + 1)
            page.scaleY = 1 - Math.abs(position)/2
            page.scaleX = 1 - Math.abs(position)/2
        } else page.alpha = 0f

    }
}