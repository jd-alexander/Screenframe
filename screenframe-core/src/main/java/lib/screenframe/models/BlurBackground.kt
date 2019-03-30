package lib.screenframe.models

data class BlurBackground(var backgroundBlurRadius: Int) : Background {
    override fun description() = "with a blurred background"
}
