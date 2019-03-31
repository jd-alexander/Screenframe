package lib.screenframe.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File

object Util {
    fun getBitmap(file: File): Bitmap {
        val options = BitmapFactory.Options()
        options.inPreferredConfig = Bitmap.Config.ARGB_8888
        return BitmapFactory.decodeFile(file.path, options)
    }

    fun decodeDeviceResource(context: Context, resourceName: String): Bitmap? {
        val options = BitmapFactory.Options()
        options.inMutable = true

        val resourceId = getResourceIdentifierForDrawable(context, resourceName)

        return if (resourceId != null) {
            BitmapFactory.decodeResource(context.resources, resourceId, options)
        } else {
            null
        }
    }

    private fun getResourceIdentifierForDrawable(context: Context, resourceName: String) = context.resources?.getIdentifier(resourceName, "drawable", context.packageName)
}
