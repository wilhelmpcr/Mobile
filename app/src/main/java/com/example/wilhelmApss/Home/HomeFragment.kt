package com.example.wilhelmApss.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.wilhelmApss.Home.pertemuan2.SecondActivity
import com.example.wilhelmApss.Home.pertemuan3.ThidActivity
import com.example.wilhelmApss.Home.pertemuan4.FourthActivity
import com.example.wilhelmApss.Home.pertemuan5.FifthActivity
import com.example.wilhelmApss.Home.pertemuan5.WebActivity
import com.example.wilhelmApss.Home.pertemuan7.SeventhActivity
import com.example.wilhelmApss.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnToSecond.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        binding.btnToThird.setOnClickListener {
            startActivity(Intent(requireContext(), ThidActivity::class.java))
        }

        binding.btnToFourth.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
        }

        binding.btnToFifth.setOnClickListener {
            startActivity(Intent(requireContext(), FifthActivity::class.java))
        }

        binding.btnToSixth.setOnClickListener {
            // Karena package pertemuan6 kosong, saya arahkan ke WebActivity sebagai contoh
            startActivity(Intent(requireContext(), WebActivity::class.java))
        }

        binding.btnToSeventh.setOnClickListener {
            startActivity(Intent(requireContext(), SeventhActivity::class.java))
        }

        binding.bntLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    sharedPref.edit {
                        clear()
                        apply()
                    }
                    requireActivity().finish()
                    dialog.dismiss()
                    Log.e("Info Dialog", "User logged out")
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
