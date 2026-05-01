package com.example.wilhelmApss.Home.pertemuan_10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wilhelmApss.R
import com.example.wilhelmApss.databinding.FragmentTabABinding

class TabAFragment : Fragment() {

    private var _binding: FragmentTabABinding? = null
    private val binding get() = _binding!!

    // Data Dummy Mahasiswa
    private val listData = listOf(
        Mahasiswa("Wilhelm", "2255301001", R.drawable.foto_wilhelm),
        Mahasiswa("Ahmad Fikri", "2255301002", R.drawable.foto_wilhelm),
        Mahasiswa("Siti Aminah", "2255301003", R.drawable.foto_wilhelm),
        Mahasiswa("Budi Santoso", "2255301004", R.drawable.foto_wilhelm),
        Mahasiswa("Dewi Lestari", "2255301005", R.drawable.foto_wilhelm)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mAdapter = MahasiswaAdapter(listData) { mahasiswa ->
            Toast.makeText(requireContext(), "Klik: ${mahasiswa.nama}", Toast.LENGTH_SHORT).show()
        }

        binding.rvMahasiswa.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
