package lib.screenframe.fastlane

import android.app.Activity
import lib.screenframe.Screenframe
import lib.screenframe.fastlane.models.Strategy
import lib.screenframe.models.Config
import tools.fastlane.screengrab.DecorViewScreenshotStrategy
import tools.fastlane.screengrab.FalconScreenshotStrategy
import tools.fastlane.screengrab.ScreenshotCallback
import tools.fastlane.screengrab.ScreenshotStrategy
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy

/**
 * Wraps the different Screenshot Strategies that are used within Screengrab for screenshot generation.
 */
class ScreenframeStrategy(private val config: Config, private val activity: Activity, private val strategy: Strategy = Strategy.Default) : ScreenshotStrategy {
    override fun takeScreenshot(screenshotName: String?, screenshotCallback: ScreenshotCallback?) {

        takeStrategyScreenshot(screenshotName, strategy, ScreenshotCallback { screenshot, bitmap ->
            val framedScreenshot = Screenframe.generate(bitmap, config,activity)
            screenshotCallback?.screenshotCaptured(screenshot, framedScreenshot)
        })
    }

    private fun takeStrategyScreenshot(screenshotName: String?, strategy: Strategy, screenshotCallback: ScreenshotCallback) {
        return when (strategy) {
            Strategy.Falcon -> FalconScreenshotStrategy(activity).takeScreenshot(screenshotName) { screenshot, bitmap ->
                screenshotCallback.screenshotCaptured(screenshot, bitmap)
            }
            Strategy.UiAutomator -> UiAutomatorScreenshotStrategy().takeScreenshot(screenshotName) { screenshot, bitmap ->
                screenshotCallback.screenshotCaptured(screenshot, bitmap)
            }
            Strategy.Default -> DecorViewScreenshotStrategy().takeScreenshot(screenshotName) { screenshot, bitmap ->
                screenshotCallback.screenshotCaptured(screenshot, bitmap)
            }
        }
    }
}