package com.overazumov.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.overazumov.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportFragmentManager.findFragmentByTag(FragmentA.TAG) == null) {
            supportFragmentManager.commit {
                add(R.id.fragmentContainerA, FragmentA.newInstance(), FragmentA.TAG)
            }
        }
    }
}