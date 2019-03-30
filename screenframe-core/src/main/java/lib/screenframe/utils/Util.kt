package lib.screenframe.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File

object Util {
    fun getBitmap(file: File): Bitmap {
        val options = BitmapFactory.Options()
        options.inPreferredConfig = Bitmap.Config.ARGB_8888
        return BitmapFactory.decodeFile(file.path, options)
    }
}
