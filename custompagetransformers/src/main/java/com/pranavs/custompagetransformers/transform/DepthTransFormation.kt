package com.pranavs.custompagetransformers.transform

import android.view.View
import com.pranavs.custompagetransformers.PageTransformStyles
import kotlin.math.abs

class DepthTransFormation(
    page: View, position: Float,
    mCustomStyle: PageTransformStyles = PageTransformStyles.DEPTH_TRANSFORMATION
) {


    init {
        if (position < -1) {
            // This page is way off-screen to the left.
            page.alpha = 0f

        } else if (position <= 0) {
            if ((mCustomStyle == PageTransformStyles.DEPTH_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.DEPTH_TRANSFORMATION_FADE_START)
                or (mCustomStyle == PageTransformStyles.DEPTH_TRANSFORMATION_SCALE_BOTH_FADE_START)
            ) {
                page.alpha = 1 - abs(position)
            } else
                page.alpha = 1f

            page.translationX = 0f
            if ((mCustomStyle == PageTransformStyles.DEPTH_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.DEPTH_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle == PageTransformStyles.DEPTH_TRANSFORMATION_SCALE_BOTH_FADE_END)
            ) {

                page.scaleX = (1 - abs(position))
                page.scaleY = (1 - abs(position))
            } else {
                page.scaleX = 1f
                page.scaleY = 1f
            }

        } else if (position <= 1) {
            page.translationX = -position * page.width
            if ((mCustomStyle == PageTransformStyles.DEPTH_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.DEPTH_TRANSFORMATION_FADE_END)
                or (mCustomStyle == PageTransformStyles.DEPTH_TRANSFORMATION_SCALE_BOTH_FADE_END)
            ) {
                page.alpha = 1 - abs(position)
            } else page.alpha = 1f


            page.scaleX = 1 - abs(position)
            page.scaleY = 1 - abs(position)


        } else {
            // This page is way off-screen to the right.
            page.alpha = 0f

        }

    }
}