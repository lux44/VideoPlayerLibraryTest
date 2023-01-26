package com.lux.zena.videoplayerlibrarytest

import android.content.Context
import android.util.AttributeSet
import android.widget.SeekBar

open class BtSeekBar : androidx.appcompat.widget.AppCompatSeekBar {
    constructor(context: Context) : super(context)
     constructor(context: Context, attrs: AttributeSet) : super(context,attrs)
    constructor(context: Context, attrs:AttributeSet, defStyle:Int):super(context, attrs)
}