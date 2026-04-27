package com.example.wilhelmApss.Home.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wilhelmApss.R
import com.example.wilhelmApss.databinding.ActivityThirdBinding

class ThidActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnKirim.setOnClickListener {
            val nomor = binding.inputNoTujuan.text
            Toast.makeText(this, "Pesan Berhasil Dikirim Ke $nomor", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ThirdResultctivity::class.java)
            startActivity(intent)
        }
    }
}
