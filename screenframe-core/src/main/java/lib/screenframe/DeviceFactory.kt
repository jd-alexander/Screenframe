package lib.screenframe

import lib.screenframe.models.Bounds
import lib.screenframe.models.Device
import lib.screenframe.models.Name.*

object DeviceFactory {

    private val devices = mutableListOf<Device>()

    init {
        setupDevices()
    }

    private fun setupDevices() {

        val nexus5 = Device(name = Nexus5,
                landOffset = Bounds(436, 306),
                portOffset = Bounds(306, 436),
                screenSize = Bounds(1080, 1920),
                physicalSize = 5.34f,
                id = "nexus_5"
                )
        devices.add(nexus5)
    }

    fun defaultDevice():Device{
        return devices.first { device -> device.name == Nexus5 }
    }
}