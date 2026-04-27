package com.example.wilhelmApss.pertemuan7

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.wilhelmApss.R
import com.example.wilhelmApss.databinding.ActivitySeventhBinding

class SeventhActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeventhBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySeventhBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // --- KONFIGURASI TOOLBAR & BACK BUTTON ---
        setSupportActionBar(binding.toolbar7)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Munculkan tombol back
        supportActionBar?.title = "Pertemuan 7"

        // Fungsi ketika tombol back diklik
        binding.toolbar7.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        // ------------------------------------------

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (savedInstanceState == null) {
            replaceFragment(SatuFragment())
        }

        binding.btnFragment1.setOnClickListener {
            replaceFragment(SatuFragment())
        }

        binding.btnFragment2.setOnClickListener {
            replaceFragment(DuaFragment())
        }

        binding.btnFragment3.setOnClickListener {
            replaceFragment(TigaFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
