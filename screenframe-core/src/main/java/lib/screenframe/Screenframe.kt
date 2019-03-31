package lib.screenframe

import android.graphics.Bitmap
import lib.screenframe.core.DeviceFactory
import lib.screenframe.models.Bounds
import lib.screenframe.models.Config
import lib.screenframe.models.Orientation
import java.io.File
import java.lang.Exception

object Screenframe {
    private val deviceFactory = DeviceFactory()
    private val device = deviceFactory.getDefaultDevice()

    fun generate(screenshot: Bitmap, config: Config): File? {
        val resizedScreenshot: Bitmap
        var offset: Bounds

        config.name?.let {
            deviceFactory.getDevice(config.name)
        }

        val orientation = Orientation.calculate(screenshot, device)
                ?: throw Exception("Could not match the orientation of the device")

        when (orientation) {
            Orientation.PORTRAIT -> {
                resizedScreenshot = Bitmap.createScaledBitmap(screenshot, device.screenSize.x, device.screenSize.y, false)
                offset = device.portOffset
            }

            Orientation.LANDSCAPE -> {
                resizedScreenshot = Bitmap.createScaledBitmap(screenshot, device.screenSize.y, device.screenSize.x, false)
                offset = device.landOffset
            }
        }

        return File("")
    }
}
