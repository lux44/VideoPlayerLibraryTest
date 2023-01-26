package com.lux.zena.videoplayerlibrarytest.fragment

import android.app.Activity
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.lux.zena.videoplayerlibrarytest.MainActivity
import com.lux.zena.videoplayerlibrarytest.databinding.FragmentVideoPlayerBinding

class VideoPlayerFragment : Fragment(){
    private val binding:FragmentVideoPlayerBinding by lazy { FragmentVideoPlayerBinding.inflate(layoutInflater) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}