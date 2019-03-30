package lib.screenframe.models

enum class Name(private val value: String) {
    Nexus6("Nexus 6"),
    Nexus5("Nexus 5");

    override fun toString() = value
}