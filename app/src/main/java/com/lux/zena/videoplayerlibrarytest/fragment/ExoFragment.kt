package com.lux.zena.videoplayerlibrarytest.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.lux.zena.videoplayerlibrarytest.BtBrightnessBar
import com.lux.zena.videoplayerlibrarytest.BtSeekBar
import com.lux.zena.videoplayerlibrarytest.BtSoundBar
import com.lux.zena.videoplayerlibrarytest.R
import com.lux.zena.videoplayerlibrarytest.databinding.FragmentExoBinding

class ExoFragment:Fragment() {

    private val binding:FragmentExoBinding by lazy { FragmentExoBinding.inflate(layoutInflater) }
    val exoPlayer by lazy { ExoPlayer.Builder(requireContext()).setSeekBackIncrementMs(3000L).setSeekForwardIncrementMs(5000L).build() }
    val videoUri: Uri = Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4")
    val close:RelativeLayout by lazy { requireView().findViewById(R.id.exo_close) }
    val back:ImageView by lazy { requireView().findViewById(R.id.exo_back) }
    val brightnessBar:BtBrightnessBar by lazy { requireView().findViewById(R.id.bt_brightness_bar) }
    val soundBar:BtSoundBar by lazy { requireView().findViewById(R.id.bt_sound_bar) }
    var prevX:Int = 0
    var prevY:Int = 0
    var seekBar: BtSeekBar? = null




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.exoView.player  = exoPlayer
        val mediaItem = MediaItem.fromUri(videoUri)
        close.setOnClickListener {
            Log.e("TAG","영상 끝!!!!!!!!~~~~~~~~~~~")
            AlertDialog.Builder(requireContext()).setMessage("영상을 종료하시겠습니까?").setPositiveButton("종료"
            ) { dialog, which ->
                Log.e("Positive","dialog : $dialog, which : $which")
                Toast.makeText(requireContext(), "영상 끝!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
            }.setNegativeButton("아니오"
            ) { dialog, which ->
                Log.e("Negative","dialog : $dialog, which : $which")
                Toast.makeText(requireContext(), "운동 더할거야", Toast.LENGTH_SHORT).show()
            }.create().show()
        }
        back.setOnClickListener {
            Toast.makeText(requireContext(), "뒤로가기뒤로뒤로뒤로", Toast.LENGTH_SHORT).show()
        }

        brightnessBar.let {
            it.thumb= null
            it.visibility = View.INVISIBLE
        }

        soundBar.let {
            it.thumb = null
            it.visibility = View.INVISIBLE
        }

        binding.exoView.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                var posX = event!!.x.toInt()
                var posY = event!!.y.toInt()
                val detector:GestureDetector = GestureDetector(requireContext(),
                    object : GestureDetector.OnGestureListener {
                        override fun onDown(e: MotionEvent?): Boolean {
                            Log.e("onDown","다운")
                            return true
                        }

                        override fun onShowPress(e: MotionEvent?) {

                        }

                        override fun onSingleTapUp(e: MotionEvent?): Boolean {
                            return true
                        }

                        override fun onScroll(
                            e1: MotionEvent?,
                            e2: MotionEvent?,
                            distanceX: Float,
                            distanceY: Float
                        ): Boolean {
                            Log.e("e2","${e2.toString()}, ${e2?.action}")
                            Log.e("distanceX - posX", "$distanceX, $posX")
                            Log.e("distanceY - posY", "$distanceY, $posY")



                            return true
                        }

                        override fun onLongPress(e: MotionEvent?) {

                        }

                        override fun onFling(
                            e1: MotionEvent?,
                            e2: MotionEvent?,
                            velocityX: Float,
                            velocityY: Float
                        ): Boolean {
                            Log.e("onFling","fling : ${e2?.action}")
                            return true
                        }

                    })
                detector.onTouchEvent(event)
                return false
            }

        })

        seekBar = soundBar


        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.play()
    }



    override fun onPause() {
        super.onPause()
        exoPlayer.pause()
    }




}