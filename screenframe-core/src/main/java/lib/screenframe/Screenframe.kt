package lib.screenframe

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import lib.screenframe.core.DeviceFactory
import lib.screenframe.models.Bounds
import lib.screenframe.models.Config
import lib.screenframe.models.Orientation
import lib.screenframe.utils.Util
import android.R.attr.orientation
import android.R.attr.y
import android.R.attr.x

object Screenframe {
    private val deviceFactory = DeviceFactory()
    private val device = deviceFactory.getDefaultDevice()

    fun generate(screenshot: Bitmap, config: Config, activity: Activity): Bitmap {
        val resizedScreenshot: Bitmap
        val offset: Bounds

        config.name?.let {
            deviceFactory.getDevice(config.name)
        }

        when (Orientation.calculate(screenshot, device)
                ?: throw Exception("Could not match the orientation of the device")) {
            Orientation.PORTRAIT -> {
                resizedScreenshot = Bitmap.createScaledBitmap(screenshot, device.screenSize.x, device.screenSize.y, false)
                offset = device.portOffset
            }

            Orientation.LANDSCAPE -> {
                resizedScreenshot = Bitmap.createScaledBitmap(screenshot, device.screenSize.y, device.screenSize.x, false)
                offset = device.landOffset
            }
        }

        return resizedScreenshot
    }


}
