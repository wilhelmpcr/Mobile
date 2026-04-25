package com.example.wilhelmApss

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.wilhelmApss.databinding.ActivityMainBinding
import com.example.wilhelmApss.pertemuan4.FourthActivity
import com.example.wilhelmApss.pertemuan5.WebViewActivity
import com.example.wilhelmApss.pertemuan6.WebActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Home"

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)

            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)

            startActivity(intent)
        }

        binding.btnGoWeb.setOnClickListener {
            val intent = Intent(this, WebActivity::class.java)
            startActivity(intent)
        }

        binding.bntLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    sharedPref.edit {
                        clear()
                        apply()
                    }
                    finish()
                    dialog.dismiss()
                    Log.e("Info Dialog", "User logged out")

                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}