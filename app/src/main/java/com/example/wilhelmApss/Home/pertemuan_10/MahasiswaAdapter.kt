package com.example.wilhelmApss.Home.pertemuan_10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wilhelmApss.databinding.ItemMahasiswaBinding

class MahasiswaAdapter(
    private val listMahasiswa: List<Mahasiswa>,
    private val onItemClick: (Mahasiswa) -> Unit
) : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    inner class MahasiswaViewHolder(val binding: ItemMahasiswaBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val binding = ItemMahasiswaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MahasiswaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val mahasiswa = listMahasiswa[position]
        with(holder.binding) {
            tvNama.text = mahasiswa.nama
            tvNim.text = mahasiswa.nim
            ivFoto.setImageResource(mahasiswa.foto)

            root.setOnClickListener { onItemClick(mahasiswa) }
        }
    }

    override fun getItemCount(): Int = listMahasiswa.size
}
