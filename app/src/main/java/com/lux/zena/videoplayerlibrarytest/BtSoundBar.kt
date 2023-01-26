package com.lux.zena.videoplayerlibrarytest

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet

class BtSoundBar : BtSeekBar {
    constructor(context: Context):super(context)
    constructor(context: Context, attrs:AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle:Int) : super(context, attrs, defStyle)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}