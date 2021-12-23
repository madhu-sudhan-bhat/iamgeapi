package com.example.apifetch.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.apifetch.R

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

//
        var gi = getIntent()
        var url = gi.getStringExtra("url")
        val fragment = FragmentDisplayImage.newInstance(url.toString())

        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.replace(R.id.imageActFrag, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}