package lib.screenframe.models

import android.graphics.Bitmap

enum class Orientation(id: String) {
    LANDSCAPE("land"), PORTRAIT("port");

    var id: String
        internal set

    init {
        this.id = id
    }

    companion object {

        /**
         * Checks if screenshot matches the aspect ratio of the device.
         */
        fun calculate(screenshot: Bitmap, device: Device): Orientation? {
            val screenshotBounds = Bounds(screenshot.width, screenshot.height)
            return calculate(screenshotBounds, device.portOffset);
        }

        /**
         * Check if the aspect ratio of the given bounds matches the device.
         */
        fun calculate(bounds: Bounds, device: Device): Orientation? {
            return calculate(bounds, device.screenSize)
        }

        /**
         * Check if the aspect ratios of the bounds match.
         *
         * @return [Orientation.PORTRAIT] if matched to portrait,
         * [Orientation.LANDSCAPE] if matched to landscape and null if no match
         */
        private fun calculate(lhs: Bounds, rhs: Bounds): Orientation? {
            val aspect1 = lhs.x.toFloat() / lhs.y.toFloat()
            val aspect2 = rhs.y.toFloat() / rhs.x.toFloat()

            if (aspect1 == aspect2) {
                return Orientation.PORTRAIT
            } else if (aspect1 == 1 / aspect2) {
                return Orientation.LANDSCAPE
            }

            return null
        }
    }
}