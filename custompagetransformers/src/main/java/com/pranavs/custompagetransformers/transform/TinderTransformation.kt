package com.pranavs.custompagetransformers.transform

import android.util.Log
import android.view.View
import com.pranavs.custompagetransformers.PageTransformStyles
import kotlin.math.abs
import kotlin.math.max

class TinderTransformation(
    page: View, position: Float,
    mCustomStyle: PageTransformStyles = PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION
) {

    private val MIN_ALPHA = 0.3f

    init {
        page.translationX = -position * page.getWidth()

        if (abs(position) < .9) page.visibility = View.VISIBLE
        else page.visibility = View.GONE

        //For top left
        when {
            (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION)
                    or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_FADE_BOTH)
                    or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_FADE_START)
                    or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_FADE_END)
                    or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_START)
                    or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_END)
                    or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH)
                    or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                    or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_END)
                    or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH) -> {
                page.pivotX = 0f
                page.pivotY = 0f


            }
            (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_FADE_BOTH)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_FADE_START)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_FADE_END)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_START)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_END)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_END)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH) -> {

                page.pivotX = 0f
                page.pivotY = page.height.toFloat()
            }
            (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_FADE_BOTH)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_FADE_START)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_FADE_END)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_START)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_END)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_END)
                    or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH) -> {

                page.pivotX = page.width.toFloat()
                page.pivotY = page.height.toFloat()
            }
            else -> {
                page.pivotX = page.width.toFloat()
                page.pivotY = 0f
            }
        }




        if (position < -1) page.alpha = 0f
        if (position <= 0) {
            if ((mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)

                //Bottom left
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)

                //Top right
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)


                //Bottom Right
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)

            ) {
                page.alpha = max(MIN_ALPHA, 1 - abs(position))
            } else page.alpha = 1f


            //Page rotaion goes here

            //Page transformation when top left is assigned
            if ((mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)
            ) {
                page.rotation = 90 * Math.abs(position)
            } else if ((mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)
            ) {
                page.rotation = -90 * Math.abs(position)
            } else if ((mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)
            ) {
                page.rotation = -90 * Math.abs(position)
            } else {
                page.rotation = 90 * Math.abs(position)
            }


            if ((mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)


                //Top right
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)


                //Bottom right
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)

                //Bottom left
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)


            ) {
                page.scaleY = (1 - Math.abs(position))
                page.scaleX = (1 - Math.abs(position))
            }

        } else if (position <= 1) {
            if ((mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)

                //Top right
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)


                //Bottom left
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)


                //Bottom rigth
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)

            ) {
                page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            } else page.alpha = 1f


            page.rotation = 0f

            if ((mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)

                //Top right
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)


                //Bottom LEFT
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)


                //Bottom right
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_START)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_END)
                or (mCustomStyle == PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH)

            ) {
                page.scaleY = (1 - Math.abs(position))
                page.scaleX = (1 - Math.abs(position))
            }
        }
    }
}