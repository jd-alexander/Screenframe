package lib.screenframe.models

data class ColorBackground(var backgroundColor: Int) : Background {
    override fun description() = "background as a solid color."
}
