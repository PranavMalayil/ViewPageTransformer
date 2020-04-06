package com.pranavs.custompagetransformers

import android.view.View
import androidx.viewpager.widget.ViewPager
import com.pranavs.custompagetransformers.transform.*

class PrsPageTransformer(
    private var mCustomStyle: PageTransformStyles =
        PageTransformStyles.SIMPLE_TRANSFORMATION
) : ViewPager.PageTransformer {


    override fun transformPage(page: View, position: Float) {
        when (mCustomStyle) {
            PageTransformStyles.SIMPLE_TRANSFORMATION ->
                SimpleTransformation(page, position)
            PageTransformStyles.GATE_TRANSFORMATION ->
                GateOpenTransformation(page, position)
            PageTransformStyles.FADE_OUT_TRANSFORMATION ->
                FadeOutTransformation(page, position)
            PageTransformStyles.ZOOM_OUT_TRANSFORMATION_FADE_BOTH,
            PageTransformStyles.ZOOM_OUT_TRANSFORMATION_FADE_LEFT,
            PageTransformStyles.ZOOM_OUT_TRANSFORMATION_FADE_RIGHT,
            PageTransformStyles.ZOOM_OUT_RIGHT_TRANSFORMATION_FADE_RIGHT,
            PageTransformStyles.ZOOM_OUT_LEFT_TRANSFORMATION_FADE_LEFT,
            PageTransformStyles.ZOOM_OUT_RIGHT_TRANSFORMATION_FADE_LEFT,
            PageTransformStyles.ZOOM_OUT_LEFT_TRANSFORMATION_FADE_RIGHT ->
                ZoomOutTransformation(page, position, mCustomStyle)

            /**
             * Clock spin transformations
             */
            //Clock spin
            PageTransformStyles.CLOCK_SPIN_TRANSFORMATION,
            PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FADE_BOTH,
            PageTransformStyles.CLOCK_SPIN_TRANSFORMATION__FADE_START,
            PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FADE_END,
                //Clock spin fly
            PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FLY,
            PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FLY_FADE_START,
            PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FLY_FADE_END,
            PageTransformStyles.CLOCK_SPIN_TRANSFORMATION_FLY_FADE_BOTH,
                //Anti clock spin transformations
            PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION,
            PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FADE_BOTH,
            PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FADE_START,
            PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FADE_END,

                //Fly anit clock spin
            PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY,
            PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY_FADE_BOTH,
            PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY_FADE_START,
            PageTransformStyles.ANTI_CLOCK_SPIN_TRANSFORMATION_FLY_FADE_END ->
                ClockSpinSingleTransformation(
                    page,
                    position,
                    mCustomStyle
                )


            /**
             * Horizontal transformations cases
             */
            PageTransformStyles.HORIZONTAL_FLIP_TRANSFORMATION,
            PageTransformStyles.HORIZONTAL_FLIP_TRANSFORMATION_FADE_BOTH,
            PageTransformStyles.HORIZONTAL_FLIP_TRANSFORMATION_FADE_START,
            PageTransformStyles.HORIZONTAL_FLIP_TRANSFORMATION_FADE_END -> HorizontalFlip(
                page,
                position,
                mCustomStyle
            )


            /**
             * Vertical flip cases
             */
            PageTransformStyles.VERTICAL_FLIP_TRANSFORMATION,
            PageTransformStyles.VERTICAL_FLIP_TRANSFORMATION_FADE_BOTH,
            PageTransformStyles.VERTICAL_FLIP_TRANSFORMATION_FADE_START,
            PageTransformStyles.VERTICAL_FLIP_TRANSFORMATION_FADE_END -> VerticalFlipTransformation(
                page,
                position,
                mCustomStyle
            )

            /**
             * Depth transformations
             */
            PageTransformStyles.DEPTH_TRANSFORMATION,
            PageTransformStyles.DEPTH_TRANSFORMATION_FADE_BOTH,
            PageTransformStyles.DEPTH_TRANSFORMATION_FADE_START,
            PageTransformStyles.DEPTH_TRANSFORMATION_FADE_END,
            PageTransformStyles.DEPTH_TRANSFORMATION_SCALE_BOTH,
            PageTransformStyles.DEPTH_TRANSFORMATION_SCALE_BOTH_FADE_START,
            PageTransformStyles.DEPTH_TRANSFORMATION_SCALE_BOTH_FADE_END,
            PageTransformStyles.DEPTH_TRANSFORMATION_SCALE_END -> DepthTransFormation(
                page, position, mCustomStyle
            )


            /**
             * Pop transformations
             */
            PageTransformStyles.POP_TRANSFORMATION,
            PageTransformStyles.POP_TRANSFORMATION_FADE_BOTH,
            PageTransformStyles.POP_TRANSFORMATION_FADE_START,
            PageTransformStyles.POP_TRANSFORMATION_FADE_END,
            PageTransformStyles.POP_TRANSFORMATION_SCALE_BOTH,
            PageTransformStyles.POP_TRANSFORMATION_SCALE_BOTH_FADE_START,
            PageTransformStyles.POP_TRANSFORMATION_SCALE_BOTH_FADE_END,
            PageTransformStyles.POP_TRANSFORMATION_SCALE_START,
            PageTransformStyles.POP_TRANSFORMATION_SCALE_END -> PopTransformation(
                page, position, mCustomStyle
            )


            /**
             * Cube transformations
             */
            PageTransformStyles.CUBE_OUT_TRANSFORMATION,
            PageTransformStyles.CUBE_OUT_TRANSFORMATION_FADE_BOTH,
            PageTransformStyles.CUBE_OUT_TRANSFORMATION_FADE_START,
            PageTransformStyles.CUBE_OUT_TRANSFORMATION_FADE_END,
            PageTransformStyles.CUBE_OUT_TRANSFORMATION_SCALE_BOTH,
            PageTransformStyles.CUBE_OUT_TRANSFORMATION_SCALE_BOTH_FADE_START,
            PageTransformStyles.CUBE_OUT_TRANSFORMATION_SCALE_BOTH_FADE_END,
            PageTransformStyles.CUBE_OUT_TRANSFORMATION_SCALE_START,
            PageTransformStyles.CUBE_OUT_TRANSFORMATION_SCALE_END -> CubeOutTransformation(
                page, position, mCustomStyle
            )


            /**
             * Vertical shut transformations
             */
            PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION,
            PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_FADE_BOTH,
            PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_FADE_START,
            PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_FADE_END,
            PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_BOTH,
            PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_BOTH_FADE_START,
            PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_BOTH_FADE_END,
            PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_START,
            PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_END,
            PageTransformStyles.VERTICAL_SHUT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH -> VerticalShutTransformation(
                page, position, mCustomStyle
            )


            /**
             * Horizontal shut transformations
             */
            PageTransformStyles.HORIZONTAL_SHUT_TRANSFORMATION,
            PageTransformStyles.HORIZONTAL_SHUT_TRANSFORMATION_FADE_BOTH,
            PageTransformStyles.HORIZONTAL_SHUT_TRANSFORMATION_FADE_START,
            PageTransformStyles.HORIZONTAL_SHUT_TRANSFORMATION_FADE_END,
            PageTransformStyles.HORIZONTAL_SHUT_TRANSFORMATION_SCALE_BOTH,
            PageTransformStyles.HORIZONTAL_SHUT_TRANSFORMATION_SCALE_BOTH_FADE_START,
            PageTransformStyles.HORIZONTAL_SHUT_TRANSFORMATION_SCALE_BOTH_FADE_END,
            PageTransformStyles.HORIZONTAL_SHUT_TRANSFORMATION_SCALE_START,
            PageTransformStyles.HORIZONTAL_SHUT_TRANSFORMATION_SCALE_END,
            PageTransformStyles.HORIZONTAL_SHUT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH -> HorizontalShutTransformation(
                page, position, mCustomStyle
            )


            /**
             * Tinder transformations
             */
            PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION,
            PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_FADE_BOTH,
            PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_FADE_START,
            PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_FADE_END,
            PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH,
            PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_START,
            PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_END,
            PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_START,
            PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_END,
            PageTransformStyles.TINDER_TOP_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH,

                //Top right
            PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION,
            PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_FADE_BOTH,
            PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_FADE_START,
            PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_FADE_END,
            PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_BOTH,
            PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_START,
            PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_END,
            PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_START,
            PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_END,
            PageTransformStyles.TINDER_TOP_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH,
                //Bottom left
            PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION,
            PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_FADE_BOTH,
            PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_FADE_START,
            PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_FADE_END,
            PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH,
            PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_START,
            PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_END,
            PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_START,
            PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_END,
            PageTransformStyles.TINDER_BOTTOM_LEFT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH,
                //Bottom right
            PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION,
            PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_FADE_BOTH,
            PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_FADE_START,
            PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_FADE_END,
            PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH,
            PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_START,
            PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_END,
            PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_START,
            PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_END,
            PageTransformStyles.TINDER_BOTTOM_RIGHT_TRANSFORMATION_SCALE_BOTH_FADE_BOTH
            -> TinderTransformation(
                page, position, mCustomStyle
            )


            else -> SimpleTransformation(page, position)

        }
    }


}