package com.pranavs.custompagetransformers.transform

import android.util.Log
import android.view.View
import com.pranavs.custompagetransformers.PageTransformStyles

class PopTransformation(
    page: View, position: Float,
    mCustomStyle: PageTransformStyles = PageTransformStyles.POP_TRANSFORMATION
) {

    init {
        page.translationX = -position * page.width



        if (Math.abs(position) > 0.5) {
            page.visibility = View.GONE
        } else if (Math.abs(position) < 0.5) {
            page.visibility = View.VISIBLE
            if (mCustomStyle.equals(PageTransformStyles.POP_TRANSFORMATION_FADE_BOTH)
            ) {
                page.alpha = 1 - Math.abs(position)
            } else if (mCustomStyle.equals(PageTransformStyles.POP_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle.equals(PageTransformStyles.POP_TRANSFORMATION_FADE_START))
            ) {
                if (position <= 0)
                    page.alpha = 1 - Math.abs(position)

            } else if (mCustomStyle.equals(PageTransformStyles.POP_TRANSFORMATION_FADE_END)
                or (mCustomStyle.equals(PageTransformStyles.POP_TRANSFORMATION_SCALE_BOTH_FADE_END))
            ) {
                if (position >= 0)
                    page.alpha = 1 - Math.abs(position)
            } else
                page.alpha = 1f

            if (mCustomStyle.equals(PageTransformStyles.POP_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle.equals(PageTransformStyles.POP_TRANSFORMATION_SCALE_BOTH))
                or (mCustomStyle.equals(PageTransformStyles.POP_TRANSFORMATION_SCALE_BOTH_FADE_END))
            ) {
                page.scaleY = (1 - Math.abs(position))
                page.scaleX = (1 - Math.abs(position))
            } else if (mCustomStyle.equals(PageTransformStyles.POP_TRANSFORMATION_SCALE_END)) {
                if (position >= 0) {
                    page.scaleY = (1 - Math.abs(position))
                    page.scaleX = (1 - Math.abs(position))
                }
            } else if (mCustomStyle.equals(PageTransformStyles.POP_TRANSFORMATION_SCALE_START)) {
                if (position <= 0) {
                    page.scaleY = (1 - Math.abs(position))
                    page.scaleX = (1 - Math.abs(position))
                }
            } else {
                page.scaleX = 1f
                page.scaleY = 1f

            }
        }

    }
}