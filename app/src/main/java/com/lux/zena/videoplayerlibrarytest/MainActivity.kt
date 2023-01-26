package com.lux.zena.videoplayerlibrarytest

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.lux.zena.videoplayerlibrarytest.databinding.ActivityMainBinding
import com.lux.zena.videoplayerlibrarytest.fragment.ExoFragment
import com.lux.zena.videoplayerlibrarytest.fragment.VideoPlayerFragment

class MainActivity : AppCompatActivity() {

    private val binding:ActivityMainBinding by lazy { ActivityMainBinding.inflate(LayoutInflater.from(this)) }
    private val fragments:MutableList<Fragment> by lazy { mutableListOf() }
    companion object{
        val videoUri: Uri = Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        fragments.add(ExoFragment())
        fragments.add(VideoPlayerFragment())

        supportFragmentManager.beginTransaction().add(R.id.container, fragments[0]).commit()

        binding.bnv.setOnItemSelectedListener { menuItem->
            supportFragmentManager.fragments.forEach {
                supportFragmentManager.beginTransaction().hide(it).commit()
            }
            val tran = supportFragmentManager.beginTransaction()
            when(menuItem.itemId) {
                R.id.menu_exo -> {
                    tran.show(fragments[0])
                }
                R.id.menu_test -> {
                    if (!supportFragmentManager.fragments.contains(fragments[1])) tran.add(R.id.container, fragments[1])
                    tran.show(fragments[1])
                }
            }
            tran.commit()
            true
        }
    }
}