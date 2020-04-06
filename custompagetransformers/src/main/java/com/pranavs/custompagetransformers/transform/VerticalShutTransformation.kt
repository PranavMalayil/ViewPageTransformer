package com.pranavs.custompagetransformers.transform

import android.util.Log
import android.view.View
import com.pranavs.custompagetransformers.PageTransformStyles

class VerticalShutTransformation(
    page: View, position: Float,
    mCustomStyle: PageTransformStyles = PageTransformStyles.CUBE_OUT_TRANSFORMATION
) {
    private val MIN_ALPHA = 0.3f

    init {


        page.translationX = -position * page.getWidth()
        page.cameraDistance = 999999999f
        if (position < 0.5 && position > -0.5) {
            page.visibility = View.VISIBLE;
        } else {
            page.visibility = View.INVISIBLE;
        }

        if (position < -1) page.alpha = 0f
        if (position <= 0) {
            if (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_FADE_START))
                or (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_BOTH_FADE_START))
                or (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH))
            ) {
                page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            } else page.alpha = 1f
            page.rotationX = 180 * (1 - Math.abs(position) + 1)

            if (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_START))
                or (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_BOTH_FADE_START))
                or (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH))
            ) {
                page.scaleY = (1 - Math.abs(position))
                page.scaleX = (1 - Math.abs(position))
            }

        } else if (position > 0) {
            if (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_FADE_END))
                or (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_BOTH_FADE_END))
                or (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH))
            ) {
                page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            } else page.alpha = 1f
            page.rotationX = -180 * (1 - Math.abs(position) + 1)

            if (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_END))
                or (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_BOTH_FADE_START))
                or (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_BOTH_FADE_END))
                or (mCustomStyle.equals(PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH))
            ) {
                page.scaleY = (1 - Math.abs(position))
                page.scaleX = (1 - Math.abs(position))
            }
        }
    }

}