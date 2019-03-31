package lib.screenframe.core

import lib.screenframe.models.Config

abstract class StateLogger {
    protected fun log(config: Config) {
        val message = "Generating screenshot with " + config.background?.description() + ","

        if (config.glareEnabled) {
            message.plus("with glare,")
        }

        if (config.shadowEnabled) {
            message.plus("with a shadow.")
        }

        log(message)
    }

    abstract fun log(message: String)
}