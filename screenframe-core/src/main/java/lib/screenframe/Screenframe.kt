package lib.screenframe

import android.graphics.Bitmap
import lib.screenframe.core.DeviceFactory
import lib.screenframe.models.Config
import lib.screenframe.models.Orientation
import java.io.File
import java.lang.Exception

object Screenframe {
    private val deviceFactory = DeviceFactory()
    private val device = deviceFactory.getDefaultDevice()

    public fun generate(screenshot: Bitmap, config: Config): File? {

        val orientation = Orientation.calculate(screenshot, device)
                ?: throw Exception("Could not match the orientation of the device")

        return File("")
    }
}
