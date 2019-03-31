package lib.screenframe.models

data class Device(
    val name: Name,
    val landOffset: Bounds,
    val portOffset: Bounds,
    val screenSize: Bounds,
    val physicalSize: Float,
    val id: String
) {
    fun getShadowResource(orientation: Orientation) = id.plus("_").plus(orientation.id).plus("_shadow")
    fun getBackgroundResource(orientation: Orientation) = id.plus("_").plus(orientation.id).plus("_back")
    fun getGlareResource(orientation: Orientation) = id.plus("_").plus(orientation.id).plus("_glare")
    fun getThumbResource(orientation: Orientation) = id.plus("_").plus(orientation.id).plus("_thumb")
}