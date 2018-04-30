package lib.scoop

import lib.scoop.models.Device
import lib.scoop.models.Orientation
import lib.scoop.utils.Util.getBitmap
import java.io.File

class FrameGenerator {
    private val device: Device

    constructor(device: Device) {
        this.device = device
    }

    public fun generateFrame(screenshot: File): File? {

        val image = getBitmap(screenshot)

        val orientation = Orientation.calculate(image,device)

        return File("")
    }
}

