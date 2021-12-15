package com.annhienktuit.circularrotationimageview
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.ImageView


@SuppressLint("AppCompatCustomView")
class CircularImageView : ImageView {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        val rectF = RectF(0F, 0F, width.toFloat(), height.toFloat())
        val path = Path()
        path.addRoundRect(rectF, radius, radius, Path.Direction.CW)
        canvas.clipPath(path)
        super.onDraw(canvas)
    }

    override fun setRotation(rotation: Float) {
        super.setRotation(rotation)
    }

    companion object {
        var radius = 1000f
    }
}