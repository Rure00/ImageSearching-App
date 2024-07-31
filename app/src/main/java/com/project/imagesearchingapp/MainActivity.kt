package com.project.imagesearchingapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.project.imagesearchingapp.data.ImageData
import com.project.imagesearchingapp.databinding.ActivityMainBinding
import com.project.imagesearchingapp.fragment.MyArchiveFragment
import com.project.imagesearchingapp.fragment.SearchingFragment
import com.project.imagesearchingapp.model.SharedPreferenceUtils

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var fragmentIndex = 0
    private lateinit var preferencesUtils: SharedPreferenceUtils

    val likedImages = mutableListOf<ImageData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        preferencesUtils = SharedPreferenceUtils(this)

        likedImages.addAll(preferencesUtils.getImages())

        supportFragmentManager.beginTransaction()
            .add(R.id.main_fragment_container, SearchingFragment()).commitNow()

        binding.searchingTabBtn.setOnClickListener {
            if(fragmentIndex == 0) return@setOnClickListener
            fragmentIndex = 0
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, SearchingFragment()).commitNow()
        }
        binding.archiveTabBtn.setOnClickListener {
            if(fragmentIndex == 1) return@setOnClickListener
            fragmentIndex = 1
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, MyArchiveFragment()).commitNow()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        preferencesUtils.saveImages(likedImages)
    }

}