package com.pranavs.custompagetransformers.transform

import android.util.Log
import android.view.View
import com.pranavs.custompagetransformers.PageTransformStyles

class CubeOutTransformation(
    page: View, position: Float,
    mCustomStyle: PageTransformStyles = PageTransformStyles.CUBE_OUT_TRANSFORMATION
) {

    private val MIN_ALPHA = 0.3f

    init {

        if (position < -1) page.alpha = 0f
        else if (position <= 0) {
            if (mCustomStyle.equals(PageTransformStyles.CUBE_OUT_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle.equals(PageTransformStyles.CUBE_OUT_TRANSFORMATION_FADE_START))
                or (mCustomStyle.equals(PageTransformStyles.CUBE_OUT_TRANSFORMATION_SCALE_BOTH_FADE_START))
            ) {
                page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            } else page.alpha = 1f
            page.pivotX = page.width.toFloat()
            page.pivotY = page.height * .5.toFloat()
            page.rotationY = -90 * Math.abs(position)


            if (mCustomStyle.equals(PageTransformStyles.CUBE_OUT_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle.equals(PageTransformStyles.CUBE_OUT_TRANSFORMATION_SCALE_START))
                or (mCustomStyle.equals(PageTransformStyles.CUBE_OUT_TRANSFORMATION_SCALE_BOTH_FADE_START))
                or (mCustomStyle.equals(PageTransformStyles.CUBE_OUT_TRANSFORMATION_SCALE_BOTH_FADE_END))
            ) {
                page.scaleY = (1 - Math.abs(position))
                page.scaleX = (1 - Math.abs(position))
            }


        } else if (position >= 0) {
            if (mCustomStyle.equals(PageTransformStyles.CUBE_OUT_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle.equals(PageTransformStyles.CUBE_OUT_TRANSFORMATION_FADE_END))
                or (mCustomStyle.equals(PageTransformStyles.CUBE_OUT_TRANSFORMATION_SCALE_BOTH_FADE_END))
            ) {
                page.alpha =Math.max(MIN_ALPHA, 1 - Math.abs(position))
            } else page.alpha = 1f

            page.pivotY = page.height * .5.toFloat()
            page.pivotX = 0f
            page.rotationY = 90 * Math.abs(position)

            if (mCustomStyle.equals(PageTransformStyles.CUBE_OUT_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle.equals(PageTransformStyles.CUBE_OUT_TRANSFORMATION_SCALE_END))
                or (mCustomStyle.equals(PageTransformStyles.CUBE_OUT_TRANSFORMATION_SCALE_BOTH_FADE_START))
                or (mCustomStyle.equals(PageTransformStyles.CUBE_OUT_TRANSFORMATION_SCALE_BOTH_FADE_END))
            ) {
                page.scaleY = (1 - Math.abs(position))
                page.scaleX = (1 - Math.abs(position))
            }

        }
    }
}