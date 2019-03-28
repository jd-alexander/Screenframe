package lib.screenframe

import lib.screenframe.models.Device
import lib.screenframe.models.Orientation
import lib.screenframe.utils.Util.getBitmap
import java.io.File

object Screenframe {
    private val device = DeviceFactory.defaultDevice()

    public fun generateFrame(screenshot: File): File? {

        val image = getBitmap(screenshot)

        val orientation = Orientation.calculate(image,device)

        return File("")
    }
}



