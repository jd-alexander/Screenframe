package lib.screenframe.models

data class BlurBackground(var backgroundBlurRadius: Int, override val backgroundPaddingPercent: Int?) : Background {
    override fun description() = "with a blurred background"
}
