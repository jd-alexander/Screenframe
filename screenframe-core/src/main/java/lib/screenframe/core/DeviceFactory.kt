package lib.screenframe.core

import lib.screenframe.domain.DeviceFactoryContract
import lib.screenframe.models.Bounds
import lib.screenframe.models.Device
import lib.screenframe.models.Name
import lib.screenframe.models.Name.*

class DeviceFactory : DeviceFactoryContract {
    private val devices = mutableListOf<Device>()

    init {
        createDevices()
    }

    override fun createDevices() {
        val nexus5 = Device(name = Nexus5,
                landOffset = Bounds(436, 306),
                portOffset = Bounds(306, 436),
                screenSize = Bounds(1080, 1920),
                physicalSize = 5.34f,
                id = "nexus_5")

        devices.add(nexus5)
    }

    override fun getDevice(name: Name): Device {
        return devices.first { device -> device.name == name }
    }

    override fun getDefaultDevice(): Device {
        return getDevice(Name.Nexus5)
    }

    override fun getAllDevices(): List<Device> = devices
}