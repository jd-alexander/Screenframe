package lib.screenframe

import android.app.Activity
import android.graphics.Bitmap
import lib.screenframe.models.Strategy
import tools.fastlane.screengrab.*

class ScreenframeStrategy(private val strategy: Strategy = Strategy.Default, private val activity: Activity) : ScreenshotStrategy {
    override fun takeScreenshot(screenshotName: String?, screenshotCallback: ScreenshotCallback?) {

        takeStrategyScreenshot(screenshotName,strategy, ScreenshotCallback { screenshot, bitmap ->
        })
    }

    private fun takeStrategyScreenshot(screenshotName: String?, strategy: Strategy, screenshotCallback: ScreenshotCallback) {
        return when (strategy) {
            Strategy.Falcon -> FalconScreenshotStrategy(activity).takeScreenshot(screenshotName) { screenshot, bitmap ->
                screenshotCallback.screenshotCaptured(screenshot, bitmap)
            }
            Strategy.UIAutomator -> UiAutomatorScreenshotStrategy().takeScreenshot(screenshotName) { screenshot, bitmap ->
                screenshotCallback.screenshotCaptured(screenshot, bitmap)
            }
            Strategy.Default -> DecorViewScreenshotStrategy().takeScreenshot(screenshotName) { screenshot, bitmap ->
                screenshotCallback.screenshotCaptured(screenshot, bitmap)
            }
        }
    }
}