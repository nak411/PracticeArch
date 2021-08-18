package com.naveed.practice_arch.legacy

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naveed.practice_arch.R
import com.naveed.practice_arch.databinding.ActivityLegacyBinding

class LegacyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLegacyBinding

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, LegacyActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLegacyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.lToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, LegacyFragment())
            .commit()
    }
}