package lib.screenframe.domain

import lib.screenframe.models.Device
import lib.screenframe.models.Name

interface DeviceFactoryContract {
    fun getDevice(name: Name): Device
    fun getDefaultDevice(): Device
    fun getAllDevices(): List<Device>
    fun createDevices()
}