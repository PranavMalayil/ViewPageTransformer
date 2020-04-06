package com.pranavs.custompagetransformers.transform

import android.view.View
import com.pranavs.custompagetransformers.PageTransformStyles

class ClockSpinSingleTransformation(
    page: View, position: Float,
    mCustomStyle: PageTransformStyles = PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FLY
) {
    private val MIN_ALPHA = 0.3f

    init {

        if (mCustomStyle == PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FLY ||
            mCustomStyle.equals(PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY)
        )
        //do nothing
        else page.translationX = -position * page.width

        if (Math.abs(position) <= 0.5) {
            page.visibility = View.VISIBLE
            page.scaleX = 1 - Math.abs(position)
            page.scaleY = 1 - Math.abs(position)
        } else if (Math.abs(position) > 0.5) {
            page.visibility = View.GONE
        }

        if (position < -1) {
            if (mCustomStyle == PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FADE_BOTH
                || mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FADE_BOTH
                || mCustomStyle == PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FLY_FADE_BOTH
            )
                page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            else
                page.alpha = 0f
        } else if (position <= 0) {
            if (mCustomStyle == PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FADE_BOTH
                || (mCustomStyle == PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FLY_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.CLOCK_SPIN_TRANSFORMATION__FADE_START)
                or (mCustomStyle == PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FLY_FADE_START)

                //Anti clock wise fly spin
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY_FADE_START)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY_FADE_BOTH)

                //Anti clock wise fly spin
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FADE_START)

            )
                page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            else
                page.alpha = 1f
            if ((mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FADE_START)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FADE_END)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY_FADE_START)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY_FADE_END)
            )
                page.rotation = -360 * Math.abs(position)
            else page.rotation = 360 * Math.abs(position)

        } else if (position <= 1) {
            if ((mCustomStyle == PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FADE_BOTH)
                or ((mCustomStyle == PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FADE_END)
                        //Clock spin fly
                        or (mCustomStyle == PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FLY_FADE_BOTH)
                        or (mCustomStyle == PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FLY_FADE_END)


                        //Anti clock wise fly spin
                        or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FADE_END)
                        or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FADE_BOTH)

                        //Anti clock wise fly spin
                        or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY_FADE_BOTH)
                        or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY_FADE_END)

                        )
            )
                page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            else
                page.alpha = 1f
            if ((mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FADE_START)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FADE_END)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY_FADE_BOTH)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY_FADE_START)
                or (mCustomStyle == PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY_FADE_END)
            )
                page.rotation = 360 * Math.abs(position)
            else page.rotation = -360 * Math.abs(position)
        } else page.alpha = 0f
    }
}