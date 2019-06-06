package lib.screenframe.models

data class ColorBackground(var backgroundColor: Int, override val backgroundPaddingPercent: Int?) : Background {
    override fun description() = "background as a solid color."
}
