package lib.screenframe

import android.app.Activity
import lib.screenframe.models.ScreenshotSource
import tools.fastlane.screengrab.*

class ScreenframeStrategy(private val screenshotSource: ScreenshotSource = ScreenshotSource.Default, private val activity: Activity) : ScreenshotStrategy {
    override fun takeScreenshot(screenshotName: String?, screenshotCallback: ScreenshotCallback?) {

    }

    private fun takeScreenshot(screenshotName: String, screenshotSource: ScreenshotSource, screenshotCallback: ScreenshotCallback) {
        return when (screenshotSource) {
            ScreenshotSource.Falcon -> FalconScreenshotStrategy(activity).takeScreenshot(screenshotName) { screenshot, bitmap ->
                screenshotCallback.screenshotCaptured(screenshot, bitmap)
            }
            ScreenshotSource.UIAutomator -> UiAutomatorScreenshotStrategy().takeScreenshot(screenshotName) { screenshot, bitmap ->
                screenshotCallback.screenshotCaptured(screenshot, bitmap)
            }
            ScreenshotSource.Default -> DecorViewScreenshotStrategy().takeScreenshot(screenshotName) { screenshot, bitmap ->
                screenshotCallback.screenshotCaptured(screenshot, bitmap)
            }
        }
    }
}