package lib.screenframe.models

data class Config(
    val name: Name?,
    val shadowEnabled: Boolean,
    val glareEnabled: Boolean,
    val background: Background?
)