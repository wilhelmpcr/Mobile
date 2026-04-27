package com.example.wilhelmApss.Home.pertemuan6

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wilhelmApss.BaseActivity
import com.example.wilhelmApss.R
import com.example.wilhelmApss.databinding.ActivityAuthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import androidx.core.content.edit

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            val username = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (username == password && username.isNotEmpty()) {
                sharedPref.edit {
                    putBoolean("isLogin", true)
                    putString("username", username)
                }

                val intent = Intent(this, BaseActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Konfirmasi")
                    .setMessage("Apakah Anda yakin ingin melanjutkan?")
                    .setPositiveButton("Ya") { dialog, _ ->
                        dialog.dismiss()
                        Log.e("Info Dialog", "Anda memilih Ya!")
                    }
                    .show()
            }
        }
    }
}
