package lib.screenframe.core

import lib.screenframe.models.Config

abstract class StateLogger {
    protected fun log(config: Config) {

        val message = "Generating screenshot with " + config.background?.description() + config.glareEnabled
}

abstract fun log(message: String)
}